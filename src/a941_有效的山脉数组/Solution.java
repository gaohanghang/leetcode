package a941_有效的山脉数组;

class Solution {
    // 0 2 3 4 5 2 1 0
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        //从左边往右边找，一直找到山峰为止
        while(left < len - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        //从右边往左边找，一直找到山峰为止
        while(right > 0 && arr[right - 1] > arr[right]) {
            right--;
        }
        //判断从左边和从右边找的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right;
    }
}
