package com.knx.controller.cover;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.web.util.LogUtil;
import com.knx.web.util.StringUtil;
import com.weather.Weather;
import com.weather.WeatherComCnCityCode;
import com.weather.WeatherComCnWeather;
import com.weather.WeatherData;
import com.weather.aqi.AQI;
import com.weather.aqi.AQIData;
import com.weather.aqi.MepGovAQI;
import com.weather.aqi.SosoAQI;
import com.weather.geo.Geo;
import com.weather.geo.GeoData;
import com.weather.geo.SinaGeoImpl;



@Controller
@RequestMapping("/")
public class CoverController {

	@RequestMapping("/cover.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
//		Weather weather = new WeatherComCnWeather();
//		WeatherData wd = weather.getCurrentDayWeather(WeatherComCnWeather.BEIJING_CODE);
//		
//		model.addAttribute("weatherData",  wd);	
//		
//		AQI aqi = new MepGovAQI();
//		AQIData aqiData = aqi.getCurrentAQI(MepGovAQI.BEIJING_CODE);
//		model.addAttribute("aqiData",  aqiData);	
		
		try{
			String ip = StringUtil.getRequestIp(request);
			Geo geo = new SinaGeoImpl();
			GeoData geoData = geo.getGeoDataByIp(ip);
			LogUtil.log.info("cover geo: " + ip + ", " + geoData.getCountry()+", "+geoData.getProvince()+", "+geoData.getCity());
			Weather weather = new WeatherComCnWeather();
			WeatherData weatherData = weather.getCurrentDayWeather(WeatherComCnCityCode.CITY_CODE.get(geoData.getCity()));
			model.addAttribute("weatherData",  weatherData);	
			
			AQI aqi = new SosoAQI();
			AQIData myAQIData = aqi.getCurrentAQI(aqi.cityCodeAdapt(geoData.getCity()));
			if(myAQIData == null){
				aqi = new MepGovAQI();
				myAQIData = aqi.getCurrentAQI(aqi.cityCodeAdapt(geoData.getCity()));
			}
			model.addAttribute("aqiData",  myAQIData);	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "cover";
	}
}
