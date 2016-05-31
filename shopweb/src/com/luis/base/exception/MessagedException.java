package com.luis.base.exception;

import java.util.ArrayList;
import java.util.List;

public class MessagedException extends RuntimeException
{
  private static final long serialVersionUID = -7607192617149998299L;
  private List messages = new ArrayList();

  public MessagedException()
  {
  }

  public MessagedException(String message, Throwable cause) {
    super(message, cause);
  }

  public MessagedException(String message) {
    super(message);
  }

  public MessagedException(Throwable cause) {
    super(cause);
  }

  public void addMessage(Object msg) {
    if ((msg instanceof Throwable))
      this.messages.add(((Throwable)msg).getMessage());
    else
      this.messages.add(msg);
  }

  public List getMessages() {
    return this.messages;
  }
}