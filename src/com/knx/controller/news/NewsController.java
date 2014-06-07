package com.knx.controller.news;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.News;
import com.knx.service.news.INewsService;
import com.knx.web.dto.NewsSimpleDTO;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.ParamUtils;

@Controller
@RequestMapping("/")
public class NewsController {

	@Resource(name = "newsService")
	private INewsService newsService;

	@RequestMapping("/news.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		Long id = ParamUtils.getLongParameter(request, "id", 0);
		try {
			News currentNews = null;
			if (id != 0) {
				currentNews = newsService.findNewsById(id);
				if (currentNews == null) {
					return "redirect:/error.do?action=1&message=" + URLEncoder.encode(LocalizationUtil.getClientString("PageNotFound", request), "utf-8");
				}

			}

			if (currentNews == null) {
				List<News> currentNewsList = newsService.getNewsList(0, 1);
				if (currentNewsList.size() > 0) {
					currentNews = currentNewsList.get(0);
				}else{
					return "news";
				}
			}

			model.addAttribute("currentNewsDTO", currentNews.toDTO());
			// 最多显示100条
			List<News> newsList = newsService.getNewsList(0, 100);
			List<NewsSimpleDTO> newsSimpleDtoList = new ArrayList<NewsSimpleDTO>();
			for (News news : newsList) {
				newsSimpleDtoList.add(news.toSimpleDTO());
			}
			model.addAttribute("newsSimpleDtoList", newsSimpleDtoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "news";
	}
}
