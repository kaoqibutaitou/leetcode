package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.List;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.ListNode;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode020 {
    public boolean isValid(String s) {
        boolean valid = true;
        int stackIndex = -1;
        int stackSize = s.length()<<1;
        char [] stack = new char[stackSize];
        for (int i=0;valid && stackIndex < stackSize && i<s.length();++i){
            char c = s.charAt(i);
            switch (c){
                case '(':
                case '[':
                case '{': {
                    stack[++stackIndex] = c;
                } break;
                case ')': {
                    if(stackIndex>=0 && '(' == stack[stackIndex]) {
                        --stackIndex;
                    }else valid = false;
                } break;
                case ']': {
                    if(stackIndex>=0 && '[' == stack[stackIndex]) {
                        --stackIndex;
                    }else valid = false;
                } break;
                case '}': {
                    if(stackIndex>=0 && '{' == stack[stackIndex]) {
                        --stackIndex;
                    }else valid = false;
                } break;
            }
        }
        return valid && stackIndex == -1;
    }

    public static void main(String [] args){
        LeetCode020 l = new LeetCode020();

        System.out.println(l.isValid("]"));
    }
}
