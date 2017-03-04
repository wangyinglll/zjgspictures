package com.demoo.zjsu.dao.impl;

import com.demoo.zjsu.entity.UserInfo;

public interface UserAllDaoImpl {
	
	/**
	 * 根据openid判断用户信息是否存在,返回null表示不存在，否则表示存在
	 * @param sql
	 * @return
	 * @throws Exception 
	 */
	public UserInfo userinfoExistJudgeByOpenid(String openid);
	
	/**
	 * 向数据库中存入用户信息
	 * @param userinfo
	 */
	public void userinfoSave(UserInfo userinfo);
	
	/**
	 * 根据openid获取用户信息
	 * @param userinfo
	 */
	public UserInfo userinfoGetByOpenid(String openid);

}
