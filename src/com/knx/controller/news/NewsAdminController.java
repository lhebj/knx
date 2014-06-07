package com.knx.controller.news;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Content;
import com.knx.pojo.News;
import com.knx.service.content.IContentService;
import com.knx.service.news.INewsService;
import com.knx.web.upload.UploadFileUtil;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.KnxConfig;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.LogUtil;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.StringUtil;
import com.knx.web.util.WebUtil;

/**
 * 资讯数据接口
 * 
 * @version 1.0.0 NewsAdminController.java
 */
@Controller
@RequestMapping("/newsAdmin.do")
public class NewsAdminController {

	@Resource(name = "newsService")
	private INewsService newsService;

	@Resource
	private IContentService contentService;

	/**
	 * 添加资讯
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(params = "action=save")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		String titleN = ParamUtils.getParameter(request, "titleN");
		String contentN = ParamUtils.getParameter(request, "contentN");
		try {
			Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_NEWS, KnxConfig.MAX_UPLOADSIZE);
			boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
			// TODO
			News news = null;
			if (id != 0) {
				news = newsService.findNewsById(id);
			}
			
			if(news == null){
				news = new News();
			}
			
			if (isSuccess==true && map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				news.setPic(content);
			}
			news.setDateCreateN(new Date());
			news.setContentN(StringUtil.filterWordFormatAndSomeHTML(contentN));
			news.setTitleN(titleN);
			newsService.saveOrUpdateNews(news);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves news id " + news.getIdN());
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageNews";
	}

	/**
	 * 删除资讯
	 * 
	 * @param request
	 * @param response
	 * @return String
	 */
	@RequestMapping(params = "action=delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);

		try {
			if (id == 0) {
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}

			News news = newsService.findNewsById(id);
			if (news == null) {
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes News id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			contentService.deleteContent(news.getPic());
			newsService.deleteNews(news);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes News id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageNews";
	}

}
