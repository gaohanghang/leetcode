> 作者：LeetCode
> 链接：https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/
> 来源：力扣（LeetCode）

## 综述

该问题看起来很简单，使用 Set 或 HashMap 可以在 O(N) 的时间和 O(N) 的空间内解决。

真正的挑战在于 Google 面试官要求使用常数空间解决该问题（最近 6 个月该问题在 Google 上非常流行），测试应聘者是否熟练位操作。

## 方法一：HashSet
将输入数组存储到 HashSet，然后使用 HashSet 中数字和的三倍与数组之和比较。

3×(a+b+c)−(a+a+a+b+b+b+c)=2c

```java
class Solution {
  public int singleNumber(int[] nums) {
    Set<Long> set = new HashSet<>();
    long sumSet = 0, sumArray = 0;
    for(int n : nums) {
      sumArray += n;
      set.add((long)n);
    }
    for(Long s : set) sumSet += s;
    return (int)((3 * sumSet - sumArray) / 2);
  }
}
```

### 复杂度分析

- 时间复杂度：O(N)，遍历输入数组。

- 空间复杂度：O(N)，存储 N/3 个元素的集合。

## 方法二：HashMap
遍历输入数组，统计每个数字出现的次数，最后返回出现次数为 1 的数字。


```java
class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> hashmap = new HashMap<>();
    for (int num : nums)
      hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);

    for (int k : hashmap.keySet())
      if (hashmap.get(k) == 1) return k;
    return -1;
  }
}
```

### 复杂度分析

- 时间复杂度：O(N)，遍历输入数组。

- 空间复杂度：O(N)，存储 N/3 个元素的 Set。

## 方法三：位运算符：NOT，AND 和 XOR
### 思路

使用[位运算符](https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/[https://wiki.python.org/moin/BitwiseOperators)可以实现 O(1) 的空间复杂度。

![](https://tva1.sinaimg.cn/large/00831rSTgy1gcmj7ha8epj30h806igm3.jpg)

### XOR

该运算符用于检测出现奇数次的位：1、3、5 等。

0 与任何数 XOR 结果为该数。

```
0⊕x=x
```

两个相同的数 XOR 结果为 0。

```
x⊕x=0
```

以此类推，只有某个位置的数字出现奇数次时，该位的掩码才不为 0。

![](https://tva1.sinaimg.cn/large/00831rSTgy1gcmj8r0pcnj31600pmdip.jpg)

因此，可以检测出出现一次的位和出现三次的位，但是要注意区分这两种情况。

### AND 和 NOT

为了区分出现一次的数字和出现三次的数字，使用两个位掩码：seen_once 和 seen_twice。

思路是：

- 仅当 seen_twice 未变时，改变 seen_once。

- 仅当 seen_once 未变时，改变 seen_twice。

![](https://tva1.sinaimg.cn/large/00831rSTgy1gcmj9qzmavj31b00q8q8f.jpg)

位掩码 seen_once 仅保留出现一次的数字，不保留出现三次的数字。

```java
class Solution {
  public int singleNumber(int[] nums) {
    int seenOnce = 0, seenTwice = 0;

    for (int num : nums) {
      // first appearence: 
      // add num to seen_once 
      // don't add to seen_twice because of presence in seen_once

      // second appearance: 
      // remove num from seen_once 
      // add num to seen_twice

      // third appearance: 
      // don't add to seen_once because of presence in seen_twice
      // remove num from seen_twice
      seenOnce = ~seenTwice & (seenOnce ^ num);
      seenTwice = ~seenOnce & (seenTwice ^ num);
    }

    return seenOnce;
  }
}
```

### 复杂度分析

- 时间复杂度：O(N)，遍历输入数组。

- 空间复杂度：O(1)，不使用额外空间。

