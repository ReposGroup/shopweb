package com.luis.base.action;

import com.luis.base.util.Struts2Utils;
import com.luis.base.util.SystemUtils;
import com.luis.system.model.User;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Results;

@Results({@org.apache.struts2.convention.annotation.Result(name="login", location="index.action", type="redirect")})
public abstract class CrudModelActionSupport<T> extends BaseAction
  		implements ModelDriven<T>, Preparable, Constants{
	
	  private static final long serialVersionUID = 8754720155164402291L;
	  protected List<String> messages;
	  public Integer id;
	  public T entity;
	  public static final String RELOAD = "reload";
	
	  public T getModel()
	  {
	    return this.entity;
	  }
	
	  public void setId(Integer id)
	  {
	    this.id = id;
	  }
	
	  public String execute()
	    throws Exception
	  {
	    User user = SystemUtils.getCurrentUser();
	    if (user == null) {
	      return "login";
	    }
	    return list(); } 
	  public abstract String list() throws Exception;
	
	  public abstract String input() throws Exception;
	
	  public abstract String view() throws Exception;
	
	  public abstract String approve() throws Exception;
	
	  public abstract String save() throws Exception;
	
	  public abstract String delete() throws Exception;
	
	  public String copyObj() throws Exception { return null;
	  }
	
	  public void prepare()
	    throws Exception
	  {
	  }
	
	  public void prepareInput()
	    throws Exception
	  {
	    prepareModel();
	  }
	
	  public void prepareView()
	    throws Exception
	  {
	    prepareModel();
	  }
	
	  public void prepareApprove()
	    throws Exception
	  {
	    prepareModel();
	  }
	
	  public void prepareSave()
	    throws Exception
	  {
	    prepareModel();
	  }
	
	  public void prepareCopyObj()
	    throws Exception
	  {
	    prepareModel();
	  }
	
	  protected abstract void prepareModel()
	    throws Exception;
	
	  public void addMessage(String message)
	  {
	    if ((message != null) && (!"".equals(message.trim()))) {
	      if (this.messages == null) {
	        this.messages = new ArrayList();
	      }
	
	      this.messages.add(message);
	    }
	    if ((this.messages != null) && (this.messages.size() > 0))
	      Struts2Utils.getRequest().setAttribute("messages_alert", this.messages);
	  }
	
	  public void addMessageList(List<String> message) {
	    if (message != null) {
	      if (this.messages == null) {
	        this.messages = new ArrayList();
	      }
	
	      this.messages.addAll(message);
	    }
	    if ((this.messages != null) && (this.messages.size() > 0))
	      Struts2Utils.getRequest().setAttribute("messages_alert", this.messages);
	  }
	
}