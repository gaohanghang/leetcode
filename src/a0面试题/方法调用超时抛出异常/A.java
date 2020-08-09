package a0面试题.方法调用超时抛出异常;

import java.util.concurrent.*;

/**
 *  A 类 调用 B 类的 void c(Object o) 方法，实现调用 c 方法在5秒内就正常进行，如果超过 5 秒则抛出超时异常
 */
public class A {

    public static void main(String args[]){

        B b = new B();

        final ExecutorService exec = Executors.newSingleThreadExecutor();
        Callable<String> call = new Callable<String>(){

            public String call() throws Exception {
                b.c(null);
                return "线程执行完";
            }
        };

        Future<String> future = exec.submit(call);
        String obj = null;
        try{
            obj = future.get(5, TimeUnit.SECONDS);
            System.out.print("任务成功返回"+obj);
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch(TimeoutException e){
            e.printStackTrace();
        }
        exec.shutdown();
    }

}
