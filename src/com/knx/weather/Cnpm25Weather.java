package com.knx.weather;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.knx.web.util.HttpClientUtil;

public class Cnpm25Weather implements Weather {
	public static String BEIJING_CODE = "beijing";
	private static long LAST_CACHE_TIME=0;
	private long MAX_CACHE_TIME = 3600 * 1000; //MilliSecond

	private static WeatherData weatherData;
		
	private String queryUrl = "http://www.cnpm25.cn/city/{0}.html";
	
	private final Pattern weather_pattern = Pattern.compile("\\<td>[1234567890]*μg\\/m³\\<img");
	
	private static Map<String,String> weekMap = new HashMap<String,String>();
	
	static{
		weekMap.put("Mon", "星期一");
		weekMap.put("Tue", "星期二");
		weekMap.put("Wed", "星期三");
		weekMap.put("Thu", "星期四");
		weekMap.put("Fri", "星期五");
		weekMap.put("Sat", "星期六");
		weekMap.put("Sun", "星期天");
	}
	
	
	@Override
	public WeatherData getCurrentDayWeather(String cityCode) {
		// TODO Auto-generated method stub
				// TODO cache
				long datetime = new Date().getTime();
				if (datetime - LAST_CACHE_TIME > MAX_CACHE_TIME || weatherData == null) {
					this.fetchWeather(cityCode);
					LAST_CACHE_TIME = datetime;
				}

				return weatherData;
	}

	@Override
	public List<WeatherData> getWeeklyWeather(String cityCode) {
		// TODO Auto-generated method stub
				return null;
	}
	
	@Override
	public void fetchWeather(String cityCode){
		if(cityCode == null ){
			return ;
		}
		String qurl = queryUrl.replace("{0}", cityCode);
		String weatherInfo = HttpClientUtil.getInstance().getResponseByGetMethod(qurl, "utf-8", false);
		Matcher m = weather_pattern.matcher(weatherInfo);
		try{			     
			if(m.find()){
//				System.out.println(m.group());
				String[] info = m.group().split("/n");	
				WeatherData wd ;
				for(String item: info){
					wd = new WeatherData();
					String pm25 = item.substring(item.indexOf("<td>")+4, item.indexOf("μg/m³"));
					wd.setPm25(pm25);
					weatherData = wd;
					break; // 取第一条的PM2.5，北京第一条为美国大使馆
				}			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Weather weather = new Cnpm25Weather();
//		weather.fetchWeather("beijing");
		System.out.println(weather.getCurrentDayWeather("beijing").getPm25());
		System.out.println(weather.getCurrentDayWeather("beijing").getPm25());
		
		long datetime = new Date().getTime();
		System.out.println(datetime);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datetime = new Date().getTime();
		System.out.println(datetime);
	}

}
