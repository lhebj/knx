package com.knx.weather;

import java.net.URLEncoder;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.knx.web.util.DateUtil;
import com.knx.web.util.HttpClientUtil;

/**
 * 中国人民共和国环保部数据中心
 */
public class MepGovAQI implements AQI{

	public static String BEIJING_CODE = "北京市";
	private static long LAST_CACHE_TIME = 0;
	private long MAX_CACHE_TIME = 1200 * 1000; //MilliSecond

	private static AQIData aqiData;
	private String dataQueryUrl = "http://datacenter.mep.gov.cn/report/airDairyCityHourAction.do?city={0}&startdate={1}&location=rq";
//	private String dataQueryUrl = "http://datacenter.mep.gov.cn/report/air_daily/airDairyCityHourMain.jsp?city={0}";

	@Override
	public AQIData getCurrentAQI(String cityCode) {
		// TODO Auto-generated method stub
		// TODO cache
		long datetime = new Date().getTime();
		if (datetime - LAST_CACHE_TIME > MAX_CACHE_TIME || aqiData == null) {
			this.fetchAQI(cityCode);
			LAST_CACHE_TIME = datetime;
		}

		return aqiData;
	}

	@Override
	public void fetchAQI(String cityCode) {
		if (cityCode == null) {
			return;
		}
		try {
			String oneHourBefore = DateUtil.deSerialize(DateUtil.getBefore(new Date(), 1, DateUtil.HOUR), "yyyy-MM-dd HH:mm").replaceFirst(":[\\d]{2}", ":00");
			String twoHourBefore = DateUtil.deSerialize(DateUtil.getBefore(new Date(), 2, DateUtil.HOUR), "yyyy-MM-dd HH:mm").replaceFirst(":[\\d]{2}", ":00");			
			
			String qurl = dataQueryUrl.replace("{0}", URLEncoder.encode(cityCode, "GBK")).replace("{1}", URLEncoder.encode(oneHourBefore, "GBK"));
			String aqiInfo = HttpClientUtil.getInstance().getResponseByGetMethod(qurl, "GBK", false);
			
			if(aqiInfo.indexOf("AQI指数为")<0){
				qurl = dataQueryUrl.replace("{0}", URLEncoder.encode(cityCode, "GBK")).replace("{1}", URLEncoder.encode(twoHourBefore, "GBK"));
				aqiInfo = HttpClientUtil.getInstance().getResponseByGetMethod(qurl, "GBK", false);
			}
			if(aqiInfo.indexOf("AQI指数为")<0){
				System.out.println(aqiInfo);
				return;
			}
			aqiInfo=aqiInfo.substring(aqiInfo.indexOf("AQI指数为")).replaceAll("\\s", "").replaceAll("/n", "");
			System.out.println(aqiInfo);
			Pattern pattern = Pattern.compile("AQI指数为[\\s\\S]*?[1234567890]*");
			Matcher m = pattern.matcher(aqiInfo);
			if (m.find()) {
				aqiInfo = m.group();
				System.out.println(aqiInfo);
				AQIData myAQIData = new AQIData();
				String aqi = aqiInfo.substring(aqiInfo.indexOf("AQI指数为") + 6);
				myAQIData.setAqi(aqi);
				aqiData = myAQIData;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		AQI aqi = new MepGovAQI();
		System.out.println(aqi.getCurrentAQI(BEIJING_CODE).getAqi());
		System.out.println(aqi.getCurrentAQI(BEIJING_CODE).getAqi());
		
	}

}
