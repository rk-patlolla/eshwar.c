package com.tejyasols.surveyApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejyasols.surveyApp.domain.UserInfo;
import com.tejyasols.surveyApp.repository.UserInfoRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoRepository userInfoRepository;

	@Override
	public UserInfo addUser(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return userInfoRepository.save(userinfo);
	}

	@Override
	public UserInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		return userInfoRepository.findByEmail(email);
	}

}
