package com.knx.controller.user;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acegisecurity.providers.dao.DaoAuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.knx.pojo.Authority;
import com.knx.pojo.User;
import com.knx.pojo.UserAuthority;
import com.knx.service.user.IUserService;
import com.knx.web.util.CommonStaticConst;
import com.knx.web.util.JSONHelperUtil;
import com.knx.web.util.MD5Util;
import com.knx.web.util.ParamUtils;
import com.knx.web.util.RunAsAdminManager;
import com.knx.web.util.StringUtil;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Resource
	private IUserService userService;

	@Resource
	private DaoAuthenticationProvider daoAuthenticationProvider;

	@RequestMapping("/register.do")
	public String regist(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = ParamUtils.getParameter(request, "username");
		String email = ParamUtils.getParameter(request, "email");
		String weixin = ParamUtils.getParameter(request, "weixin");
		String password = ParamUtils.getParameter(request, "p");
		String pc = ParamUtils.getParameter(request, "pc");
		Boolean ajax = ParamUtils.getBooleanParameter(request, "ajax");

		if (username == null) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username error!", response);
			return null;
		}
		if (password == null || pc == null || !password.equals(pc)) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "password error!", response);
			return null;
		}
		// email
		if (!StringUtil.isEmail(email)) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "email error!", response);
			return null;
		}
		try {
			User user = userService.findUserByEmail(email);
			if (user != null) {
				JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "email is exist", response);
				return null;
			}
			user = userService.findUserByUsername(username);
			if (user != null) {
				JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "username is exist", response);
				return null;
			}
			String salt = User.generateSalt();
			String encryption = MD5Util.getMD5(MD5Util.getMD5( password + salt));
			user = new User();
			user.setUsernameU(username);
			user.setPasswordU(encryption);
			user.setSaltU(salt);
			user.setEmailU(email);
			user.setWeixinU(weixin);
			user.setDateRegisterU(new Date());
			user.setIpU(StringUtil.getRequestIp(request));
			user.setRefererU((String) WebUtils.getSessionAttribute(request, CommonStaticConst.REFERRING_SOURCE));
			user.setIsEnabledU(true);
			userService.saveOrUpdateUser(user);

			UserAuthority ua = new UserAuthority();
			ua.setIduUaut(user.getIdU());
			ua.setIdautUaut(Authority.ID_USER);
			userService.saveOrUpdateUserAuthority(ua);

			RunAsAdminManager.authenticationRestore(daoAuthenticationProvider, user);
		} catch (Exception e) {
			e.printStackTrace();
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.FALSE, "saveOrUpdate false!", response);
		}
		if (ajax) {
			JSONHelperUtil.outputOperationResultAsJSON(Boolean.TRUE, "success", response);
			return null;
		}
		JSONHelperUtil.outputOperationResultAsJSON(Boolean.TRUE, "success", response);
		return null;
//		return "redirect:/index.do";
	}
}
