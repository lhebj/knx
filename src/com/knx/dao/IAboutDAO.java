package com.knx.dao;

import com.knx.pojo.About;

public interface IAboutDAO {
	public void saveOrUpdateAbout(About about);
	
	public About findAboutById(Long id);
	
	public void deleteAbout(About about);
	
	public About findAboutByType(String typeAb);
}
