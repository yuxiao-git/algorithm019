# 学习笔记

#### 关于HashMap的总结
    1. HashMap:key/value(hash,next),由数组和链表组成
    2. 通常使用 put,set,put->putVal
    3. putVal
    (1) 存放相同即同一个node复制
       if (p.hash == hash &&
           ((k = p.key) == key || (key != null && key.equals(k))))
           e = p;
       }
    (2)hash解决冲突
        for (int binCount = 0; ; ++binCount) {
            if ((e = p.next) == null) {
                p.next = newNode(hash, key, value, null); // -- 冲突则在该key增加形成链表结构
                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                    treeifyBin(tab, hash);    // -- 链表转换为树结构，红黑树加快hashMap遍历（链表冲突）
                break;
            }
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k))))
                break;
            p = e;
        }

#### 关于习题【前 K 个高频元素】
    按照以往的开发传统，第一直觉就是暴力排序输出，很少去研究并比较算法之类的，更不用说多谢代码优化算法，有一个lambda表达式使用还是挺印象深刻的，虽然这是jdk
    新特性，但是工作中使用频率还是很高的，但是这里用来做大小根堆的用法倒是我需要去学习的。
