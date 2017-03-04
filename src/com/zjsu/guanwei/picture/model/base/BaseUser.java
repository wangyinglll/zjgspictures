package com.zjsu.guanwei.picture.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends Model<M>
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

	public void setU_favornumber(java.lang.Integer u_favornumber) {
		set("u_favornumber", u_favornumber);
	}

	public java.lang.Integer getU_favornumber() {
		return get("u_favornumber");
	}
}