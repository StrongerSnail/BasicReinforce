package day01;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义泛型: 首先应该确定保留策略，其次确定泛型的作用域
 * @author ming
 */

@Retention(RetentionPolicy.RUNTIME)	// 运行时起作用
@Target(ElementType.TYPE)
public @interface MyAnnotation {
	String targetPath() default "index.jsp";
	int[] values();
}
