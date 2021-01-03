package Week_09;

import java.util.Stack;

// 最后一个单词的长度（苹果、谷歌、字节跳动在半年内面试中考过）
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        Stack<Character> stack=new Stack<>();
        if(s.length()<=0){
            return 0;
        }

        int i=0;
        while(s.charAt(i++)!=' '){
            stack.push(s.charAt(i));
        }

        return i==0?0:s.length()-i;
    }
}
