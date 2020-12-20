package Week_07;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    int N;// 用于A*解法

    // 解法一：dp

    // 解法二：bfs
    public int solutionOfBfs(int[][] grid) {
        int n = grid.length;// N*N
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {// 终结条件
            return -1;
        }

        grid[0][0] = 1;// 将grid设为dp状态数组

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        int[][] direc = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};// 八个方向表示数组有利于简化代码
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            int posX = pos[0];
            int posY = pos[1];
            int len = grid[posX][posY];
            // 一一列举不如重新声明一个八个方向表示数组
            for (int i = 0; i < 8; i++) {
                int newPosX = posX + direc[i][0];
                int newPosY = posY + direc[i][1];
                if (newPosX < n && newPosX > -1 && newPosY < n && newPosY > -1 && grid[newPosX][newPosY] == 0) {
                    grid[newPosX][newPosY] = len + 1;
                    queue.add(new int[]{newPosX, newPosY});
                }
            }

        }

        return grid[n - 1][n - 1] == 0 ? -1 : grid[n - 1][n - 1];// 未抵达右下角则表示不可抵达
    }

    // 解法三：A*
    public int solutionOfA(int[][] grid) {
        N = grid.length;// N*N
        if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1) {// 终结条件
            return -1;
        }
        if (N == 1) {
            return 1;
        }

        int[][] direc = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};// 八个方向表示数组有利于简化代码

        Node start = new Node(0, 0, grid[0][0] = 1);
        Queue<Node> queue = new PriorityQueue<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int step = grid[node.posX][node.posY];
            for (int[] d : direc) {
                int newPosX = node.posX + d[0];
                int newPosY = node.posY + d[1];
                if (newPosX == N - 1 && newPosY == N - 1) {// 倒数第二步走完再走一步就算结束了
                    return step + 1;
                }
                if (newPosX < N && newPosX > -1 && newPosY < N && newPosY > -1 && (grid[newPosX][newPosY] == 0 || grid[newPosX][newPosY] > step + 1)) {
                    Node next = new Node(newPosX, newPosY, grid[newPosX][newPosY] = step + 1);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    class Node implements Comparable<Node> {
        int posX;
        int posY;
        int f;

        // 坐标posX，posY
        public Node(int posX, int posY, int step) {
            this.posX = posX;
            this.posY = posY;
            int distance = Math.max(N - 1 - posX, N - 1 - posY);
            this.f = distance + step;
        }

        // 重写 compareTo、equals和hashCode

        @Override
        public int compareTo(Node o) {
            return this.f - o.f;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return posX == node.posX && posY == node.posY;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(posX * N + posY);
        }
    }
}
