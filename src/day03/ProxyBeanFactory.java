package day03;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import day02.Advice;
import day02.ProxyTest;

/**
 * 在配置文件中生成bean对象
 * @author ming
 *
 */
public class ProxyBeanFactory {
	
	private Properties props = new Properties();
	public ProxyBeanFactory(){}
	public ProxyBeanFactory(InputStream ips){
		try {
			props.load(ips);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private Object target;	// 目标对象
	private Advice advice;	// 要增强的切面类


	/**
	 * 生成bean对象: 如果是普通实例就直接返回
	 * @param name
	 * @return
	 */
	public Object getBean(String key){
		String className = props.getProperty(key);
		Object instance = null;
		try {
			instance = Class.forName(className).newInstance();
			if(instance instanceof ProxyBeanFactory){	// 判断是否需要生成代理Bean对象
				// 获取target , 以及增强代码
			    target = Class.forName(props.getProperty(key+".target")).newInstance();
			    advice = (Advice) Class.forName(props.getProperty(key+".advice")).newInstance();
				Object proxyObj = ProxyTest.getProxy(target, advice);
				return proxyObj;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return instance;
	}
	
}
