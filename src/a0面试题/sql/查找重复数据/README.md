# SQL 重复记录查询

面试题<br />

<a name="4Hotf"></a>
## 问题描述

<br />有 student 表，查询 name 重复的记录，比如以下数据返回 a，因为出现了2次<br />


| id | name |
| --- | --- |
| 1 | a |
| 2 | b |
| 3 | a |
| 4 | c |



<a name="Vl42x"></a>
## 题解


```sql
SELECT name
FROM
	student
GROUP BY
	name
HAVING
	count(name) > 1;
```
**<br />**执行效果：**<br />**<br />![image.png](https://cdn.nlark.com/yuque/0/2020/png/576791/1602781484677-6e82176a-d3e9-4182-867d-cc7f4d6fc9b2.png#align=left&display=inline&height=837&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1674&originWidth=2222&size=615252&status=done&style=none&width=1111)<br />**数据的sql：**
```sql
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

INSERT INTO `test`.`student`(`id`, `name`) VALUES (1, 'a');
INSERT INTO `test`.`student`(`id`, `name`) VALUES (2, 'b');
INSERT INTO `test`.`student`(`id`, `name`) VALUES (3, 'a');
INSERT INTO `test`.`student`(`id`, `name`) VALUES (4, 'c');
```

<br />**【举一反三】**<br />**<br />本题也可以拓展为：找出重复出现 n 次的数据。只需要改变 having 语句中的条件即可：<br />

```sql
select 列名
from 表名
group by 列名
having count(列名) > n;
```


<a name="8Zh7j"></a>
## 参考

<br />[图解sql面试题：如何查找重复数据？](https://zhuanlan.zhihu.com/p/104764586)
