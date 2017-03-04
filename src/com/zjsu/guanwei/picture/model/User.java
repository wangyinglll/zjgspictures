package com.zjsu.guanwei.picture.model;


import com.jfinal.plugin.activerecord.Page;
import com.zjsu.guanwei.picture.model.base.*;

@SuppressWarnings("serial")
public class User extends BaseUser<User> {

	public static final User me = new User();


	public Page<Picture> getPictures(int pageNumber, int pageSize) {
		try {
			return Picture.me
					.paginate(pageNumber, pageSize, "select * ",
							"from pictures,user where user.u_id=1 and pictures.u_id=user.u_id");

		} catch (Exception e) {

			System.out.println(e);
			e.printStackTrace();
			return null;
		} 
	}
}