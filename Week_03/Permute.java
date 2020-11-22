package Week_03;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] flags = new int[nums.length];

        getAll(res, nums, flags, new ArrayList<>());
        return res;

    }

    public void getAll(List<List<Integer>> res, int[] nums, int[] flags, ArrayList<Integer> onePermute) {
        if (onePermute.size() == nums.length) {
            res.add(new ArrayList<>(onePermute));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flags[i] != 0) {
                continue;
            } else {
                onePermute.add(nums[i]);
                flags[i] = 1;

                getAll(res, nums, flags, onePermute);

                onePermute.remove(onePermute.size() - 1);
                flags[i] = 0;

            }
        }
    }
}
