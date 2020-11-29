package Week_04;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);

        for (int bill : bills) {
            if (bill == 5) { // 5美元
                map.put(5, map.get(5) + 1);
            } else if (bill == 10) { // 10美元
                if (map.get(5) < 1) {
                    return false;
                }

                map.put(5, map.get(5) - 1);
                map.put(10, map.get(10) + 1);

            } else { // 20美元
                if (map.get(5) > 0 && map.get(10) > 0) {
                    // 只存在最大20，所以优先找出10，留下较多5更方便找零
                    map.put(20, map.get(20) + 1);
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);

                } else if (map.get(5) >= 3) {
                    map.put(20, map.get(20) + 1);
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }
            }

        }
        return true;

    }
}
