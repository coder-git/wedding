package com.demo.common.interceptor;

import com.demo.common.annotation.NoAuth;
import com.demo.common.annotation.WebAuth;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;


@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor{
	


	 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		if (handler instanceof HandlerMethod) {
		NoAuth noAuth = ((HandlerMethod) handler).getMethodAnnotation(NoAuth.class);//huzhou 添加忽略鉴权注解
		if(null!=noAuth) return true;
		}
		
		
		if (handler instanceof HandlerMethod) {
			WebAuth webAuth = ((HandlerMethod) handler).getMethodAnnotation(WebAuth.class);// 添加忽略鉴权注解
			if(null!=webAuth) {
				if(authenticateUserBySession(request)) {
					return true;
				} 
				
				response( response, "{\"code\":2000,\"message\":\"登陆失效\",\"data\":null}");
				return false;
			}

		}
		
//		log.info("pre authenticate {} 99999..",request.getRequestURI());
//		Map<String, String[]> map = request.getParameterMap();
//		if(map != null && !map.isEmpty()) {
//		for(Entry<String, String[]> entry : map.entrySet()){
//			  String key = entry.getKey();
//
//			}
//		}
		
		
		if(authenticateBySession(request)) {
			return true;
		} 
		
		response( response, "{\"code\":2000,\"message\":\"登陆失效\",\"data\":null}");
//		request.getRequestDispatcher("/admin/adminManagerLogin").forward(request, response);
		return false;
	 
  
		
	}



	private boolean authenticateUserBySession(HttpServletRequest request) { 
 
		HttpSession session = request.getSession();
 
 
//		Integer authType = (Integer) session.getAttribute("authType");
		
		String userAccount = (String) session.getAttribute("userAccount");
		Byte authStatus = (Byte) session.getAttribute("userStatus");
		
		
		if(StringUtils.isBlank(userAccount) ||    authStatus != 1) {
//			logger.info("try authenticate by authorization session, adminName is : {}, failed",authName);

			return false;
		}

		
		return true; 
	}
	 
	
	
	
	
	//管理员判断
	private boolean authenticateBySession(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String authName = (String) session.getAttribute("authName");
		Integer authStatus  = (Integer) session.getAttribute("authStatus");
//		Integer authType = (Integer) session.getAttribute("authType");
		
		if(StringUtils.isBlank(authName) ||  authStatus != 1) {
//			logger.info("try authenticate by authorization session, adminName is : {}, failed",authName);

			return false;
		}

		
		return true; 
	}
	
	
	
    private void response( HttpServletResponse response, String data) {
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(data);
        } catch (IOException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

    }
}
