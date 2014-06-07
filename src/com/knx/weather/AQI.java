package com.knx.weather;


public interface AQI {
	
	public AQIData getCurrentAQI(String cityCode);
	public void fetchAQI(String cityCode);
}
