package com.luis.base.action;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport{
	
	 private static final long serialVersionUID = -2195179132019926434L;
	 protected Logger logger = LoggerFactory.getLogger(getClass());
	 public String msg;
	 public List<Integer> checks;
	 public Integer[] checkids;
	 
	 public List<Integer> getChecks()
	  {
	    return this.checks;
	  }

	  public Integer[] getCheckids() {
	    return this.checkids;
	  }

}
