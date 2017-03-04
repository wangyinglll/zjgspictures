package com.zjsu.guanwei.picture.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zjsu.guanwei.picture.model.base.*;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class Comment extends BaseComment<Comment> {

	public static final Comment me = new Comment();

	public Page<Comment> comment(int pageNumber, int pageSize, int p_id) {
		try {

			return paginate(
					pageNumber,
					pageSize,
					"select *",
					"from comment,user where comment.p_id=? and user.u_id=comment.u_id",
					p_id);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	public void csave(Integer p_id1, String c_content) {
		try {
			me.set("u_id", 1);
			me.set("c_content", c_content);
			me.set("p_id", p_id1);
			me.set("c_time", new Date());
			me.save();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
	}
}
