package com.zjsu.guanwei.picture.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseComment<M extends BaseComment<M>> extends Model<M>
		implements IBean {

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

}