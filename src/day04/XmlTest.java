package day04;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * 测试xml解析方式
 * @author ming
 *
 */
public class XmlTest {
	public static void main(String[] args) {
		
	}
	
	@Test
	public void parseXml(){
		try {
			// 获取解析器->获取跟元素
			SAXReader reader = new SAXReader();
			
			// 如果不以/开头则默认是在当前类路径下开始寻找
//			InputStream in = this.getClass().getResourceAsStream("/config/Address.xml");
			
			// 不能以/开头，是从src下开始寻找
			InputStream in = this.getClass().getClassLoader().getResourceAsStream("config/Address.xml");
//			Document document = reader.read("src/day04/address.xml");
			
			Document document = reader.read(in);
			Element rootElement = document.getRootElement();
			System.out.println(rootElement.getName());
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
}
