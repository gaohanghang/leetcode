# 递归方法

![](https://ws2.sinaimg.cn/large/006tNc79ly1g1xzjmtafgj307k01z3yj.jpg)

程序刚开始执行，if 语句失效，进入 else 语句，然后执行Node newhead = reverseList(head.next);第二个结点的指针参数传入递归函数，一直到，最后一个结点的指针参数传入递归函数，if 语句有效head->next == NULL，返回当前的head 给 newhead 指针指向，如图：

![](https://ws1.sinaimg.cn/large/006tNc79ly1g1xzkgh839j307y02ajrg.jpg)

其实在递归函数栈内，按照后进先出的顺序，执行一级级的递归函数，返回末位结点给 newhead 之后，执行递归栈里的第二个递归函数，发生如图

![](https://ws1.sinaimg.cn/large/006tNc79ly1g1xzm7h144j307502qjrh.jpg)

返回 newhead，也就是新的反转之后的链表（临时的），然后进入到递归工作栈里的第一个递归函数，如图：

![](https://ws3.sinaimg.cn/large/006tNc79ly1g1xzmpabgjj306z02i74d.jpg)

返回 newhead，也就是反转之后的链表，此时递归工作栈的函数全部执行，返回的结点就是反转之后的链表的头结点（之前的尾结点）

