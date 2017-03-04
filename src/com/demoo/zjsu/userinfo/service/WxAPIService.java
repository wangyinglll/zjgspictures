package com.demoo.zjsu.userinfo.service;

import java.util.Date;

import org.apache.log4j.Logger;

import com.demoo.zjsu.dao.WxAPIDao;
import com.demoo.zjsu.entity.AccessToken;
import com.demoo.zjsu.entity.UserInfo;
import com.demoo.zjsu.method.CURL;
import com.google.gson.Gson;

public class WxAPIService {

	private static Logger logger = Logger.getLogger(WxAPIDao.class);
	private static WxAPIDao wxAPIDao = new WxAPIDao();
	/**
	 * 从数据库读取accesstoken
	 * 获取正确的accesstoken
	 * @return
	 */
	public static String accesstokenGet(String appid,String appsecret) {

		String accessToken = null;
		AccessToken aToken = wxAPIDao.accesstokenGet();
		Long timeOld = aToken.getLasttime();
		Long timeNow = new Date().getTime();
		// 时间差在6500秒以内，直接从数据库获取accesstoken
		if (timeNow - timeOld < 6500000) {
			accessToken = aToken.getAccess_token();
		}
		// 时间差超过6500，调用accesstokenGetFromCURL此方法获取
		else {
			accessToken = accesstokenGetFromCURL(appid,appsecret);
		}
		return accessToken;

	}

	/**
	 * 通过curl模拟请求获取accesstoken并保存至数据库
	 * @return
	 */
	public static String accesstokenGetFromCURL(String appid,String appsecret) {

		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appid + "&secret=" + appsecret;
		String result = CURL.sendGet(url);
		Gson gson = new Gson();
		AccessToken aToken = gson.fromJson(result, AccessToken.class);
		aToken.setLasttime(new Date().getTime());
		wxAPIDao.accesstokenUpdate(aToken);

		return aToken.getAccess_token();
	}

	public static UserInfo userInfoGet(String openid,String appid,String appsecret) {

		String accesstoken = accesstokenGet(appid,appsecret);
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
				+ accesstoken + "&openid=" + openid + "&lang=zh_CN";
		String json = CURL.sendGet(url);
		UserInfo userInfo = new UserInfo();
		Gson gson = new Gson();
		userInfo = gson.fromJson(json, UserInfo.class);
		if(userInfo.getErrcode() == 40001){
			//重新获取用户信息，accesstoken出问题了
			accesstoken = accesstokenGetFromCURL(appid,appsecret);
			url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
					+ accesstoken + "&openid=" + openid + "&lang=zh_CN";
			json = CURL.sendGet(url);
			userInfo = new UserInfo();
			userInfo = gson.fromJson(json, UserInfo.class);
		}

		return userInfo;
	}
	
}
