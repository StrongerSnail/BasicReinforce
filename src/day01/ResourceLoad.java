package day01;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import org.junit.Test;

// 测试加载资源的方法
public class ResourceLoad {
	
	@Test
	public void test01() throws Exception{
		/**
		 * 1. 通过类加载器加载配置文件
		 * 2. 通过反射生成对象
		 */
		
		// 从根文件开始查找
		InputStream inStream = ResourceLoad.class.getClassLoader().getResourceAsStream("day01/file.properties");
		Properties p = new Properties();
		p.load(inStream);
		
		String className = p.getProperty("className");
		Collection c = (Collection) Class.forName(className).newInstance();
		System.out.println(c);
		
	}
	
	@Test
	public void test02() throws Exception{
		/**
		 * 1. 通过类加载器加载配置文件
		 * 2. 通过反射生成对象
		 */
		
		// 可以从根文件开始查找也可以从当前类开始查找
//		InputStream inStream = ResourceLoad.class.getResourceAsStream("file.properties");
		InputStream inStream = ResourceLoad.class.getResourceAsStream("day01/file.properties");
		Properties p = new Properties();
		p.load(inStream);
		
		String className = p.getProperty("className");
		Collection c = (Collection) Class.forName(className).newInstance();
		System.out.println(c);
		
	}
	
}
