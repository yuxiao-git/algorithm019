package Week_01;

public class RemoveDuplicates {

    // 有序数组,双指针可解
    public int removeDuplicatesForDoublePointer(int[] nums) {
        int pre = 0, append = 1;
        int length = nums.length;

        if (nums.length == 1) {
            return length;

        }

        while (append < length) {
            if (nums[pre] != nums[append]) {
                pre++;
                nums[pre] = nums[append];
            }
            append++;

        }

        return pre + 1;

    }
}
