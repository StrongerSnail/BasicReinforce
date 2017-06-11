package day01;

@MyAnnotation(values={1,2,4})
public class AnnotationTest {
	public static void main(String[] args) {
		// 判断当前类是否存在注解类
		if(AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)){
			// 通过反射获取注解类
			MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
			System.out.println(annotation.targetPath());
			System.out.println(annotation.values().length);
		}
	}
}
