package Week_01;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int length = nums.length;

        tempMap.put(nums[0], 0);

        for (int i = 1; i < length; i++) {
            int temp = target - nums[i];

            if (tempMap.containsKey(temp)) {
                return new int[]{tempMap.get(temp), i};
            }

            tempMap.put(nums[i], i);

        }
        return null;

    }

}
