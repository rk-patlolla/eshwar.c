package com.tejyasols.surveyApp.service;

import com.tejyasols.surveyApp.domain.UserInfo;


public interface UserInfoService {
	
	public UserInfo addUser(UserInfo userinfo);
	
	public UserInfo findByEmail(String email);

}
