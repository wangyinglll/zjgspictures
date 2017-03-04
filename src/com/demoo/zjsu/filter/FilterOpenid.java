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
import com.demoo.zjsu.userinfo.service.OpenidGetService;
import com.demoo.zjsu.userinfo.service.UserInfoGetService;
import com.demoo.zjsu.userinfo.service.impl.UserInfoGetServiceImpl;

/**
 * 判断是否openid是否已经缓存的filter 如果没有缓存，则跳转获取openid
 * 
 * @author yuanjian
 * 
 */
public class FilterOpenid implements Filter {

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
		session.setAttribute("openid_guanwei_zjsu", "yuanjian");
		String openid = "";
		try {
			openid = session.getAttribute("openid_guanwei_zjsu") + "";
		} catch (Exception e) {
		}
		// 当openid存在
		if (!openid.trim().equals("null")) {
			chain.doFilter(request, response);
			return;
		}
		// openid不存在
		else {
			rb = ResourceBundle.getBundle("value");
			String code = request.getParameter("code");
			String appId = rb.getString("appId"), appSecret = rb
					.getString("appSecret");
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
			// 获取用户信息的方式，所有信息还是仅openid,若为snsapi_base则只获取用户openid，若为snsapi_userinfo则获取用户所有信息
			String userinfo_type = request.getParameter("state");
			// 默认为获取所有用户信息
			userinfo_type = userinfo_type == null ? "snsapi_userinfo"
					: userinfo_type;
			UserInfoGetServiceImpl uisi = userinfo_type.trim().equals(
					"snsapi_base") ? new OpenidGetService()
					: new UserInfoGetService();

			UserInfo userinfo = uisi.userInfoGet(appId, appSecret, code);
			try {
				logger.error("用户是否关注信息："+userinfo.getSubscribe());
			} catch (Exception e1) {
				logger.error("用户是否关注信息出错。");
			}
			if (userinfo == null) {
				try {
					httpResponse.sendRedirect(url_next.substring(0,url_next.lastIndexOf("?")));
				} catch (Exception e) {
					httpResponse.sendRedirect(url_next);
				}
				return;
			}
			session.setAttribute("openid_guanwei_zjsu", userinfo.getOpenid());
//			session.setAttribute("userinfo_guanwei_zjsu", userinfo);
			// 处理用户信息
			chain.doFilter(request, response);
		}

	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
