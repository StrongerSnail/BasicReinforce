package day02;

// 生成切面类（提取无关代码）
public interface Advice {
	void beforeMethod();	// 业务代码执行前执行
	void afterMethod();		// 业务代码执行后执行
}
