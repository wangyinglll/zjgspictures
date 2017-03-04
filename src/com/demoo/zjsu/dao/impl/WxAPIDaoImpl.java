package com.demoo.zjsu.dao.impl;

import com.demoo.zjsu.entity.AccessToken;

public interface WxAPIDaoImpl {
	
	/**
	 * 存储accesstoken
	 * @param aToken
	 */
	public void save(AccessToken aToken);
	
	/**
	 * 从数据库中获取accesstoken
	 * @return
	 */
	public AccessToken accesstokenGet();

}
