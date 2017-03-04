package com.demoo.zjsu.filter;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.demoo.zjsu.dao.impl.UserAllDaoImpl;
import com.demoo.zjsu.entity.UserInfo;
import com.demoo.zjsu.method.CURL;
import com.demoo.zjsu.userinfo.service.WxAPIService;
import com.google.gson.Gson;

/**
 * 判断是否openid是否已经缓存的filter 如果没有缓存，则跳转获取openid
 * 
 * @author yuanjian
 * 
 */
public class FilterUserinfo implements Filter {

	private FilterConfig config = null;
	private ResourceBundle rb;
	private String url_redirect = "";
	private Logger logger = Logger.getLogger(UserAllDaoImpl.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		response.setCharacterEncoding("utf-8");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String url_next = httpRequest.getRequestURL() + "";
		HttpSession session = httpRequest.getSession();
		String openid = "";
		rb = ResourceBundle.getBundle("value");
		String appId = rb.getString("appId"), appSecret = rb
				.getString("appSecret");
		UserInfo ui = new UserInfo();
		try {
			openid = session.getAttribute("openid_guanwei_zjsu") + "";
		} catch (Exception e) {
		}
		// 当openid存在
		if (!openid.trim().equals("null")) {
			ui = WxAPIService.userInfoGet(openid, appId, appSecret);
			logger.error("查看一下errorcode..." + ui.getErrcode());
			if (ui.getSubscribe() == 0 && ui.getErrcode() == 0) {
				response.getWriter().println("5001");
				return;
			}
			chain.doFilter(request, response);
		}
		// openid不存在
		else {
			String code = request.getParameter("code");
			// 如果code值为null，则调用handdleError函数，拦截器结束
			if (code == null) {
				// 获取用户信息的形式，若为snsapi_base则只获取用户openid，若为snsapi_userinfo则获取用户所有信息
				String scope = request.getParameter("scop");
				// scope若为null，则默认scop为snsapi_userinfo
				scope = scope == null ? "snsapi_userinfo" : scope;
				url_redirect = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
						+ appId
						+ "&redirect_uri="
						+ url_next
						+ "&response_type=code&scope="
						+ scope
						+ "&state="
						+ scope + "#wechat_redirect";
				httpResponse.sendRedirect(url_redirect);
				return;
			}
			// code不为null
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
					+ appId
					+ "&secret="
					+ appSecret
					+ "&code="
					+ code
					+ "&grant_type=authorization_code";
			String result = CURL.sendGet(url);
			Gson gson = new Gson();
			ui = gson.fromJson(result, UserInfo.class);
			openid = ui.getOpenid();
			ui = WxAPIService.userInfoGet(openid, appId, appSecret);
			logger.error("查看一下errorcode" + ui.getErrcode());
			if (ui.getSubscribe() == 0 && ui.getErrcode() == 0) {
				response.getWriter().println("5001");
				return;
			}
			// 处理用户信息
			chain.doFilter(request, response);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
