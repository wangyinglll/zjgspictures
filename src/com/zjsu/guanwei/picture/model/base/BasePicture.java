package com.zjsu.guanwei.picture.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BasePicture<M extends BasePicture<M>> extends Model<M>
		implements IBean {
	// user
	public void setU_id(java.lang.Integer u_id) {
		set("u_id", u_id);
	}

	public java.lang.Integer getU_id() {
		return get("u_id");
	}

	public void setU_headurl(java.lang.String u_headurl) {
		set("u_headurl", u_headurl);
	}

	public java.lang.String getU_headurl() {
		return get("u_headurl");
	}

	public void setU_name(java.lang.String u_name) {
		set("u_name", u_name);
	}

	public java.lang.String getU_name() {
		return get("u_name");
	}

	public void setU_favornumber(java.lang.Integer u_favornumber) {
		set("u_favornumber", u_favornumber);
	}

	public java.lang.Integer getU_favornumber() {
		return get("u_favornumber");
	}
	//comment
	public void setC_content(java.lang.String c_content) {
		set("c_content", c_content);
	}

	public java.lang.String getC_content() {
		return get("c_content");
	}
	
	public void setC_time(java.sql.Timestamp c_time) {
		set("c_time", c_time);
	}

	public java.sql.Timestamp getC_time() {
		return get("c_time");
	}
	// picture
	public void setP_id(java.lang.Integer p_id) {
		set("p_id", p_id);
	}

	public java.lang.Integer getP_id() {
		return get("p_id");
	}

	public void setP_url(java.lang.String p_url) {
		set("p_url", p_url);
	}

	public java.lang.String getP_url() {
		return get("p_url");
	}

	public void setP_name(java.lang.String p_name) {
		set("p_name", p_name);
	}

	public java.lang.String getP_name() {
		return get("p_name");
	}

	public void setP_description(java.lang.String p_description) {
		set("p_description", p_description);
	}

	public java.lang.String getP_description() {
		return get("p_description");
	}

	public void setP_tel(java.lang.Integer p_tel) {
		set("p_tel", p_tel);
	}

	public java.lang.Integer getP_tel() {
		return get("p_tel");
	}

	public void setP_time(java.sql.Timestamp p_time) {
		set("p_time", p_time);
	}

	public java.sql.Timestamp getP_time() {
		return get("p_time");
	}

	public void setP_favornumber(java.lang.Integer p_favornumber) {
		set("p_favornumber", p_favornumber);
	}

	public java.lang.Integer getP_favornumber() {
		return get("p_favornumber");
	}

	public void setP_cnumber(java.lang.Integer p_cnumber) {
		set("p_cnumber", p_cnumber);
	}

	public java.lang.Integer getP_cnumber() {
		return get("p_cnumber");
	}

}
