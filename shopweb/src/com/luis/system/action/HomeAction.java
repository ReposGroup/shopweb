package com.luis.system.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
@Results( { @Result(name = "index", location = "/WEB-INF/easyui/index.jsp") })  
public class HomeAction extends ActionSupport{
	private static final long serialVersionUID = 4182084014999205572L;

	public String execute() throws Exception {
		return "index";
	}
}
