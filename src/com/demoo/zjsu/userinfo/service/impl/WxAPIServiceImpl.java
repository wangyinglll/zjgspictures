package com.demoo.zjsu.userinfo.service.impl;

/**
 * 处理accesstoken的接口类
 * @author yuanjian
 *
 */
public interface WxAPIServiceImpl {
	
	/**
	 * 从数据库读取accesstoken
	 * 获取正确的accesstoken
	 * @return
	 */
	public String accesstokenGet();
	
	/**
	 * 通过curl模拟请求获取accesstoken并保存至数据库
	 * @return
	 */
	public String accesstokenGetFromCURL();
	
	/**
	 * 获取js-sdk的ticket
	 * @return
	 */
	public String getJsApiTicket();
	
	/**
	 * 获取用户信息的accesstoken
	 * @return
	 */
	public String accesstoken_userinfoGet(String code);
	
	/**
	 *  通过curl模拟请求获取授权用户信息accesstoken
	 * @return
	 */
	public String accesstokenUserinfoGetFromCURL(String code);

}
