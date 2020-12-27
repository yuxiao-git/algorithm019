package Week_08;

public class FindCircleNum {
    int[] pre;

    public int findCircleNum(int[][] M) {
        int N = M.length;
        pre = new int[N];

        for (int i = 0; i < N; i++) {
            pre[i] = i;
        }

        int res = N;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1 && union(i, j)) {
                    res--;
                }
            }
        }
        return res;
    }

    public int find(int x) {
        int r = x;
        while (pre[r] != r) {
            r = pre[r];
        }

        int i = x, j;
        while (pre[i] != r) {
            j = pre[i];
            pre[i] = r;
            i = j;
        }
        return r;
    }

    public boolean union(int x, int y) {
        int posX = find(x);
        int posY = find(y);
        if (posX == posY) {
            return false;
        }
        pre[posX] = posY;
        return true;
    }
}
