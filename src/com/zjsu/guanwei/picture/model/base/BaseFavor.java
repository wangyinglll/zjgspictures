package com.zjsu.guanwei.picture.model.base;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

public abstract class BaseFavor<M extends BaseFavor<M>> extends Model<M>
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

	public void setF_time(java.sql.Timestamp f_time) {
		set("f_time", f_time);
	}

	public java.sql.Timestamp getF_time() {
		return get("f_time");
	}

	public void setP_id(java.lang.Integer p_id) {
		set("p_id", p_id);
	}

	public java.lang.Integer getP_id() {
		return get("p_id");
	}
}
