package day02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 测试动态代理
@SuppressWarnings("all")
public class ProxyTest {
	public static void main(String[] args) {
		ArrayList<Integer> target = new ArrayList<Integer>();
		List proxy = (List) getProxy(target, new AdviceImpl());
		proxy.add(5);
		proxy.add(4);
		System.out.println(proxy.size());
	}

	
	/**
	 * 生成代理对象
	 * @param target ： 代理对象
	 * @param advice ：切面类（增强）
	 * @return
	 */
	public static Object getProxy(final Object target, final Advice advice){
		Object proxyObj = Proxy.newProxyInstance
				(
				 target.getClass().getClassLoader(), // 类加载器
				 target.getClass().getInterfaces(),  // 目标对象所实现的接口
				 new InvocationHandler() {		
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						advice.beforeMethod();	// 目标代码执行前
						Object retValue = method.invoke(target, args); // 执行想要执行的代码
						advice.afterMethod();	// 目标代码执行后
						return retValue;
					}
				});
		return proxyObj;
	}
	
	
	public static void test(){
		Class proxyClass = Proxy.getProxyClass(ProxyTest.class.getClassLoader(), Collection.class);
		StringBuilder sBuilder = new StringBuilder(proxyClass.getName());
		Constructor[] constructors = proxyClass.getConstructors();
		for(Constructor constructor : constructors){
			sBuilder.append("(");
			Class[] parameterTypes = constructor.getParameterTypes();
			for(Class parameterType : parameterTypes){
				sBuilder.append(parameterType.getName()+",");
			}
			// 去掉最后一个，
			if(parameterTypes != null && parameterTypes.length > 0)
				sBuilder.deleteCharAt(sBuilder.length()-1);
			sBuilder.append(")");
		}
		System.out.println(sBuilder.toString());
	}
	
}
