package com.example.cwgl.configs;


import com.example.cwgl.entity.UserInfo;
import com.example.cwgl.utils.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
* description: TODO
* @author zhangsihai
* @date 2020/3/24 15:23
*/
public class LoggerInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    private static HttpSession session;
    private static String userid;
    private static StringBuilder sb = new StringBuilder();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (session==null && (session = request.getSession()) != null){
            UserInfo userInfo = (UserInfo)session.getAttribute(Config.CURRENT_USERNAME);
            userid = userInfo == null? request.getHeader("userid") : userInfo.getId().toString();
        }
        sb.setLength(0);

        sb.append("用户编号【")
            .append(userid)
            .append("】正在访问：")
            .append(request.getRequestURL().toString());
        logger.info(sb.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (!request.getRequestURI().contains("/static/")){
            sb.setLength(0);
            sb.append("Method:").append(((HandlerMethod)handler).getShortLogMessage());
            logger.info(sb.toString());
            Map<String, String[]> parameters = request.getParameterMap();
            if (parameters.size() > 0){
                sb.setLength(0);
                sb.append("Parameters: {");
                for (String key : parameters.keySet()){
                    String value = parameters.get(key)[0];
                    if (value != null && !value.isEmpty()){
                        sb.append(key +":"+parameters.get(key)[0]+",");
                    }
                }
                if (sb.lastIndexOf(",")!=-1){
                    sb.deleteCharAt(sb.lastIndexOf(","));
                }
                sb.append("}");
                logger.info(sb.toString());
            }
        }

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        sb.setLength(0);
        sb.append("用户编号【")
            .append(userid)
            .append("】")
            .append(request.getRequestURL().toString())
            .append(" 访问结束... ");

        logger.info(sb.toString());


    }
}
