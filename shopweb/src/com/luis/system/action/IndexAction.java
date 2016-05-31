package com.luis.system.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Results( { @Result(name = "login", location = "/WEB-INF/easyui/login.jsp") })  
public class IndexAction extends ActionSupport{
	private static final long serialVersionUID = 5469829439645076494L;

	@Override
	public String execute() throws Exception {
		return "login";
	}
}
