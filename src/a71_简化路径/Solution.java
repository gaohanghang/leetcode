package a71_简化路径;

import java.util.Stack;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-09-02 23:47
 **/
public class Solution {

    public String simplifyPath(String path) {
        // 1. 定义一个栈
        Stack<String> stack = new Stack<>();
        // 2. 将路径按 / 分割为字符串数组
        String[] dirs = path.split("/");
        // 3. 遍历字符串数组
        for (String dir : dirs) {
            if (dir.equals("..")) {
                // 4. 如果栈不为空遇到 .. 弹出栈顶元素
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (dir.length() > 0 && !dir.equals(".")){
                // 5. 如果目录长度大于0而且不等于 . 就放入栈中
                // 目录长度大于0是为了将多个斜杠变为一个
                // 不等于 . 是因为一个点（.）表示当前目录本身，不用放入
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack);
    }

}
