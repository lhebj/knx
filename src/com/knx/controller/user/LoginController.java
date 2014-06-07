package com.knx.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knx.pojo.User;
import com.knx.service.user.IUserService;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.MD5Util;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.RunAsAdminManager;

@Controller
@RequestMapping("/")
public class LoginController {
	@Resource
	private IUserService userService;

	@Resource
	private DaoAuthenticationProvider daoAuthenticationProvider;

	@RequestMapping("/login.do")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		// TODO Auto-generated method stub
		String usernameOrEmail = ParamUtils.getParameter(request, "usernameOrEmail");
		String password = ParamUtils.getParameter(request, "password");
		if (usernameOrEmail == null) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username error!", response);
			return null;
		}
		if (password == null) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "password error!", response);
			return null;
		}
		User user = null;
		user = userService.findUserByUsername(usernameOrEmail);
		if (user == null) {
			user = userService.findUserByEmail(usernameOrEmail);
		}
		if (user != null) {
			String encryption = MD5Util.getMD5(MD5Util.getMD5( password + user.getSaltU()));
			if (encryption.equals(user.getPasswordU())) {
				RunAsAdminManager.authenticationRestore(daoAuthenticationProvider, user);
				JSONHelperUtil.outputOperationResultAsJSON(Boolean.TRUE, "success", response);
				return null;
			}
		}
		JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username or password error!", response);
		return null;
	}

}
