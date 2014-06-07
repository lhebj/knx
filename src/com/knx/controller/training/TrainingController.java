package com.knx.controller.training;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Training;
import com.knx.service.training.ITrainingService;
import com.knx.web.dto.TrainingSimpleDTO;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.ParamUtils;

@Controller
@RequestMapping("/")
public class TrainingController {

	@Resource(name = "trainingService")
	private ITrainingService trainingService;

	@RequestMapping("/training.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		try {
			Training currentTraining = null;
			if (id != 0) {
				currentTraining = trainingService.findTrainingById(id);
				if (currentTraining == null) {
					return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
				}

			}

			if (currentTraining == null) {
				List<Training> currentTrainingList = trainingService.getTrainingList(0, 1);
				if (currentTrainingList.size() > 0) {
					currentTraining = currentTrainingList.get(0);
				}else{
					return "training";
				}
			}

			model.addAttribute("currentTrainingDTO", currentTraining.toDTO());
			// 最多显示100条
			List<Training> trainingList = trainingService.getTrainingList(0, 100);
			List<TrainingSimpleDTO> trainingSimpleDtoList = new ArrayList<TrainingSimpleDTO>();
			for (Training training : trainingList) {
				trainingSimpleDtoList.add(training.toSimpleDTO());
			}
			model.addAttribute("trainingSimpleDtoList", trainingSimpleDtoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "training";
	}
}
