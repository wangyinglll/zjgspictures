package com.demoo.zjsu.userinfo.service.impl;

import com.demoo.zjsu.entity.UserInfo;

public interface UserInfoServiceImpl {
	
	/**
	 * 根据用户openid判断用户信息是否存在数据库中,返回null表示不在，否在表示存在
	 * @return
	 */
	public UserInfo userExistJudgeByOpenid(String openid);

}
