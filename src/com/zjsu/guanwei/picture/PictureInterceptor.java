package com.zjsu.guanwei.picture;


import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.UserApi;

/**
 * 
 * 拦截器
 */
public class PictureInterceptor implements Interceptor {
	
	public void intercept(Invocation inv) {
	
		
		
		
		
		
		
		
		System.out.println("Before invoking " + inv.getActionKey());
		inv.invoke();
		System.out.println("After invoking " + inv.getActionKey());
	}
}