package a69_x的平方根;

import java.util.Arrays;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/04 20:17
 */
public class BinarySearch {

    // binarySearch: 二分查找。

    public static void main(String[] args) {
        int[] a = {1, 4, 8, 12, 34, 56, 78, 100, 150, 199, 299, 377, 400};
        // 去a数组查询是否包含50
        // boolean flag = false;
        // for (int i = 0; i < a.length; i++) {
        //     if (a[i] == 50) {
        //         flag = true;
        //         break;
        //     }
        // }
        // System.out.println(flag);




        // int m = Arrays.binarySearch(a, 78);
        // System.out.println(m);




        // int x = 50;
        // // 查询x在a中的位置
        // int i;
        // int count = 0;
        // for (i = 0; i < a.length; i++) {
        //     count++;
        //     if (a[i] == x) {
        //         System.out.println("在里面");
        //         break;
        //     }
        // }
        //
        // if (i == a.length) {
        //     System.out.println("不在里面");
        // }
        //
        // System.out.println("刚刚循环了" + count);


        // 二分查找
        int x = 8;
        int start = 0;
        int end = a.length - 1;
        int wz = -1; // x在数组中的位置，默认-1表示不在里面
        int count = 0;
        while (start <= end) { //结束循环的条件是start大于end
            count++;
            int middle = (start + end) / 2;
            // 中间位置的值就是a[middle]，判断a[middle]与x的大小
            if (a[middle] > x) {
                end = middle - 1;
            } else if (a[middle] < x) {
                start = middle + 1;
            } else {
                wz = middle;
                break;
            }
        }

        System.out.println(wz);

        System.out.println("刚刚一共循环了 " + count);

        Arrays.binarySearch(a, 10);
    }
}
