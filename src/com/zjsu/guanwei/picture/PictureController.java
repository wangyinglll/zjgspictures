package com.zjsu.guanwei.picture;

import java.io.File;
import java.util.*;


import net.coobird.thumbnailator.Thumbnails;


import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

import com.zjsu.guanwei.picture.common.ImageMarkLogoByText;
import com.zjsu.guanwei.picture.model.*;

public class PictureController extends Controller {

	public void index() {

	}

	/*
	 * 首页
	 */
	public void picturecard() {

		Integer pageSize = 1;
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber == null) {
			pageNumber = 1;
		}
		Page picture = Picture.me.picturecard(pageNumber, pageSize);
		setAttr("card", picture.getList());

		List page = new ArrayList();
		for (Integer i = 1; i <= picture.getTotalPage(); i++) {
			page.add(i);
		}
		setAttr("page", page);

		picturelist();
		render("/index.jsp");

	}

	/*
	 * 缩略图
	 */
	public void picturelist() {
		Integer pageSize = 10;
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber == null) {
			pageNumber = 1;
		}
		Page picture = Picture.me.picturelist(pageNumber, pageSize);
		setAttr("list", picture.getList());

		List page = new ArrayList();
		for (Integer i = 1; i <= picture.getTotalPage(); i++) {
			page.add(i);
		}
		setAttr("page2", page);
		// render("/home.jsp");
	}

	/*
	 * 照片排行
	 */
	public void picturerank() {
		Integer pageSize = 10;
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber == null) {
			pageNumber = 1;
		}
		Page picture = Picture.me.picturerank(pageNumber, pageSize);
		setAttr("rank", picture.getList());

		List page = new ArrayList();
		for (Integer i = 1; i <= picture.getTotalPage(); i++) {
			page.add(i);
		}
		setAttr("page", page);
		render("/rankinglist.jsp");
	}

	/*
	 * 我的照片
	 */

	public void mypictures() {
		Integer pageSize = 1;
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber == null) {
			pageNumber = 1;
		}
		Page picture = User.me.getPictures(pageNumber, pageSize);
		setAttr("list", picture.getList());

		List page = new ArrayList();
		for (Integer i = 1; i <= picture.getTotalPage(); i++) {
			page.add(i);
		}
		setAttr("page", page);
		render("/index.jsp");
	}

	/*
	 * 我喜欢的
	 */

	public void myfavor() {
		Integer pageSize = 1;
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber == null) {
			pageNumber = 1;
		}
		Page picture = User.me.getPictures(pageNumber, pageSize);
		setAttr("list", picture.getList());

		List page = new ArrayList();
		for (Integer i = 1; i <= picture.getTotalPage(); i++) {
			page.add(i);
		}
		setAttr("page", page);
		render("/index.jsp");
	}

	/*
	 * 照片的评论和赞列表
	 */
	public void comment() {
		Integer p_favornumber = getParaToInt("p_favornumber");
		Integer p_cnumber = getParaToInt("p_cnumber");
		Integer p_id = getParaToInt("p_id");
		setAttr("p_id", p_id);
		setAttr("p_favornumber", p_favornumber);
		setAttr("p_cnumber", p_cnumber);
		Integer pageSize = 2;
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber == null) {
			pageNumber = 1;
		}
		Page comment = Comment.me.comment(pageNumber, pageSize, p_id);

		setAttr("comm", comment.getList());
		Page favor = Favor.me.favorlist(1, pageSize, p_id);

		setAttr("favor", favor.getList());
		List pagecomm = new ArrayList();

		for (Integer i = 1; i <= comment.getTotalPage(); i++) {
			pagecomm.add(i);
		}
		setAttr("pagecomm", pagecomm);
		List pagefavor = new ArrayList();
		for (Integer i = 1; i <= favor.getTotalPage(); i++) {
			pagefavor.add(i);
		}
		setAttr("pagefavor", pagefavor);
		render("/comment1.jsp");
	}

	/*
	 * 
	 * 用户评论
	 */

	public void commentsave() {

		String c_content = getPara("c_content");
		Integer p_id = getParaToInt("p_id");

		Comment.me.csave(p_id, c_content);
		comment();

	}

	/*
	 * 喜欢
	 */

	public void favor() {

		try {

			Integer p_id = getParaToInt("p_id");
			Integer u_id = getParaToInt("u_id");// 图片作者的id
			Favor.me.favor(p_id, u_id);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();

		}
		renderText("成功");
	}

	/*
	 * 上传
	 */

	public void upload() {

		//
		// getModel(Picture.class).update();
		//
		render("/upload.jsp");

	}

	// @Before(UploadValidator.class)
	public void save() {
		try {

			UploadFile file = getFile();

			String b = file.getUploadPath();
			String p_name = getPara("p.p_name") + "and"
					+ System.currentTimeMillis();
			File a = new File(b + "\\" + p_name + ".jpg");
			file.getFile().renameTo(a);
			
			String smallp_url = "\\pictures\\upload\\" + p_name + "small.jpg";
String smallurl=b + "\\" + p_name + "small.jpg";
			File toPic = new File(smallurl);

			Thumbnails.of(a).scale(0.5f).toFile(toPic);
			String logoText = "@";// 加当前用户名
			ImageMarkLogoByText.markByText(logoText, smallurl, smallurl);
			Picture picture = getModel(Picture.class, "p");

			picture.set("p_url", smallp_url);
			picture.set("p_time", new Date());
			picture.save();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			System.out.println("上传失败");
		}
		renderText("上传");
	}

}
