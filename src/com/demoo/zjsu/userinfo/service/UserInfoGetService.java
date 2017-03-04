package com.demoo.zjsu.userinfo.service;

import org.apache.log4j.Logger;

import com.demoo.zjsu.dao.UserAllDao;
import com.demoo.zjsu.dao.impl.UserAllDaoImpl;
import com.demoo.zjsu.entity.UserInfo;
import com.demoo.zjsu.method.CURL;
import com.demoo.zjsu.userinfo.service.impl.UserInfoGetServiceImpl;
import com.google.gson.Gson;

public class UserInfoGetService implements UserInfoGetServiceImpl {
	private UserAllDao userAllDao = new UserAllDao();
	private Logger logger = Logger.getLogger(UserAllDaoImpl.class);

	@Override
	public UserInfo userInfoGet(String appId, String appSecret, String code) {
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
				+ appId + "&secret=" + appSecret + "&code=" + code
				+ "&grant_type=authorization_code";
		String result = CURL.sendGet(url);
		Gson gson = new Gson();
		UserInfo ui = gson.fromJson(result, UserInfo.class);
		if (ui.getErrcode() == 0) {
			url = "https://api.weixin.qq.com/sns/userinfo?access_token="
					+ ui.getAccess_token() + "&openid=" + ui.getOpenid()
					+ "&lang=zh_CN";
			String result2 = CURL.sendGet(url);
			logger.error("获取用户信息的json串："+result2);
			UserInfo ui2 = gson.fromJson(result2, UserInfo.class);
			if (ui2.getErrcode() == 0) {
				UserInfo userinfo = userAllDao.userinfoExistJudgeByOpenid(ui2
						.getOpenid());
				// 数据库中不存在该用户信息，则插入
				if (userinfo == null || userinfo.getNickname() == null) {
					userAllDao.userinfoSave(ui2);
				}
				logger.error("用户信息，判断用户是否关注："+ui2.toString());
				return ui2;
			} else {
				logger.error("用户信息获取不到，判断用户是否关注："+ui2.toString());
				return null;
			}
		} else {
			logger.error("用户信息获取第一步出错，判断用户是否关注："+ui.toString());
			return null;
		}
	}
	
}
