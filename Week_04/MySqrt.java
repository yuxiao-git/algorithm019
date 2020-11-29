package Week_04;

public class MySqrt {
    public int mySqrt(int x) {
        // 二分搜索
        int l = 0, r = x, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
