package com.luis.base.dao;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class Page implements Serializable{
  private static final long serialVersionUID = 8868244322286195421L;
  public static final String ASC = "asc";
  public static final String DESC = "desc";
  protected int pageNo = 1;
  protected int pageSize = 1;
  protected String orderBy = null;
  protected String order = null;
  protected boolean autoCount = true;

  protected List result = Collections.emptyList();
  protected long total = -1L;

  public Page(){}

  public Page(int pageSize) {
    setPageSize(pageSize);
  }

  public Page(int pageSize, boolean autoCount) {
    setPageSize(pageSize);
    setAutoCount(autoCount);
  }

  public int getPageNo()
  {
    return this.pageNo;
  }

  public void setPageNo(int pageNo)
  {
    this.pageNo = pageNo;
    if (pageNo < 1)
      this.pageNo = 1;
  }

  public int getPageSize()
  {
    return this.pageSize;
  }

  public void setPageSize(int pageSize)
  {
    this.pageSize = pageSize;
    if (pageSize < 1)
      this.pageSize = 1;
  }

  public int getFirst()
  {
    return (this.pageNo - 1) * this.pageSize + 1;
  }

  public String getOrderBy()
  {
    return this.orderBy;
  }

  public void setOrderBy(String orderBy)
  {
    this.orderBy = orderBy;
  }

  public boolean isOrderBySetted()
  {
    return (StringUtils.isNotBlank(this.orderBy)) && (StringUtils.isNotBlank(this.order));
  }

  public String getOrder()
  {
    return this.order;
  }

  public void setOrder(String order)
  {
    String[] orders = StringUtils.split(StringUtils.lowerCase(order), ',');
	for (String orderStr : orders) {
	  if ((!StringUtils.equals("desc", orderStr)) && (!StringUtils.equals("asc", orderStr))) {
	throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
      }
    }
    this.order = StringUtils.lowerCase(order);
  }

  public boolean isAutoCount()
  {
    return this.autoCount;
  }

  public void setAutoCount(boolean autoCount)
  {
    this.autoCount = autoCount;
  }

  public List getResult()
  {
    return this.result;
  }

  public void setResult(List result)
  {
    this.result = result;
  }
  public long getTotal() 
  {
	return total;
  }
  public void setTotal(long total) {
	this.total = total;
  }

  public long getTotalPages()
  {
    if (this.total < 0L) {
      return -1L;
    }
    long count = this.total / this.pageSize;
    if (this.total % this.pageSize > 0L) {
      count += 1L;
    }
    return count;
  }

  public boolean isHasNext()
  {
    return this.pageNo + 1 <= getTotalPages();
  }

  public int getNextPage()
  {
    if (isHasNext()) {
      return this.pageNo + 1;
    }
    return this.pageNo;
  }

  public boolean isHasPre()
  {
    return this.pageNo - 1 >= 1;
  }

  public int getPrePage()
  {
    if (isHasPre()) {
      return this.pageNo - 1;
    }
    return this.pageNo;
  }
}