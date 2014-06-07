package com.knx.controller.cover;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.weather.AQI;
import com.knx.weather.AQIData;
import com.knx.weather.MepGovAQI;
import com.knx.weather.Weather;
import com.knx.weather.WeatherComCnWeather;
import com.knx.weather.WeatherData;

@Controller
@RequestMapping("/")
public class CoverController {

	@RequestMapping("/cover.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		Weather weather = new WeatherComCnWeather();
		WeatherData wd = weather.getCurrentDayWeather(WeatherComCnWeather.BEIJING_CODE);
		
		model.addAttribute("weatherData",  wd);	
		
		AQI aqi = new MepGovAQI();
		AQIData aqiData = aqi.getCurrentAQI(MepGovAQI.BEIJING_CODE);
		model.addAttribute("aqiData",  aqiData);	
		return "cover";
	}
}
