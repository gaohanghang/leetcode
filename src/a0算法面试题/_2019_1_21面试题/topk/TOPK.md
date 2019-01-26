# TOP-K问题的几种解法

## 解法一 先排序，后查找最大的k个元素
最简单且最容易想到的算法是对数组进行排序（快速排序），然后取最大或最小的K个元素。总的时间复杂度为O(N*logN)+O(K)=O(N*logN)。该算法存在以下问题：

1. 快速排序的平均复杂度为O(N*logN)，但最坏时间复杂度为O(n2)，不能始终保证较好的复杂度
2. 只需要前k大或k小的数,，实际对其余不需要的数也进行了排序，浪费了大量排序时间

总结：通常不会采取该方案。

## 解法二 使用快速排序思想解题

虽然我们不会采用快速排序的算法来实现TOP-K问题，但我们可以利用快速排序的思想，
在数组中随机找一个元素key，将数组分成两部分Sa和Sb，其中Sa的元素>=key，Sb的元素<key，然后分析两种情况：

```java
public class findTopK {

    public static int findTopK(int[] a, int lo, int hi, int k) {
        int index = -1;
        if (lo < hi) { // 如果lo < hi直接返回-1
            int j = partition(a, lo, hi);
            int len = j - lo + 1;
            if (len == k) {
                index = j;
            } else if (len < k) { // Sa中元素个数小于K，到Sb中查找k-len个数字
                index = findTopK(a, j + 1, hi, k - len);
            } else { //Sa中元素的个数大于或等于k
                index = findTopK(a, lo, j - 1, k);
            }
        }
        return index;
    }

    /**
     * 按切分元素划分数组，左边的元素大于切分元素，右边的元素小于切分元素
     */
    public static int partition(int[] a, int lo, int hi) {
        // 将数组切分为a[lo..i-1], a[i], a[i+1..hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        int v = a[lo];          // 切分元素
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(v, a[++i])) if (i == hi) break;
            while (less(a[--j], v)) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);         // 将v = a[j]放入正确的位置
        return j;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26, 100};
        int k = 100;
        findTopK(a, 0, a.length - 1, k);
        show(a);
    }
}
```
## 解法三 使用第k大解决

寻找Ｎ个数中的第Ｋ大的数，可以将问题转化寻找Ｎ个数中第K大的问题。对于一个给定的数p， 可以在O(N)的时间复杂度内找出所有不小于P的数。

根据分析，可以使用二分查找的算法思想来寻找Ｎ个数中第K大的数。假设N个数中最大的数为Vmax，最小的数为Vmin, 那么Ｎ个数中第K大的数一定在区间[Vmin,Vmax]之间。然后在这个区间使用二分查找算法。算法实现如下：

```java
public class FindTopK3 {

    /*
        解法三
        寻找Ｎ个数中的第Ｋ大的数，可以将问题转化寻找Ｎ个数中第K大的问题。对于一个给定的数p， 可以在O(N)的时间复杂度内找出所有不小于P的数。

        根据分析，可以使用二分查找的算法思想来寻找Ｎ个数中第K大的数。假设N个数中最大的数为Vmax，最小的数为Vmin, 那么Ｎ个数中第K大的数一定在区间[Vmin,Vmax]之间。然后在这个区间使用二分查找算法。算法实现如下：

        总结：该算法实际应用效果不佳，尤其是不同的数据类型需要确定max - min > delta，因此时间复杂度跟数据分布有关。 整个算法的时间复杂度为O(N * log（Vmax-Vmin）/delta)，在数据分布平均的情况下，时间复杂度为O(N * logN)。
     */
    public static List<Integer> findTopK(int[] a, int k) {
        int max = a[0];
        int min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            if (min > a[i]) {
                min = a[i];
            }
        }
        List<Integer> topKList = new ArrayList<>();
        int key = findK(a, max, min, k); // 找到第k大元素
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= key) {
                topKList.add(a[i]);
            }
        }
        return topKList;
    }

    /**
     * 寻找第K大的元素
     *
     * @param array
     * @param max
     * @param min
     * @param k
     * @return
     */
    private static int findK(int[] array, int max, int min, int k) {
        while (max - min > 1) {
            int mid = (max + min) / 2;
            int num = findKNum(array, mid);
            if (num >= k) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }

    /**
     * 统计不小于key的元素个数
     *
     * @param array
     * @param key
     * @return
     */
    private static int findKNum(int[] array, int key) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= key) sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
        List<Integer> topK = findTopK(a, k);
        System.out.println(topK);
    }
}
```
总结：该算法实际应用效果不佳，尤其是不同的数据类型需要确定max - min > delta，因此时间复杂度跟数据分布有关。 整个算法的时间复杂度为O(N * log（Vmax-Vmin）/delta)，在数据分布平均的情况下，时间复杂度为O(N * logN)。

