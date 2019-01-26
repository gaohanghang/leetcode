# 数据结构——堆（Heap）大根堆、小根堆

> https://www.cnblogs.com/wangchaowei/p/8288216.html

- Heap是一种数据结构具有以下的特点：

1) 完全二叉树;
2) heap中存储的值是偏序;

- Min-heap: 父节点的值小于或等于子节点的值;
Max-heap: 父节点的值大于或等于子节点的值;

![](https://ws4.sinaimg.cn/large/006tNc79ly1fzk6aih6z2j30ib0bb3zn.jpg)

1. 堆的存储：
一般都用数组来表示堆，i结点的父结点下标就为(i–1)/2。它的左右子结点下标分别为2 * i + 1和2 * i + 2。如第0个结点左右子结点下标分别为1和2。

![](https://ws1.sinaimg.cn/large/006tNc79ly1fzk6ci2qegj30be04mjs8.jpg)

2. 堆的操作：insert
插入一个元素：新元素被加入到heap的末尾，然后更新树以恢复堆的次序。

每次插入都是将新数据放在数组最后。可以发现从这个新数据的父结点到根结点必然为一个有序的数列，现在的任务是将这个新数据插入到这个有序数据中——这就类似于直接插入排序中将一个数据并入到有序区间中。

![](https://ws4.sinaimg.cn/large/006tNc79ly1fzk6dt40fcj30h009e75t.jpg)

3. 堆的操作：Removemax

![](https://ws1.sinaimg.cn/large/006tNc79ly1fzk6hpl61aj30i50bz76o.jpg)

4. 堆的操作：buildHeap 堆化数组

对于叶子节点，不用调整次序，根据满二叉树的性质，叶子节点比内部节点的个数多1.所以i=n/2 -1 ，不用从n开始。

5. 堆排序

堆建好之后堆中第0个数据是堆中最大的数据。取出这个数据再执行下堆的删除操作。这样堆中第0个数据又是堆中最大的数据，重复上述步骤直至堆中只有一个数据时就直接取出这个数据。




