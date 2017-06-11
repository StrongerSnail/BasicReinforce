package day02;

// 切面类具体实现
public class AdviceImpl implements Advice {

	@Override
	public void beforeMethod() {
		System.out.println("hello liming");
	}

	@Override
	public void afterMethod() {
		System.out.println("but i don't want to meet you");
	}

}
