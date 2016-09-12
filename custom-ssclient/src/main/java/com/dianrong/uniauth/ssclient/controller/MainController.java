package com.dianrong.uniauth.ssclient.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Value("#{uniauthConfig['domains.'+domainDefine.domainCode]}")
	private String service;
	
	@Value("#{uniauthConfig['cas_server']}")
	private String casUrl;
	
	@Value("#{uniauthConfig['domains.'+domainDefine.domainCode]}")
	private String customUrl;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getCommonPage(HttpServletRequest request) {
		String lt = request.getParameter("lt");
		// 设置登陆的lt和对应的业务系统service
		request.setAttribute("ltval", lt);
		request.setAttribute("service", service);
		request.setAttribute("casUrl", casUrl);
		request.setAttribute("customUrl", customUrl);
		return "login";
	}
	
	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String getAadminPage(HttpServletRequest request) {
		return "content";
	}
}
