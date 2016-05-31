package com.luis.base.util;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.luis.system.model.Module;
import com.luis.system.model.User;

public class SystemUtils
{
  public static String getCurrentUserName()
  {
    User user = (User)Struts2Utils.getSession().getAttribute("sessionCurrentUser");
    if (user == null)
      return null;
    return user.getUserName();
  }

  public static User getCurrentUser()
  {
    User user = (User)Struts2Utils.getSession().getAttribute("sessionCurrentUser");
    if (user == null)
      return null;
    return user;
  }

  public static Module getCurrentModule() {
    Module module = (Module)Struts2Utils.getSession().getAttribute("sessionCurrentModule");
    if (module == null)
      return null;
    return module;
  }

//  public static String getSystemDate() {
//    return LookupCache.getSystemConfigurationDataByKey("systemDate").getConfigurationValue();
//  }
//  public static String getActionTypeFlag() {
//    return SystemPropertyInfo.getInstance().getActionTypeFlag();
//  }
//  public static String getEditFlag() {
//    return SystemPropertyInfo.getInstance().getEditFlag();
//  }
 
}