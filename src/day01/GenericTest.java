package day01;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * 测试泛型:泛型的作用域实在java文件（给编译器看的），当编译完成之后泛型已经被擦除
 * @author ming
 *
 */
public class GenericTest<T> {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("c");
		list.add("b");
		getParameteriedType();
	}
	
	// Collection<Object> c = new List<String>
	public static void test(Collection<? extends Object> c){
		for(Object value : c){
			System.out.println(value);
		}
		System.out.println(c.size());
	}

	public void applyVector(Vector<Integer> v){
		
	}

	// 通过反射获取参数泛型的实际参数
	public static void getParameteriedType() throws NoSuchMethodException, SecurityException{
		// 通过字节码文件调用想调用的方法
		Method applyMethod = GenericTest.class.getMethod("applyVector", Vector.class);
		ParameterizedType pType = (ParameterizedType) applyMethod.getGenericParameterTypes()[0];
		System.out.println(pType.getActualTypeArguments()[0]);
	}

	
}
	