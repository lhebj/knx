package com.knx.controller.training;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Content;
import com.knx.pojo.Training;
import com.knx.service.content.IContentService;
import com.knx.service.training.ITrainingService;
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
 * @version 1.0.0 TrainingAdminController.java
 */
@Controller
@RequestMapping("/trainingAdmin.do")
public class TrainingAdminController {

	@Resource(name = "trainingService")
	private ITrainingService trainingService;

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
		String titleTra = ParamUtils.getParameter(request, "titleTra");
		String contentTra = ParamUtils.getParameter(request, "contentTra");
		try {
			Map<String, Object> map = UploadFileUtil.uploadOneFile(request, Content.SRC_CON_NEWS, KnxConfig.MAX_UPLOADSIZE);
			boolean isSuccess = (Boolean) map.get(UploadFileUtil.SUCCESS);
			// TODO
			Training training = null;
			if (id != 0) {
				training = trainingService.findTrainingById(id);
			}
			
			if(training == null){
				training = new Training();
			}
			
			if (isSuccess==true && map.get(UploadFileUtil.UPLOAD_FILE) != null) {
				Content content = (Content) map.get(UploadFileUtil.UPLOAD_FILE);
				contentService.saveOrUpdateContent(content);
				training.setPic(content);
			}
			training.setDateCreateTra(new Date());
			training.setContentTra(StringUtil.filterWordFormatAndSomeHTML(contentTra));
			training.setTitleTra(titleTra);
			trainingService.saveOrUpdateTraining(training);
			LogUtil.log.info(WebUtil.getUserId(request) + " saves training id " + training.getIdTra());
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		return "redirect:/admin.do?action=manageTraining";
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

			Training training = trainingService.findTrainingById(id);
			if (training == null) {
				LogUtil.log.info(WebUtil.getUserId(request) + " deletes Training id " + id + ", id doesn't exist");
				return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("Parameter.error", request), "utf-8");
			}
			contentService.deleteContent(training.getPic());
			trainingService.deleteTraining(training);
			LogUtil.log.info(WebUtil.getUserId(request) + " deletes Training id " + id);
		} catch (Exception e) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "Delete false!", response);
			e.printStackTrace();
		}
		return "redirect:/admin.do?action=manageTraining";
	}

}
