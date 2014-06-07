package com.knx.service.content;

import com.knx.pojo.Content;

public interface IContentService {

	public void saveOrUpdateContent(Content content);
	
	public Content findContentDetailById(Long id);
	
	public void deleteContent(Content content);
}
