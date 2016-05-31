package com.luis.base.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.luis.base.util.ReflectionUtils;

public class HibernateBaseDao<T, PK extends Serializable> extends HibernateDaoSupport
{
  protected Class<T> entityClass;

  @Autowired
  public void setSessionFactory0(SessionFactory sessionFactory)
  {
    super.setSessionFactory(sessionFactory);
  }

  public HibernateBaseDao()
  {
    this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
  }

  protected Class<T> getEntityClass()
  {
    return this.entityClass;
  }

  public T load(Serializable id)
  {
    return getHibernateTemplate().load(getEntityClass(), id);
  }

  public T get(Serializable id)
  {
    return getHibernateTemplate().get(getEntityClass(), id);
  }

  public List<T> getAll()
  {
    return getHibernateTemplate().loadAll(getEntityClass());
  }

  public void delete(T bean)
  {
    getHibernateTemplate().delete(bean);
  }

  public void delete(PK id)
  {
    Assert.notNull(id, "id不能为空");
    delete(get(id));
    this.logger.debug("delete entity {},id is {}" + this.entityClass.getSimpleName() + id);
  }

  public void deleteById(Integer id)
  {
    getHibernateTemplate().delete(get(id));
  }

  public void deleteAll(Collection<?> beans)
  {
    getHibernateTemplate().deleteAll(beans);
  }

  public <X> List<X> find(String hql, Object[] args)
  {
    return getHibernateTemplate().find(hql, args);
  }

  public Object findObject(String hql, Object[] args)
  {
    List result = getHibernateTemplate().find(hql, args);
    if ((result != null) && (result.size() > 0)) {
      return result.get(0);
    }
    return null;
  }

  public <T> List<T> findAll(Class<T> clazz)
  {
    return find("FROM " + 
      ReflectionUtils.getSimpleClassName(clazz), 
      new Object[0]);
  }

  public <T> T get(Class<T> clazz, Serializable id)
  {
    return getHibernateTemplate().get(clazz, id);
  }

  public void saveOrUpdate(Object bean)
  {
    getHibernateTemplate().saveOrUpdate(bean);
  }

  public void save(Object bean)
  {
    getHibernateTemplate().save(bean);
  }

  public Serializable saveReturnObject(Object bean)
  {
    return getHibernateTemplate().save(bean);
  }

  public void saveAll(List list)
  {
    getHibernateTemplate().saveOrUpdateAll(list);
  }

  public void update(Object bean)
  {
    getHibernateTemplate().update(bean);
  }
  
  public Page getAll(Page page)
  {
    return findPage(page, new Criterion[0]);
  }

  public Page findPage(Page page, String hql, Map<String, Object> values)
  {
    Assert.notNull(page, "page不能为空");

    if (page.isOrderBySetted()) {
      String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
      String[] orderArray = StringUtils.split(page.getOrder(), ',');

      Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

      hql = hql + " order by ";
      for (int j = 0; j < orderByArray.length; j++) {
        if (j != 0) {
          hql = hql + ", ";
        }
        hql = hql + orderByArray[j] + " " + orderArray[j];
      }
    }

    Query q = createQuery(hql, values);
    setPageParameter(q, page);
    List result = q.list();
    page.setResult(result);
    return page;
  }

  public Page findPage(Page page, Criterion[] criterions)
  {
    Assert.notNull(page, "page不能为空");

    Criteria c = createCriteria(criterions);

    if (page.isAutoCount()) {
      int total = countCriteriaResult(c);
      page.setTotal(total);
    }

    setPageParameter(c, page);
    List result = c.list();
    page.setResult(result);
    return page;
  }

  public Criteria createCriteria(Criterion[] criterions)
  {
    Criteria criteria = getSession().createCriteria(this.entityClass);
    for (Criterion c : criterions) {
      criteria.add(c);
    }
    return criteria;
  }

  protected Query setPageParameter(Query q, Page page)
  {
    q.setFirstResult(page.getFirst() - 1);
    q.setMaxResults(page.getPageSize());
    return q;
  }

  protected Criteria setPageParameter(Criteria c, Page page)
  {
    c.setFirstResult(page.getFirst() - 1);
    c.setMaxResults(page.getPageSize());

    if (page.isOrderBySetted()) {
      String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
      String[] orderArray = StringUtils.split(page.getOrder(), ',');

      Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

      for (int i = 0; i < orderByArray.length; i++) {
        if ("asc".equals(orderArray[i]))
          c.addOrder(Order.asc(orderByArray[i]));
        else {
          c.addOrder(Order.desc(orderByArray[i]));
        }
      }
    }
    return c;
  }

  protected int countCriteriaResult(Criteria c)
  {
    CriteriaImpl impl = (CriteriaImpl)c;

    Projection projection = impl.getProjection();
    ResultTransformer transformer = impl.getResultTransformer();

    List orderEntries = null;
    try {
      orderEntries = (List)ReflectionUtils.getFieldValue(impl, "orderEntries");
      ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }

    int totalCount = ((Integer)c.setProjection(Projections.rowCount()).uniqueResult()).intValue();

    c.setProjection(projection);

    if (projection == null) {
      c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
    }
    if (transformer != null)
      c.setResultTransformer(transformer);
    try
    {
      ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }

    return totalCount;
  }


  public Query createQuery(String queryString, Object[] values)
  {
    Assert.hasText(queryString, "queryString不能为空");
    Query query = getSession().createQuery(queryString);
    if (values != null) {
      for (int i = 0; i < values.length; i++) {
        query.setParameter(i, values[i]);
      }
    }
    return query;
  }

  public Query createQuery(String queryString, Map<String, Object> values)
  {
    Assert.hasText(queryString, "queryString不能为空");
    Query query = getSession().createQuery(queryString);
    if (values != null) {
      query.setProperties(values);
    }
    return query;
  }

  public Query distinct(Query query)
  {
    query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
    return query;
  }

  public List<T> getAll(String orderBy, boolean isAsc)
  {
    Criteria c = createCriteria(new Criterion[0]);
    if (isAsc)
      c.addOrder(Order.asc(orderBy));
    else
      c.addOrder(Order.desc(orderBy));
    return c.list();
  }

  public List<T> find(Criterion[] criterions)
  {
    return createCriteria(criterions).list();
  }
}