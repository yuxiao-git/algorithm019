package Week_06;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();

        int l1 = s1.length + 1;
        int l2 = s2.length + 1;

        int[][] dp = new int[l1][l2];

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[l1 - 1][l2 - 1];

    }
}
