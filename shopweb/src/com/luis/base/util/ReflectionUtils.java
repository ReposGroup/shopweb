package com.luis.base.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class ReflectionUtils
{
  private static Logger log = Logger.getLogger(ReflectionUtils.class);

  public static String getSimpleClassName(Class<?> clazz)
  {
    String packageName = clazz.getPackage().getName();
    String className = clazz.getName();
    return className.substring(packageName.length() + 1);
  }

  public static Object getFieldValue(Object object, String fieldName)
  {
    Field field = getDeclaredField(object, fieldName);

    if (field == null) {
      throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
    }
    makeAccessible(field);

    Object result = null;
    try {
      result = field.get(object);
    } catch (IllegalAccessException e) {
      log.error(e);
    }
    return result;
  }

  public static void setFieldValue(Object object, String fieldName, Object value)
  {
    Field field = getDeclaredField(object, fieldName);

    if (field == null) {
      throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
    }
    makeAccessible(field);
    try
    {
      field.set(object, value);
    } catch (IllegalAccessException e) {
      log.error(e.getMessage());
    }
  }

  public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters)
  {
    Method method = getDeclaredMethod(object, methodName, parameterTypes);
    if (method == null) {
      throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
    }
    method.setAccessible(true);
    try
    {
      return method.invoke(object, parameters); } catch (Exception e) {
    	  throw convertReflectionExceptionToUnchecked(e);
    }
  }

  protected static Field getDeclaredField(Object object, String fieldName)
  {
    Assert.notNull(object, "object不能为空");
    Assert.hasText(fieldName, "fieldName");
    for (Class superClass = object.getClass(); superClass != Object.class; ) {
      try
      {
        return superClass.getDeclaredField(fieldName);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        superClass = superClass
          .getSuperclass();
      }

    }

    return null;
  }

  protected static void makeAccessible(Field field)
  {
    if ((!Modifier.isPublic(field.getModifiers())) || (!Modifier.isPublic(field.getDeclaringClass().getModifiers())))
      field.setAccessible(true);
  }

  protected static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes)
  {
    Assert.notNull(object, "object不能为空");

    for (Class superClass = object.getClass(); superClass != Object.class; ) {
      try
      {
        return superClass.getDeclaredMethod(methodName, parameterTypes);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        superClass = superClass
          .getSuperclass();
      }

    }

    return null;
  }

  public static <T> Class<T> getSuperClassGenricType(Class clazz)
  {
    return getSuperClassGenricType(clazz, 0);
  }

  public static Class getSuperClassGenricType(Class clazz, int index)
  {
    Type genType = clazz.getGenericSuperclass();

    if (!(genType instanceof ParameterizedType)) {
      log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
      return Object.class;
    }

    Type[] params = ((ParameterizedType)genType).getActualTypeArguments();

    if ((index >= params.length) || (index < 0)) {
      log.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + 
        params.length);
      return Object.class;
    }
    if (!(params[index] instanceof Class)) {
      log.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
      return Object.class;
    }

    return (Class)params[index];
  }

  public static List convertElementPropertyToList(Collection collection, String propertyName)
  {
    List list = new ArrayList();
    try
    {
      for (Iterator localIterator = collection.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
        list.add(PropertyUtils.getProperty(obj, propertyName)); }
    }
    catch (Exception e) {
      throw convertReflectionExceptionToUnchecked(e);
    }

    return list;
  }

  public static String convertElementPropertyToString(Collection collection, String propertyName, String separator)
  {
    List list = convertElementPropertyToList(collection, propertyName);
    return StringUtils.join(list, separator);
  }

  public static Object convertValue(Object value, Class<?> toType)
  {
    try
    {
      DateConverter dc = new DateConverter();
      dc.setUseLocaleFormat(true);
      dc.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" });
      ConvertUtils.register(dc, Date.class);
      return ConvertUtils.convert(value, toType); 
      }catch (Exception e) {
    	  throw convertReflectionExceptionToUnchecked(e);
    }
  }

  public static RuntimeException convertReflectionExceptionToUnchecked(Exception e)
  {
    if (((e instanceof IllegalAccessException)) || ((e instanceof IllegalArgumentException)) || 
      ((e instanceof NoSuchMethodException)))
      return new IllegalArgumentException("Reflection Exception.", e);
    if ((e instanceof InvocationTargetException)) {
      return new RuntimeException("Reflection Exception.", ((InvocationTargetException)e).getTargetException());
    }

    return new RuntimeException("Unexpected Exception.", e);
  }

  public static Object eval(Object object, String field)
    throws NoSuchFieldException, IllegalAccessException
  {
    String[] fields = (String[])null;
    if (field.indexOf('.') != -1)
      fields = field.split("\\.");
    else {
      fields = new String[] { field };
    }
    Object obj = object;
    for (int i = 0; i < fields.length; i++) {
      String property = fields[i].trim();
      Field propField = getField(obj.getClass(), property);
      if (propField == null) throw new NoSuchFieldException(property);
      obj = eval(obj, propField);
      if (obj == null) return null;
    }
    return obj;
  }

  public static Object eval(Object object, Field field)
    throws IllegalAccessException
  {
    String fieldName;
    try
    {
      return field.get(object);
    } catch (Exception e) {
      Class type = field.getType();
      fieldName = field.getName();
      String getterName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
      if ((Boolean.TYPE.equals(type)) || (Boolean.class.equals(type)))
        getterName = "is" + getterName;
      else {
        getterName = "get" + getterName;
      }
      try
      {
        Method getter = getMethod(object.getClass(), getterName, new Class[0]);
        return getter.invoke(object, new Object[0]); } catch (Exception ex) {
      }
    }
    throw new IllegalAccessException("Access field " + fieldName + " failed");
  }

  public static Method getter(Object object, Field field)
    throws NoSuchMethodException
  {
    Class type = field.getType();
    String fieldName = field.getName();
    String getterName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    if ((Boolean.TYPE.equals(type)) || (Boolean.class.equals(type)))
      getterName = "is" + getterName;
    else {
      getterName = "get" + getterName;
    }
    return getMethod(object.getClass(), getterName, new Class[0]);
  }

  public static void set(Object object, String field, Object value)
    throws IllegalAccessException, NoSuchFieldException, InstantiationException
  {
    String[] fields = (String[])null;
    if (field.indexOf('.') != -1)
      fields = field.split("\\.");
    else {
      fields = new String[] { field };
    }
    Object obj = object;
    for (int i = 0; i < fields.length; i++) {
      String property = fields[i].trim();
      Field propField = getField(obj.getClass(), property);
      try {
        Method getter = getter(obj, propField);
        Class propClass = null;

        Object propValue = null;
        if (i >= fields.length - 1) {
          propValue = value;
        } else {
          propClass = getter.getReturnType();
          propValue = propClass.newInstance();
        }
        set(obj, propField, propValue);
        obj = propValue;
      } catch (NoSuchMethodException e) {
        throw new IllegalAccessException(e.getMessage());
      }
    }
  }

  public static void set(Object object, Field field, Object value)
    throws IllegalAccessException
  {
    try
    {
      field.set(object, value);
    } catch (Exception e) {
      String fieldName = field.getName();
      String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
      try {
        invoke(object, setterName, new Class[] { field.getType() }, new Object[] { value });
      } catch (Exception ex) {
        throw new IllegalAccessException("Access field " + fieldName + " failed");
      }
    }
  }

  public static Method[] getDeclaredMethods(Class clazz)
  {
    return clazz.getDeclaredMethods();
  }

  public static Method[] getMethods(Class clazz)
    throws SecurityException
  {
    return clazz.getMethods();
  }

  public static Method getMethod(Class clazz, String methodName, Class[] paramTypes)
    throws SecurityException, NoSuchMethodException
  {
    Method method = null;

    Method[] methods = getDeclaredMethods(clazz);
    for (int i = 0; i < methods.length; i++) {
      if ((!methods[i].getName().equals(methodName)) || 
        (!arrayContentsEq(paramTypes, methods[i].getParameterTypes()))) continue;
      method = methods[i];
    }

    if (method == null) {
      methods = getMethods(clazz);
      for (int i = 0; i < methods.length; i++) {
        if ((!methods[i].getName().equals(methodName)) || 
          (!arrayContentsEq(paramTypes, methods[i].getParameterTypes()))) continue;
        method = methods[i];
      }

    }

    if (method == null)
      throw new NoSuchMethodException(clazz.getName() + "." + methodName + argumentTypesToString(paramTypes));
    return method;
  }

  public static Field[] getDeclaredFields(Class clazz)
    throws SecurityException
  {
    return clazz.getDeclaredFields();
  }

  public static Field[] getFields(Class clazz)
    throws SecurityException
  {
    return clazz.getFields();
  }

  public static Field getField(Class clazz, String fieldName)
    throws SecurityException, NoSuchFieldException
  {
    Field[] fields = clazz.getDeclaredFields();
    Field field = null;
    for (int i = 0; i < fields.length; i++) {
      if (fields[i].getName().equals(fieldName)) {
        field = fields[i];
        break;
      }
    }
    if (field == null) {
      fields = clazz.getFields();
      for (int i = 0; i < fields.length; i++) {
        if (fields[i].getName().equals(fieldName)) {
          field = fields[i];
          break;
        }
      }
    }
    return field;
  }

  public static Object invoke(Object object, String methodName, Class[] paramTypes, Object[] args)
    throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    Method method = null;
    if ((object instanceof Class))
      method = getMethod((Class)object, methodName, paramTypes);
    else {
      method = getMethod(object.getClass(), methodName, paramTypes);
    }
    return method.invoke(object, args);
  }

  private static String argumentTypesToString(Class[] argTypes)
  {
    StringBuffer buf = new StringBuffer();
    buf.append("(");
    if (argTypes != null) {
      for (int i = 0; i < argTypes.length; i++) {
        if (i > 0) {
          buf.append(", ");
        }
        Class c = argTypes[i];
        buf.append(c == null ? "null" : c.getName());
      }
    }
    buf.append(")");
    return buf.toString();
  }

  private static boolean arrayContentsEq(Object[] a1, Object[] a2)
  {
    if (a1 == null) {
      return (a2 == null) || (a2.length == 0);
    }

    if (a2 == null) {
      return a1.length == 0;
    }

    if (a1.length != a2.length) {
      return false;
    }

    for (int i = 0; i < a1.length; i++) {
      if (!a1[i].equals(a2[i])) {
        return false;
      }
    }

    return true;
  }
}