package com.zjsu.guanwei.picture.model;

import java.awt.List;
import java.util.Date;

import com.zjsu.guanwei.picture.model.base.*;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.zjsu.guanwei.*;
@SuppressWarnings("serial")
public class Favor extends BaseFavor<Favor> {
	public static final Favor me = new Favor();
	public Page<Favor> favorlist(int pageNumber, int pageSize, int p_id) {
		try {
			
			return paginate(
					pageNumber,
					pageSize,
					"select *",
					"from favor,user where favor.p_id=? and user.u_id=favor.u_id",
					p_id);
			

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return null;
		}
	}

	public void favor(int p_id, int u_id) {
		try {

			java.util.List<Favor> a = me.find(
					"select* from favor where u_id=1 and p_id=?", p_id); // 用户1给别人点赞
			int b = a.size();
			// 如果记录不存在，添加记录并增加赞数
			if (b == 0) {
				
				me.set("u_id", 1);
				me.set("p_id", p_id);
				me.set("f_time", new Date());
				me.save();
				try {
					int u = User.me.findById(u_id).getU_favornumber();
					System.out.println("喜欢的人数" + u + "+1");
					User.me.findByIdLoadColumns(u_id,"u_id").set("u_favornumber",u + 1).update();
					
					int p = Picture.me.findById(p_id).getP_favornumber();
					Picture.me.findByIdLoadColumns(p_id,"p_id").set("p_favornumber",p + 1).update();
					
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();

				}

			} else {

				// 记录存在

				me.deleteById(1, p_id);
				int u = User.me.findById(u_id).getU_favornumber();
				System.out.print("喜欢的人数" + u + "-1");
				User.me.findByIdLoadColumns(u_id,"u_id").set("u_favornumber",u - 1).update();
				
				int p = Picture.me.findById(p_id).getP_favornumber();
				Picture.me.findByIdLoadColumns(p_id,"p_id").set("p_favornumber",p - 1).update();
				

			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
	}
}
