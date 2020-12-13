package Week_06;

// 打家劫舍（简单）
public class Rob {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        if (length == 1) {
            return nums[0];
        }

        int resPre = nums[0];
        int maxRes = Math.max(resPre, nums[1]);

        for (int i = 2; i < length; i++) {
            int temp = maxRes;
            maxRes = Math.max(maxRes, resPre + nums[i]);
            resPre = temp;
        }

        return maxRes;

    }
}
