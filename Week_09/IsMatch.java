package Week_09;

// 正则表达式匹配（Facebook、微软、字节跳动在半年内面试中考过）
public class IsMatch {
    public boolean isMatch(String s, String p) {
        int sc = s.length();
        int pc = p.length();

        boolean[][] f = new boolean[sc + 1][pc + 1];
        f[0][0] = true;
        for (int i = 0; i <= sc; ++i) {
            for (int j = 1; j <= pc; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[sc][pc];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
