package com.luis.base.exception;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Arrays;

public class BusinessException extends RuntimeException
{
  private static final long serialVersionUID = -1246064547154444788L;

  public BusinessException(Throwable throwable)
  {
    super(throwable);
  }

  public BusinessException(Throwable throwable, String frdMessage) {
    super(throwable);
  }

//  public BusinessException(String code, Object[] args) {
//    super(getCodeArgs(code, args));
//  }
//
//  private static synchronized String getCodeArgs(String code, Object[] args)
//  {
//    ActionSupport actionSupport = new ActionSupport();
//    return actionSupport.getText(code, (String[])Arrays.copyOf(args, args.length, [Ljava.lang.String.class));
//  }
}