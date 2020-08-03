package a0算法面试题.单例设计模式.设计模式Java版.a2;

import a0算法面试题.单例设计模式.设计模式Java版.GlobalNum;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 13:08
 **/
public class GlobelNum {

    private static GlobalNum gn = new GlobalNum();

    private int num = 0;

    public static GlobalNum getInstance() {
        return gn;
    }


    public synchronized int getNum() {
        return ++num;
    }

}
