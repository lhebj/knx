package com.knx.service.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.knx.pojo.User;
import com.knx.pojo.UserAuthority;

public interface IUserService {
	
	public void saveOrUpdateUser(User user);
	
	public User findUserDetailById(Long id);
	
	public User findUserByUsername(String username);
	
	public User findUserByEmail(String email);
	
	public void saveOrUpdateUserAuthority(UserAuthority userAuthority);
	
	public UserAuthority findUserAuthorityByUserId(Long userId);	
	
	public void deleteUser(User user);
	
	public List<User> getUserList (int start, int limit); 
	
	public Map<String, Object> accessControl(HttpServletRequest request, HttpServletResponse response);
	
	public int getUserTotalCount();
}
