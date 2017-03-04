package com.zjsu.guanwei.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.zjsu.guanwei.picture.PictureController;
import com.zjsu.guanwei.picture.model.*;

public class DemoConfig extends JFinalConfig {
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
		
me.setMaxPostSize(1024*1024*100);

	}

	public void configRoute(Routes me) {
		me.add("/picture", PictureController.class);
	}

	public void configPlugin(Plugins me) {
		try {
			loadPropertyFile("config.properties");
			C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"),
					getProperty("user"), getProperty("password"));
			me.add(c3p0Plugin);
			ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
			me.add(arp);

			arp.setShowSql(true);
			arp.addMapping("comment", "u_id,p_id", Comment.class);
			arp.addMapping("favor", "u_id,p_id", Favor.class);
			arp.addMapping("user", "u_id", User.class);
			arp.addMapping("pictures", "p_id", Picture.class);
		} catch (Exception e) {

			System.out.println(e);
			e.printStackTrace();
		}

	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
		//me.add(new WechatHandler());
	}
}
