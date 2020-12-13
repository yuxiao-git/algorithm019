package Week_06;

import java.util.List;

public class MinimumTotal {
    // 我擅长的动态规划 哈哈
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }*/

    // 我不擅长的递归，尝试老师讲解的方式再写出来
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotalRec(triangle, 0, 0);
    }

    private int minimumTotalRec(List<List<Integer>> triangle, int level, int index) {
        if (level == triangle.size() - 1) {// 到底层返回对应坐标值即可
            return triangle.get(level).get(index);
        }

        return Math.min(minimumTotalRec(triangle, level + 1, index), minimumTotalRec(triangle, level + 1, index + 1)) + triangle.get(level).get(index);
    }
}
