package Week_02;

import java.util.*;

// 前K个高频元素
public class TopKFrequent {
    public static int[] topKFrequentOfPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        // 存储每个元素个数
        for (int num : nums) {
            if (tempMap.containsKey(num)) {
                tempMap.put(num, tempMap.get(num) + 1);
            } else {
                tempMap.put(num, 1);
            }
        }

        // 使用指定容器创建大顶堆并对内部元素自然排序（此处重写compare大->小）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> tempMap.get(o1) - tempMap.get(o2));
        for (Integer key : tempMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (tempMap.get(priorityQueue.peek()) < tempMap.get(key)) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }

        }

        // 输出队列数据
        int[] res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()) {
            res[i++] = priorityQueue.remove();
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequentOfPriorityQueue(nums, k);
        System.out.println("res = " + Arrays.toString(res));
    }

}
