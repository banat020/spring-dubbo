package com.banling.springdubbo.ds.base.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {
	
	/**取得泛型中的Class
	 * @param clazz ,Class.
	 * @param index ,int. 
	 * @return Class
	 */
	public static Class getSuperClassType(Class clazz, int index){
		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}

		return (Class) params[index];		
	}
	
	/**通过反射调用实例方法
	 * @param owner, Object
	 * @param methodName, methodName
	 * @param args, Object[]
	 * @return Object
	 * @throws Exception
	 */
	public static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class[] argsClass = null;
		Class ownerClass = owner.getClass();
		if (args != null) {
			argsClass = new Class[args.length];
			for (int i = 0, j = args.length; i < j; i++) {
				argsClass[i] = args[i].getClass();
			}
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(owner, args);
	}
}
