https://www.nowcoder.com/discuss/582308





作者：钟期既遇
链接：https://www.nowcoder.com/discuss/582308
来源：牛客网



1. String 类型的变量一般存在哪里？这里引出了常量池，然后开始了夺命四连问。 

- 如果我定义了一个 String 类型的私有成员 a1，我给他赋了一个初始值，比如说 "abc"，然后我在另一个类里面，也有一个值为 "abc" 的成员变量 a2，如果比较 a1 == a2，它会相等吗？ 
- 如果我在一个方法里面定义了一个局部变量 a3，如果比较 a3 == a1，你觉得会相等吗？ 
- 如果 a4 = new String("abc")，你觉得这个 a4 会和 a3 相等吗？ 
- 那如果变量没有 final 修饰，就是 public static String a5，我在构造函数里面给 a5 赋值为 "abc"，你觉得它会和 a1 相等吗？