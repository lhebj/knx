package com.knx.controller.index;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Index;
import com.knx.service.index.IIndexService;
import com.knx.web.dto.IndexDTO;

@Controller
@RequestMapping("/")
public class IndexController {

	@Resource(name = "indexService")
	private IIndexService indexService;
	
	@RequestMapping("/index.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {		
		
		List<Index> r1c1IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R1C1);
		List<IndexDTO> r1c1IndexDtoList = new ArrayList<IndexDTO>();
		for(Index index : r1c1IndexList){
			r1c1IndexDtoList.add(index.toDTO());
		}
		model.addAttribute("r1c1IndexDtoList", r1c1IndexDtoList);
		
		List<Index> r1c2IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R1C2);
		model.addAttribute("r1c2IndexDto", r1c2IndexList.size()>0?r1c2IndexList.get(0).toDTO():null);
		
		List<Index> r1c3IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R1C3);
		model.addAttribute("r1c3IndexDto", r1c3IndexList.size()>0?r1c3IndexList.get(0).toDTO():null);
		
		List<Index> r2c1IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R2C1);
		model.addAttribute("r2c1IndexDto", r2c1IndexList.size()>0?r2c1IndexList.get(0).toDTO():null);
		
		List<Index> r2c2IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R2C2);
		model.addAttribute("r2c2IndexDto", r2c2IndexList.size()>0?r2c2IndexList.get(0).toDTO():null);
		
		List<Index> r2c3IndexList = indexService.getRandomIndexListByPosition(Index.POSITION_R2C3);
		model.addAttribute("r2c3IndexDto", r2c3IndexList.size()>0?r2c3IndexList.get(0).toDTO():null);
		return "index";
	}
}
