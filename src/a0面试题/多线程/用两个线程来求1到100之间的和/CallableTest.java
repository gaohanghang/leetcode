package a0面试题.多线程.用两个线程来求1到100之间的和;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

// 用两个线程来求1-100之间的和
// 要想实现此功能，需要使用JDK5.0的新功能Callable
// 实现步骤：
// 1. 编写一个类，该类需要实现Callable接口。
class OddNum implements Callable<Integer> {
	// 计算100以内奇数的和
	// 2. 在实现Callable接口类中重写call方法，该方法是线程核心方法
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=1; i<100; i+=2) {
			sum += i;
		}
		return sum;
	}
}

class EvenNum implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=2; i<= 100; i+=2) {
			sum += i;
		}
		return sum;
	}
}

public class CallableTest {

	public static void main(String[] args) {
		// 3. 创建实现了 Callable 接口类的对象
		OddNum odd = new OddNum();
		EvenNum even = new EvenNum();

		// 4. 创建 FutureTask 类的对象，并把实现了Callable接口类的对象以参数方式传给FutureTask类的构造器
		FutureTask<Integer> oddFuture = new FutureTask<>(odd);
		FutureTask<Integer> evenFuture = new FutureTask<>(even);

		// 5. 把FutureTask对象以参数的形式传Thread类的构造器来创建线程对象，并调用该对象的start()方法来启动线程
		new Thread(oddFuture).start();
		new Thread(evenFuture).start();

		try {
			// 6. 通过调用FutureTask对象的get()方法来获取线程执行结果
			Integer oddSum = oddFuture.get();
			Integer evenSum = evenFuture.get();
			System.out.println("总和为：" + (oddSum + evenSum));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}
