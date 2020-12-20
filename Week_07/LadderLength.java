package Week_07;

import java.util.*;

public class LadderLength {
    // 一：bfs写法
    public int ladderLengthOfBfs(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {// 终结边界条件
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        // 记录已经走的
        Map<String, Integer> visitedPath = new HashMap<>();
        visitedPath.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int count = visitedPath.get(word);

            for (int i = 0; i < word.length(); i++) {
                char[] words = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    words[i] = c;
                    String newWord = String.valueOf(words);

                    if (newWord.equals(endWord)) {
                        return count + 1;
                    } else if (wordSet.contains(newWord) && !visitedPath.containsKey(newWord)) {
                        queue.add(newWord);
                        visitedPath.put(newWord, count + 1);
                    }

                }
            }
        }

        return 0;
    }

    // 二：双向bfs写法
    public int ladderLengthOfBfs2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {// 终结边界条件
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        // 记录已经走的
        Set<String> visited = new HashSet<>();

        int step = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextVisited = new HashSet<>();

            for (String word : beginSet) {
                for (int i = 0; i < word.length(); i++) {
                    char[] words = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        words[i] = c;
                        String newWord = String.valueOf(words);

                        if (wordSet.contains(newWord)) {
                            if (endSet.contains(newWord)) {
                                return step + 1;
                            } else if (!visited.contains(newWord)) {
                                nextVisited.add(newWord);
                                visited.add(newWord);
                            }
                        }

                    }
                }
            }

            beginSet = nextVisited;
            step++;
        }
        return 0;

    }
}
