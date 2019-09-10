package a0算法面试题.线程交替打印;

/**
 * @Description http://www.voidcn.com/article/p-tbgwkxdi-bxn.html
 * @Author Gao Hang Hang
 * @Date 2019-09-09 20:02
 **/
public class AddNumAndWords {
    private static class demoThread1 extends Thread {
        private final AddNumAndWords add;
        public demoThread1(AddNumAndWords add) {
            this.add = add;
        }
        @Override
        public void run() {
            try {
                synchronized (add) {
                    for (int i = 1; i <=3; i++) {
                        System.out.print(i);
                        add.notifyAll();
                        add.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class demoThread2 extends Thread {
        private final AddNumAndWords add;
        public demoThread2(AddNumAndWords add) {
            this.add = add;
        }
        @Override
        public void run() {
            try {
                synchronized (add) {
                    for (int i = 0; i < 3; i++) {
                        add.wait();
                        char ss = (char) (97 + i);
                        System.out.print(String.valueOf(ss));
                        add.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AddNumAndWords add = new AddNumAndWords();
        Thread t1 = new demoThread2(add);
        Thread t2 = new demoThread1(add);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
