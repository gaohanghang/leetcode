https://leetcode.com/problems/top-k-frequent-words/solution/


java 自定义排序【Comparator升序降序的记法】


if(o1.compareTo(o2) < 0 ){
    return ?;
}

顺序其实主要是看-1，-1决定其是否要调整顺序：

这里o1表示位于前面的字符，o2表示后面的字符 

上面的条件是，o1比o2小，这个时候，我们需不需要调整它们的顺序：

```
如果你想升序，那么o1比o2小就是我想要的；所以返回-1，类比成false；表示我不想调整顺序
如果你想降序，那么o1比o2小不是我想要的；所以返回1，类比成true；表示我想调整顺序
```