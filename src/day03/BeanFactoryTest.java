package day03;

import java.io.InputStream;

public class BeanFactoryTest {
	public static void main(String[] args) {
		InputStream ips = BeanFactoryTest.class.getResourceAsStream("config.properties");
		ProxyBeanFactory beanFactory = new ProxyBeanFactory(ips);
		Object bean =  beanFactory.getBean("yyy");
		System.out.println(bean.getClass().getName());
	}
}
