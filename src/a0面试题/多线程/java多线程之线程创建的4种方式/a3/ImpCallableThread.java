package a0面试题.多线程.java多线程之线程创建的4种方式.a3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-18 12:07
 **/
public class ImpCallableThread implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("子线程" + Thread.currentThread().getName() + "正在执行 ");
        return "返回值";
    }

}

class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new ImpCallableThread());
        new Thread(task).run();
        System.out.println("线程中获取到的返回信息  " + task.get() );
    }
}
