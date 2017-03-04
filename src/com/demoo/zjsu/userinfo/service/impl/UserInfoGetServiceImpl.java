package com.demoo.zjsu.userinfo.service.impl;

import com.demoo.zjsu.entity.UserInfo;

public interface UserInfoGetServiceImpl {

	/**
	 * 获取openid
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return 
	 */
	public UserInfo userInfoGet(String appId ,String appSecret, String code);
	
}
