package a1047_删除字符串中的所有相邻重复项;

class Solution {

    // abbaca

    // a
    // ab
    // a
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for(int i = 0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(top >=0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(ch);
                top++;
            }
        }

        return stack.toString();
    }
}
