package a0面试题.多线程.线程交替打印数字和字母;

/**
 * @Description http://www.voidcn.com/article/p-tbgwkxdi-bxn.html
 * @Author Gao Hang Hang
 * @Date 2019-09-09 20:02
 **/
public class AddNumAndWords {

    /**
     * 打印数字
     */
    private static class NumThread extends Thread {
        private final AddNumAndWords add;

        public NumThread(AddNumAndWords add) {
            this.add = add;
        }

        @Override
        public void run() {
            try {
                synchronized (add) {
                    for (int i = 1; i <= 3; i++) {
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

    /**
     * 打印字母
     */
    private static class WordThread extends Thread {

        private final AddNumAndWords add;

        public WordThread(AddNumAndWords add) {
            this.add = add;
        }

        @Override
        public void run() {
            try {
                synchronized (add) {
                    for (int i = 0; i < 3; i++) {
                        add.wait();
                        char ss = (char) (97 + i);
                        System.out.print(ss);
                        add.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建实例
        AddNumAndWords add = new AddNumAndWords();
        // 创建两个线程并启动
        Thread t1 = new WordThread(add);
        Thread t2 = new NumThread(add);
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
