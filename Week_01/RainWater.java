package Week_01;


class RainWater {

    // 双指针法
    public int trapForDoublePointer(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int left_max = 0;
        int right_max = 0;

        int res = 0;

        while (left < right) {
            // 左指针矮与右指针
            if (height[left] < height[right]) {
                if (height[left] < left_max) {// 当前矮形成水滴存储区
                    res += left_max - height[left];
                } else {
                    left_max = height[left];
                }

                left++;

            } else {
                if (height[right] < right_max) {// 当前矮形成水滴存储区
                    res += right_max - height[right];
                } else {
                    right_max = height[right];
                }

                right--;

            }

        }

        return res;

    }

    // 左右扫描
    public int trapForLeftRightScan(int[] height) {
        int res=0;

        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
            int max_left = 0, max_right = 0;

            // 扫描左边
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }

            // 扫描右边
            for (int j = i; j <length;j++) {
                max_right = Math.max(max_right, height[j]);
            }

            res+=Math.min(max_left,max_right)-height[i];

        }

        return res;

    }
}

