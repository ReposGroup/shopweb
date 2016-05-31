package com.luis.base.util;

import com.opensymphony.xwork2.ActionContext;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

@SuppressWarnings("unused")
public class Struts2Utils{
	  private static final String ENCODING_PREFIX = "encoding";
	  private static final String NOCACHE_PREFIX = "no-cache";
	  private static final String ENCODING_DEFAULT = "UTF-8";
	  private static final boolean NOCACHE_DEFAULT = true;
	  private static final String TEXT_TYPE = "text/plain";
	  private static final String JSON_TYPE = "application/json";
	  private static final String XML_TYPE = "text/xml";
	  private static final String HTML_TYPE = "text/html";
	  private static final String JS_TYPE = "text/javascript";
	  private static Logger log = Logger.getLogger(Struts2Utils.class);
	
	  public static HttpSession getSession()
	  {
	    return ServletActionContext.getRequest().getSession();
	  }
	
	  public static ServletContext getServletContext() {
	    return (ServletContext)ActionContext.getContext().get("com.opensymphony.xwork2.dispatcher.ServletContext");
	  }
	
	  public static HttpServletRequest getRequest()
	  {
	    return ServletActionContext.getRequest();
	  }
	
	  public static HttpServletResponse getResponse()
	  {
	    return ServletActionContext.getResponse();
	  }
	
	  public static String getParameter(String name)
	  {
	    return getRequest().getParameter(name);
	  }
	
	  public static void render(String contentType, String content, String[] headers)
	  {
	    try
	    {
	      String encoding = "UTF-8";
	      boolean noCache = true;
	      for (String header : headers) {
	        String headerName = StringUtils.substringBefore(header, ":");
	        String headerValue = StringUtils.substringAfter(header, ":");
	
	        if (StringUtils.equalsIgnoreCase(headerName, "encoding"))
	          encoding = headerValue;
	        else if (StringUtils.equalsIgnoreCase(headerName, "no-cache"))
	          noCache = Boolean.parseBoolean(headerValue);
	        else {
	          throw new IllegalArgumentException(headerName + "不是一个合法的header类型");
	        }
	      }
	      HttpServletResponse response = ServletActionContext.getResponse();
	
	      String fullContentType = contentType + ";charset=" + encoding;
	      response.setContentType(fullContentType);
	      if (noCache) {
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0L);
	      }
	
	      response.getWriter().write(content);
	      response.getWriter().flush();
	    }
	    catch (IOException e) {
	      log.error("IOException", e);
	    }
	  }
	
	  public static void renderText(String text, String[] headers)
	  {
	    render("text/plain", text, headers);
	  }
	
	  public static void renderHtml(String html, String[] headers)
	  {
	    render("text/html", html, headers);
	  }
	
	  public static void renderXml(String xml, String[] headers)
	  {
	    render("text/xml", xml, headers);
	  }
	
	  public static void renderJson(String jsonString, String[] headers)
	  {
	    render("application/json", jsonString, headers);
	  }
	
	  public static void renderJson(Map map, String[] headers)
	  {
	    String jsonString = JSONObject.fromObject(map).toString();
	    render("application/json", jsonString, headers);
	  }
	
	  public static void renderJson(Object object, String[] headers)
	  {
	    String jsonString = JSONObject.fromObject(object).toString();
	    render("application/json", jsonString, headers);
	  }
	
	  public static void renderJson(Collection<?> collction, String[] headers)
	  {
	    String jsonString = JSONArray.fromObject(collction).toString();
	    render("application/json", jsonString, headers);
	  }
	
	  public static void renderJson(Object[] array, String[] headers)
	  {
	    String jsonString = JSONArray.fromObject(array).toString();
	    render("application/json", jsonString, headers);
	  }
	
	  public static void renderJsonp(String callbackName, Map contentMap, String[] headers)
	  {
	    String jsonParam = JSONObject.fromObject(contentMap).toString();
	
	    StringBuilder result = new StringBuilder().append(callbackName).append("(").append(jsonParam).append(");");
	
	    render("text/javascript", result.toString(), headers);
	  }
	
	//  public static Locale getCurrentLocale() {
	//    if (UtilStr.isEmpty(getSession().getAttribute("WW_TRANS_I18N_LOCALE"))) {
	//      return (Locale)getRequest().getAttribute("locale");
	//    }
	//    return (Locale)getSession().getAttribute("WW_TRANS_I18N_LOCALE");
	//  }
}