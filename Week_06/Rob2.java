package Week_06;

public class Rob2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int ignoreFirst = nums[nums.length - 1];
        int ignoreLast = nums[0];
        if (length <= 2) {
            return Math.max(ignoreFirst, ignoreLast);
        }

        // 忽略第一个
        int resPre = nums[1];
        ignoreFirst = Math.max(resPre, nums[2]);
        for (int i = 3; i < length; i++) {
            int temp = ignoreFirst;
            ignoreFirst = Math.max(ignoreFirst, resPre + nums[i]);
            resPre = temp;
        }

        // 忽略最后一个
        resPre = nums[0];
        ignoreLast = Math.max(resPre, nums[1]);
        for (int i = 2; i < length - 1; i++) {
            int temp = ignoreLast;
            ignoreLast = Math.max(ignoreLast, resPre + nums[i]);
            resPre = temp;
        }

        return Math.max(ignoreFirst, ignoreLast);
    }
}
