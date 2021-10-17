package a0面试题.多线程.实现所有的线程一起等待某个事件的发生;

/**
 * 多线程统计数据，最后汇总
 *
 * @author showshine.wangsh (beclever@126.com)
 *
 * @since 1.0
 * @version 2018-03-01 12:02
 *
 */

public class CountBigDataByJoinTest {

	private static int ai1 = 0;
	private static int ai2 = 0;
	private static int n = 2000000000;

	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		Thread countThread1 = new Thread(() -> {
			for(int i =0; i < n/2; i++) {
				ai1++;
			}
		});
		countThread1.start();
		Thread countThread2 = new Thread(() -> {
			for(int i =0; i < n/2; i++) {
				ai2++;
			}
		});
		countThread2.start();
		countThread1.join();
		countThread2.join();
		System.out.println(ai1+ ai2);
		System.out.println("use " + (System.nanoTime() - start)/(1000 * 1000) + " ms");
	}

}
