package com.demoo.zjsu.userinfo.service;

import com.demoo.zjsu.dao.UserAllDao;
import com.demoo.zjsu.entity.UserInfo;
import com.demoo.zjsu.userinfo.service.impl.UserInfoServiceImpl;

public class UserInfoService implements UserInfoServiceImpl {
	
	private UserAllDao userAllDao = new UserAllDao();

	@Override
	public UserInfo userExistJudgeByOpenid(String openid) {
		int existFlag = 0;
		UserInfo userInfo = null;
		try {
			userInfo = userAllDao.userinfoExistJudgeByOpenid(openid);
		} catch (Exception e) {
			System.out.println("写入日志文件");
			e.printStackTrace();
		}
		return userInfo;
	}

}
