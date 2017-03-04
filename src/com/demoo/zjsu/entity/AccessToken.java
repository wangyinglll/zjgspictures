package com.demoo.zjsu.entity;

public class AccessToken {

	private String access_token;;
	private int expires_in;
	private String openid;
	private String refresh_token;
	// 保存的长整型时间
	private long lasttime;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public long getLasttime() {
		return lasttime;
	}

	public void setLasttime(long lasttime) {
		this.lasttime = lasttime;
	}

	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in="
				+ expires_in + ", openid=" + openid + ", refresh_token="
				+ refresh_token + "]";
	}

}
