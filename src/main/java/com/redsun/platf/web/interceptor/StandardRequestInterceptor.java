package com.redsun.platf.web.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.redsun.platf.entity.sys.SystemLanguage;
import com.redsun.platf.entity.sys.SystemTheme;
import com.redsun.platf.service.sys.ConfigLoaderService;
import com.redsun.platf.sys.EPApplicationAttributes;
import com.redsun.platf.util.LogUtils;

/**
 * 標准request 的攔截器 全局配置
 * 
 * @author dick pan <mvc:interceptors> <bean
 *         class="cn.li.controller.StandardRequestInterceptor" /> <bean
 *         class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
 *         <property name="paramName" value="language" /> </bean>
 *         </mvc:interceptors>
 */
@Component
public class StandardRequestInterceptor implements HandlerInterceptor {

	private Logger log = LogUtils.getLogger(getClass());

	@Resource(name = "applicationConfigLoader")
	ConfigLoaderService configLoader;

	private List<SystemTheme> themes;
	private List<SystemLanguage> languages;

	public void init() {

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (themes == null)
			themes = configLoader.getInstance().getThemes();
		if (languages == null)
			languages = configLoader.getInstance().getLanguages();

		List<SystemTheme> themeConfig = (List<SystemTheme>) request
				.getSession().getAttribute(EPApplicationAttributes.THEME_NAME);

		if (themeConfig == null)
			request.getSession().setAttribute(
					EPApplicationAttributes.THEME_NAME, themes);
		else
			log.debug("[redsun.web]config reload only");

		List<SystemLanguage> languageConfig = (List<SystemLanguage>) request
				.getSession().getAttribute(EPApplicationAttributes.LOCALE_NAME);
		if (languageConfig == null)
			request.getSession().setAttribute(
					EPApplicationAttributes.LOCALE_NAME, languages);
		else
			log.debug("[...redsun.web]config reload only");

		log.debug("[...redsun.web] load  of themes:" + themes.size());
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.debug("[...redsun.web]poster Handler config");
		log.debug("[...redsun.web]themes:"+request.getSession().getAttribute(
				EPApplicationAttributes.THEME_NAME));

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.debug("[...redsun.web]afterCompletion");
		log.debug("[...redsun.web]themes:"+request.getSession().getAttribute(
				EPApplicationAttributes.THEME_NAME));

	}

}
