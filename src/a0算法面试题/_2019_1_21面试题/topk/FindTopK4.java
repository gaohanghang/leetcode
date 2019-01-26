package a0算法面试题._2019_1_21面试题.topk;

import javafx.geometry.VPos;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/26 18:33
 */
public class FindTopK4 {
    /*
        最大K最小堆
        最小K最大堆

        上面几种解法都会对数据访问多次，那么就有一个问题，当数组中元素个数非常大时，如：100亿，这时候数据不能全部加载到内存，就要求我们尽可能少的遍历所有数据。针对这种情况，下面我们介绍一种针对海量数据的解决方案。

        在学习堆排序的过程中，我们知道了堆这种数据结构。为了查找Top k大的数，我们可以使用小根堆来存储最大的K个元素。小根堆的堆顶元素就是最大K个数中最小的一个。每次考虑下一个数x时，如果x比堆顶元素小，则不需要改变原来的堆。如果想x比堆顶元素大，那么用x替换堆顶元素， 同时，在替换之后，x可能破坏最小堆的结构，需要调整堆来维持堆的性质。算法实现如下：

        总结：该算法只需要扫描所有的数据一次，且不会占用太多内存空间（只需要容纳K个元素的空间），尤其适合处理海量数据的场景。算法的时间复杂度为O(N * logk)，这实际上相当于执行了部分堆排序。
        扩展：当K仍然很大，导致内存无法容纳K个元素时，我们可以考虑先找最大的K1个元素，然后再找看K1+1到2*K1个元素，如此类推。（其中容量为K1的堆可以完全载入内存）
     */
    public static int[] findTopK(int[] array, int k) {
        int heapArray[] = new int[k];
        for (int i = 0; i < k; i++) {
            heapArray[i] = array[i];
        }
        buildMaxHeap(heapArray);
        for (int i = k; i < array.length; i++) {
            if (array[i] > heapArray[0]) {
                heapArray[0] = array[i];//更新堆顶
                adjustMaxHeap(heapArray, 0, heapArray.length);
            }
        }
        return heapArray;
    }

    /**
     * 构建小根堆
     *
     * @param array
     */
    public static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(array, i, array.length);
        }
    }

    /**
     * 调整堆结构
     *
     * @param array
     * @param root      根节点
     * @param length
     */
    public static void adjustMaxHeap(int[] array, int root, int length) {
        int left = root * 2 + 1; //左节点下标，数组下标从0开始，所以加1
        int right = left + 1; //右节点下标
        int largest = root;// 存放三个节点中最大节点的下标
        if (left < length && array[left] < array[root]) { //左节点小于根节点，更新最大节点的下标
            largest = left;
        }
        if (right < length && array[right] < array[largest]) {//右节点小于根节点，最大节点的下标
            largest = right;
        }
        if (root != largest) {
            swap(array, largest, root);
            adjustMaxHeap(array, largest, length);
        }
    }

    /**
     * 交换
     *
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
        int[] topK = findTopK(a, k);
        System.out.println(Arrays.toString(topK));
    }
}
