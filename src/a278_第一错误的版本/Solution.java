package a278_第一错误的版本;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/03/12 18:07
 */
public class Solution {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left+(right-left) / 2; // 防止left + right溢出
            if (isBadVersion(mid)) {
                // 没用 mid - 1，是以为 mid - 1 可能不是 BadVersion，因此需要保留 mid
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean isBadVersion(int mid) {
        return false;
    }
}
