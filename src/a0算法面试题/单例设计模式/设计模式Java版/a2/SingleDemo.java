package a0算法面试题.单例设计模式.设计模式Java版.a2;

import a0算法面试题.单例设计模式.设计模式Java版.GlobalNum;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 13:10
 **/
public class SingleDemo {

    // 测试单例模式
    public static void main(String[] args) {
        // 创建线程A
        NumThread threadA = new NumThread("线程A");

        NumThread threadB = new NumThread("线程B");

        threadA.start();
        threadB.start();
    }

}

class NumThread extends Thread {

    private String threadName;

    public NumThread(String name) {
        threadName = name;
    }

    // 线程任务
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            GlobalNum gnObj = GlobalNum.getInstance();
            System.out.println(threadName + "第"+ gnObj.getNum() + "次访问！");
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
