package com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.test;

import java.util.Scanner;

/**
 * Created by Yun on 2016/10/13.
 */
public class Huawei02 {
    public static int num[] = {81,27,9,3,1};
    public static void cal(char [] operators, int index, int n) {
        if (0 == n) {
            int i = 0;
            while(operators[i] == '0') ++i;
            System.out.print(num[i]);
            for (++i; i < index; ++i) {
                if ('0' != operators[i]) {
                    System.out.print(operators[i]);
                    System.out.print(num[i]);
                }
            }
            System.out.println();
            return;
        } else if(index >= operators.length) return;

        operators[index] = '-';
        cal(operators,index+1,n+num[index]);

        operators[index] = '0';
        cal(operators,index+1,n);

        operators[index] = '+';
        cal(operators,index+1,n-num[index]);
    }
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        char operators[] = new char[num.length];
        for (int i=0;i<operators.length;++i) operators[i] = '0';
        while(in.hasNext()){
            int n = in.nextInt();
            cal(operators,0,n);
        }
    }
}