## 解法四

上面几种解法都会对数据访问多次，那么就有一个问题，当数组中元素个数非常大时，如：100亿，这时候数据不能全部加载到内存，就要求我们尽可能少的遍历所有数据。针对这种情况，下面我们介绍一种针对海量数据的解决方案。

在学习堆排序的过程中，我们知道了堆这种数据结构。为了查找Top k大的数，我们可以使用大根堆来存储最大的K个元素。大根堆的堆顶元素就是最大K个数中最小的一个。每次考虑下一个数x时，如果x比堆顶元素小，则不需要改变原来的堆。如果想x比堆顶元素大，那么用x替换堆顶元素， 同时，在替换之后，x可能破坏最小堆的结构，需要调整堆来维持堆的性质。算法实现如下：

```java
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
```
总结：该算法只需要扫描所有的数据一次，且不会占用太多内存空间（只需要容纳K个元素的空间），尤其适合处理海量数据的场景。算法的时间复杂度为O(N * logk)，这实际上相当于执行了部分堆排序。

扩展：当K仍然很大，导致内存无法容纳K个元素时，我们可以考虑先找最大的K1个元素，然后再找看K1+1到2*K1个元素，如此类推。（其中容量为K1的堆可以完全载入内存）

## 解法五 计数排序的思想

TOP-K问题是一个经典的问题，这个问题是存在线性算法的，只不过算法的使用范围有一定的限制。如果所有N个数都是正整数，且他们的取值范围并不大，可以考虑申请空间，记录每个整数出现的次数，然后再从大到小取最大的K个。实际就是利用计数排序的思想。 假设所有整数都在（0，maxN）区间，利用一个数组count[maxN]来记录每个整数出现的次数。count[i]表示整数i在N个数中出现的次数。只需要扫描一遍就可以得到count数组，然后寻找第K大的元素。算法实现如下：

```java
public class FindTopK5 {
    /*
        TOP-K问题是一个经典的问题，这个问题是存在线性算法的，只不过算法的使用范围有一定的限制。
        如果所有N个数都是正整数，且他们的取值范围并不大，可以考虑申请空间，记录每个整数出现的次数，然后再从大到小取最大的K个。
        实际就是利用计数排序的思想。 假设所有整数都在（0，maxN）区间，利用一个数组count[maxN]来记录每个整数出现的次数。count[i]表示整数i在N个数中出现的次数。只需要扫描一遍就可以得到count数组，然后寻找第K大的元素。算法实现如下：

        这是一个典型的以空间换取时间的做法。当数组中取值范围比较大时，是及其浪费空间的。如[3,1...9999]，为了求出最大的K个元素，需要额外申请一个长度为10000的数组。

        极端情况下，如果 N 个整数各不相同，我们甚至只需要一个 bit (0,1) 来存储这个整数是否存在，这样可节省很大的内存空间。
     */
    
    public static List<Integer> findTopK(int[] array, int k) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int count[] = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            count[array[i]] += 1;
        }
        List<Integer> topKList = new ArrayList<>();
        for (int sumCount = 0,j = count.length - 1; j >= 0; j--) {
            int c = count[j];
            sumCount += c;
            if (c > 0) {
                for (int i = 0; i < c; i++) { // 如果c = 2 比如100有两个说明，要add两次
                    topKList.add(j);
                }
            }
            if (sumCount >= k) {
                break;
            }
        }
        return topKList;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] a = {20, 100, 4, 2, 87, 9, 8, 5, 46, 26};
        List<Integer> topK = findTopK(a, k);
        System.out.println(topK);
    }
}
```
这是一个典型的以空间换取时间的做法。当数组中取值范围比较大时，是及其浪费空间的。如[3,1...9999]，为了求出最大的K个元素，需要额外申请一个长度为10000的数组。

极端情况下，如果 N 个整数各不相同，我们甚至只需要一个 bit 来存储这个整数是否存在，这样可节省很大的内存空间。

本文部分内容参考书籍《编程之美》。







