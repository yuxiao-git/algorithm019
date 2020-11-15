package Week_02;

// 丑数
public class NthUglyNumber {
    // 暴力循环判断，从1开始，能够只除尽2/3/5的数据则计数+1直至达到n  ---超时
    public int nthUglyNumber(int n) {
        int cout = 1;
        int t = 1;
        while (cout < n) {
            int temp = ++t;
            while (temp > 1) {
                if (temp % 2 == 0) {
                    temp = temp / 2;
                } else if (temp % 3 == 0) {
                    temp = temp / 3;
                } else if (temp % 5 == 0) {
                    temp = temp / 5;
                } else {
                    temp = -1;
                }
            }
            if (temp == 1) {
                cout++;
            }
        }
        return t;
    }

    // 动态规划 关键词---丑数只能整除2/3/5,则第n个丑数整除2/3/5是第【1，n-1】中的丑数
    // 通过	2 ms	37.7 MB	Java
    public int nthUglyNumberOfPro(int n) {
        int[] temp = new int[n];
        temp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int temp2 = temp[p2] * 2, temp3 = temp[p3] * 3, temp5 = temp[p5] * 5;
            temp[i] = Math.min(Math.min(temp2, temp3), temp5);
            if (temp[i] == temp2) {
                p2++;
            }

            if (temp[i] == temp3) {
                p3++;
            }

            if (temp[i] == temp5) {
                p5++;
            }
        }
        return temp[n - 1];

    }

}
