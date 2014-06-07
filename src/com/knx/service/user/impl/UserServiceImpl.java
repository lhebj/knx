package com.knx.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.knx.dao.IUserDAO;
import com.knx.pojo.User;
import com.knx.pojo.UserAuthority;
import com.knx.service.user.IUserService;
import com.knx.web.util.LocalizationUtil;
import com.knx.web.util.WebUtil;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDAO userDAO;
	
	@Override
	public void saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveOrUpdateUser(user);
	}

	@Override
	public User findUserDetailById(Long id) {
		// TODO Auto-generated method stub
		return userDAO.findUserDetailById(id);
	}

	
	
	public User findUserByUsername(String username){
		return userDAO.findUserByUsername(username);
	}
	
	public User findUserByEmail(String email){
		return userDAO.findUserByEmail(email);
	}
	
	public void saveOrUpdateUserAuthority(UserAuthority userAuthority){
		userDAO.saveOrUpdateUserAuthority(userAuthority);
	}
	
	public UserAuthority findUserAuthorityByUserId(Long userId){
		return userDAO.findUserAuthorityByUserId(userId);
	}
	
	
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userDAO.deleteUser(user);
	}

	@Override
	public List<User> getUserList(int start, int limit) {
		// TODO Auto-generated method stub
		return userDAO.getUserList(start, limit);
	}
	
	@Override
	public Map<String, Object> accessControl(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		if (!WebUtil.getUserId(request).equalsIgnoreCase(User.ADMIN)){
			map.put("message", LocalizationUtil.getClientString("Permission.deny", request));
			map.put("access", false);
			return map;
		}
		map.put("access", true);
		return map;
	}
	
	public int getUserTotalCount(){
		return userDAO.getUserTotalCount();
	}

}
