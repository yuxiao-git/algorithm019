package Week_08;

import java.util.HashMap;
import java.util.Map;

// 排序
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        // 适应如果输入字符串包含 unicode 字符
        Map<Character, Integer> str1 = new HashMap();
        Map<Character, Integer> str2 = new HashMap();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (str1.get(s.charAt(i)) == null) {
                str1.put(s.charAt(i), 1);
            } else {
                str1.put(s.charAt(i), str1.get(s.charAt(i)) + 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            if (str2.get(t.charAt(j)) == null) {
                str2.put(t.charAt(j), 1);
            } else {
                str2.put(t.charAt(j), str2.get(t.charAt(j)) + 1);
            }
        }

        boolean res = true;
        for (int k = 0; k < s.length(); k++) {
            if (!(str1.get(s.charAt(k)) != null && str2.get(s.charAt(k)) != null
                    && str1.get(s.charAt(k)).equals(str2.get(s.charAt(k))))) {
                res = false;
            }
        }
        return res;
    }
}
