package com.zjsu.guanwei.picture.model;

import com.zjsu.guanwei.picture.model.base.*;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class Picture extends BasePicture<Picture> {

	public static final Picture me = new Picture();

	/**
	 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
	 */
	public Page<Picture> picturecard(int pageNumber, int pageSize) {

		return paginate(pageNumber, pageSize, "select *",
				"from pictures,user where pictures.u_id=user.u_id order by p_id desc");
	}
	public Page<Picture> picturelist(int pageNumber, int pageSize) {

		return paginate(pageNumber, pageSize, "select p_id,p_url",
				"from pictures order by p_id desc");
	}
	public Page<Picture> picturerank(int pageNumber, int pageSize) {

		return paginate(pageNumber, pageSize, "select *",
				"from pictures,user where pictures.u_id=user.u_id order by p_favornumber desc");
	}
	public Page<Picture> myfavor(int pageNumber, int pageSize) {

		return paginate(pageNumber, pageSize, "select *",
				"from pictures,user,favor where favor.u_id=? and favor.p_id=pictures.p_id and pictures.u_id=user.u_id",1);
	}

}