package com.luis.base.action;

import java.math.BigDecimal;

public abstract interface Constants
{
  public static final String MESSAGES_KEY = "messages_alert";
  public static final String MAX_DATE = "9999-12-31";
  public static final String SESSION_CURRENT_USER = "sessionCurrentUser";
  public static final String SESSION_MODULES = "sessionModules";
  public static final String SESSION_USER_RIGHTSLIST = "sessionRightsList";
  public static final String SESSION_USER_MODULEFUN = "sessionUserModuleFuns";
  public static final String SESSION_URLS = "sessionURL";
  public static final String SESSION_CURRENT_MODULE = "sessionCurrentModule";
  public static final String localUrl = "http://localhost:8080/";
  public static final String GLOBAL_LOCK_PAGES = "GLOBAL_LOCK_PAGES";
  public static final String SESSION_WINDOW_NAME = "window_name";
  public static final String CONST_INPUT_DATE_FORMAT = "yyyy-MM-dd";
  public static final String CONST_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  public static final String CONST_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
  public static final String CONST_TIME_FORMAT = "HH:mm";
  public static final String DATE_PATTERN = "yyyyMMdd";
  public static final String REPT_DATE_PATTERN = "yyMMdd";
  public static final String locale_language = "locale";
  public static final String stringZero = "0";
  public static final String stringOne = "1";
  public static final String stringTwo = "2";
  public static final Integer integerZero = Integer.valueOf(0);
  public static final Integer integerOne = Integer.valueOf(1);
  public static final BigDecimal zero = new BigDecimal(0);
  public static final BigDecimal percentTen = new BigDecimal(0.1D);
  public static final String INTERFACE_FILE_TYPE = ".XML";
  public static final int MAX_RECORDS = 5000;
  
}