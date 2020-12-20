package Week_07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 双向BFS代码模板（尝试）
public class TwoDirecBfs {
    public List<List<Integer>> levelOrder(String begin, String end, List<String> list) {
        List<List<Integer>> res = new ArrayList<>();

        Set<String> beginSet = new HashSet<>();
        beginSet.add(begin);
        Set<String> endSet = new HashSet<>();
        endSet.add(end);

        // 记录访问过
        Set<String> visitedSet = new HashSet<>();

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {// 因为是双端所以俩个都判空
            // 优先较短端遍历
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            //...... 对beginSet操作
            // 当俩端相遇则为终止返回
            //...... 否则对beginSet重新赋值,若未访问则add to visitedSet,res  add
        }

        return res;
    }
}



