package com.knx.service.about;

import com.knx.pojo.About;

public interface IAboutService {
	public void saveOrUpdateAbout(About about);
	
	public About findAboutById(Long id);
	
	public void deleteAbout(About about);
	
	public About findAboutByType(String typeAb);
}
