package a0算法面试题.多线程.使用4个子线程求出1到100的和;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-07 10:34
 **/
public class FourThread {

    static int sum11 = 0;
    static int sum12 = 0;
    static int sum13 = 0;
    static int sum14 = 0;
    static int sum = 0;

    public static void main(String[] args) {
        /**
         * 使用4个子线程求出1到100的和,且每个子线程只能计算25个数,主线程必须等待子线程
         */
        new Thread() {
            @Override
            public void run() {
                int sum1 = 0;
                for (int i = 1; i <= 25; i++) {
                    sum1 += i;
                }
                sum11 += sum1;
                System.out.println(Thread.currentThread().getName() + " " + sum11);
            }

            ;
        }.start();

        new Thread() {
            public void run() {

                int sum2 = 0;
                for (int i = 26; i <= 50; i++) {
                    sum2 += i;
                }
                sum12 += sum2;
                System.out.println(Thread.currentThread().getName() + " " + sum12);

            }

            ;
        }.start();

        new Thread() {

            public void run() {

                int sum3 = 0;
                for (int i = 51; i <= 75; i++) {
                    sum3 += i;
                }
                sum13 += sum3;
                System.out.println(Thread.currentThread().getName() + " " + sum13);

            }

            ;
        }.start();

        new Thread() {
            public void run() {
                int sum4 = 0;
                for (int i = 76; i <= 100; i++) {
                    sum4 += i;
                }
                sum14 = sum4;
                System.out.println(Thread.currentThread().getName() + " " + sum14);


            }

            ;

        }.start();


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = sum11 + sum12 + sum13 + sum14;
        System.out.println("sum: " + sum);

    }

}
