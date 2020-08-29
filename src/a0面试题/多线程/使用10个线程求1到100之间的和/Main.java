package a0面试题.多线程.使用10个线程求1到100之间的和;

class MyThread extends Thread {

    int number;
    public static int sum;

    // 构造函数
    public MyThread(int n) {
        number = n;
    }

    // 同步方法
    public static synchronized void add(int num) {
        sum += num;
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += number + i;
        }
        System.out.println("The " + (number / 10 + 1) + " time: " + count);
        add(count);
    }

}

public class Main {

    public static void main(String args[]) {
        MyThread myThreads[] = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            myThreads[i] = new MyThread(i * 10 + 1);
            myThreads[i].start();
            try {
                myThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total is " + MyThread.sum);
    }

}
