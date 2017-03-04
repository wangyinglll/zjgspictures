package com.demoo.zjsu.entity;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseUserInfo<M extends BaseUserInfo<M>> extends Model<M>
		implements IBean {
	public void setU_id(java.lang.Integer u_id) {
		set("u_id", u_id);
	}

	public java.lang.Integer getU_id() {
		return get("u_id");
	}

	public void setAccess_token(java.lang.String access_token) {
		set("access_token", access_token);
	}

	public java.lang.String getAccess_token() {
		return get("access_token");
	}

	public void setExpires_in(java.lang.Integer expires_in) {
		set("expires_in", expires_in);
	}

	public java.lang.Integer getExpires_in() {
		return get("expires_in");
	}

	public void setOpenid(java.lang.String openid) {
		set("openid", openid);
	}

	public java.lang.String getOpenid() {
		return get("openid");
	}

	public void setScope(java.lang.String scope) {
		set("scope", scope);
	}

	public java.lang.String getScope() {
		return get("scope");
	}

	public void setErrcode(java.lang.Integer errcode) {
		set("errcode", errcode);
	}

	public java.lang.Integer getErrcode() {
		return get("errcode");
	}

	public void setSubscribe(java.lang.Integer subscribe) {
		set("subscribe", subscribe);
	}

	public java.lang.Integer getSubscribe() {
		return get("subscribe");
	}

	public void setNickname(java.lang.String nickname) {
		set("nickname", nickname);
	}

	public java.lang.String getNickname() {
		return get("nickname");
	}

	public void setSex(java.lang.Integer sex) {
		set("sex", sex);
	}

	public java.lang.Integer getSex() {
		return get("sex");
	}

	public void setHeadimgurl(java.lang.String headimgurl) {
		set("headimgurl", headimgurl);
	}

	public java.lang.String getHeadimgurl() {
		return get("headimgurl");
	}

	public void setProvince(java.lang.String province) {
		set("province", province);
	}

	public java.lang.String getProvince() {
		return get("province");
	}

	public void setCity(java.lang.String city) {
		set("city", city);
	}

	public java.lang.String getCity() {
		return get("city");
	}

	public void setCountry(java.lang.String country) {
		set("country", country);
	}

	public java.lang.String getCountry() {
		return get("country");
	}
}