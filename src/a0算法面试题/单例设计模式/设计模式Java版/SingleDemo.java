package a0算法面试题.单例设计模式.设计模式Java版;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 12:58
 **/
public class SingleDemo {

    // 测试单例模式
    public static void main(String[] args) {
        // 创建线程A
        NumThread threadA = new NumThread("线程A");

        // 创建线程B
        NumThread threadB = new NumThread("线程B");

        // 启动线程
        threadA.start();
        threadB.start();
    }

}
// 线程类
class NumThread extends Thread{

    private String threadName;

    public NumThread(String name) {
        threadName = name;
    }

    // 重新线程的 run 方法（线程任务）
    @Override
    public void run() {
        GlobalNum gnObj = GlobalNum.getInstance();

        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + "第" + gnObj.getNum() + "次访问！");
            try {
                this.sleep(1000); // 线程休眠1000毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
