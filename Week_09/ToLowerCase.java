package Week_09;

// 转换成小写字母（谷歌在半年内面试中考过）
public class ToLowerCase {
    public String toLowerCase(String str) {
        char[] c = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (c[i] <= 'Z' && c[i] >= 'A') {
                c[i] += 32;
            }
        }
        return String.valueOf(c);
    }
}
