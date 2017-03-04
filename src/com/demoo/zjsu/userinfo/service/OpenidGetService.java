package com.demoo.zjsu.userinfo.service;

import com.demoo.zjsu.dao.UserAllDao;
import com.demoo.zjsu.entity.UserInfo;
import com.demoo.zjsu.method.CURL;
import com.demoo.zjsu.userinfo.service.impl.UserInfoGetServiceImpl;
import com.google.gson.Gson;

public class OpenidGetService implements UserInfoGetServiceImpl {
	private UserAllDao userAllDao = new UserAllDao();

	@Override
	public UserInfo userInfoGet(String appId, String appSecret, String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appId + "&secret=" + appSecret + "&code=" + code
				+ "&grant_type=authorization_code";
		String result = CURL.sendGet(url);
		Gson gson = new Gson();
		UserInfo ui = gson.fromJson(result, UserInfo.class);
		if (ui.getErrcode() != 0) {
			return null;
		} else {
			UserInfo userinfo = userAllDao.userinfoExistJudgeByOpenid(ui.getOpenid());
			// 数据库中不存在该用户信息，则插入
			if (userinfo == null) {
				userAllDao.userinfoSave(ui);
			}
			return ui;
		}
	}

}
