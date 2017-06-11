package day02;

/**
 * 了解类加载器的委托机制
 * @author ming
 *
 */
public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
		while(classLoader != null){
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
		}
		// 此时classLoader已经为null（bootstrap：顶层类加载器）
		System.out.println(classLoader);
	}
}
