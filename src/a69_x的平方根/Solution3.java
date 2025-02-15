package a69_x的平方根;

class Solution3 {
    public int mySqrt(int x) {
        for (int i = 1; i <= x; i++) {
            if (i*i > x) {
                return i -1;
            } else if(i*i == x){
                return i;
            }
        }
        return 0;
    }
}
