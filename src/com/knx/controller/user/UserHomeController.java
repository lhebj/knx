package com.knx.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.Authority;
import com.knx.pojo.User;
import com.knx.pojo.UserAuthority;
import com.knx.service.user.IUserService;
import com.knx.web.util.WebUtil;

@Controller
@RequestMapping("/userHome.do")
public class UserHomeController {

	@Resource(name = "userService")
	private IUserService userService;
	
	@RequestMapping(params = "action=home")
	public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
//		String fromurl = ParamUtils.getParameter(request, "fromurl");
//		if(fromurl != null){
//			return "redirect:"+fromurl;	
//		}
		String username = WebUtil.getUserId(request);
		User user = userService.findUserByUsername(username);
		UserAuthority ua = userService.findUserAuthorityByUserId(user.getIdU());
		if(ua !=null && ua.getIdautUaut().equals(Authority.ID_ADMIN)){
			return "redirect:admin.do?action=home";
		}
		return "index";
	}
}
