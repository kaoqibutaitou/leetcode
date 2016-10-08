package com.bit.kaoqibutaitou.leetcode;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode014 {
    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length <= 0) return "";

        int minLength = strs[0].length();
        for (int i=1;i<strs.length;++i){
            if(minLength>strs[i].length()){
                minLength = strs[i].length();
            }
        }

        int i = 0,j = 0;
        for (i=0;i<minLength;++i){
            char c = strs[0].charAt(i);
            for (j=1;j<strs.length;++j){
                if(strs[j].charAt(i) != c){
                    break;
                }
            }
            if(j<strs.length) break;
        }

        return strs[0].substring(0,i);
    }
    public static void main(String [] args){
        LeetCode014 l = new LeetCode014();
        String str = l.longestCommonPrefix(new String[]{
            "abc", "ab","abbb"
        });
        System.out.println(str);
    }
}
