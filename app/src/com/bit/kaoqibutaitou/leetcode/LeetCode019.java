package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.List;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.ListNode;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n <= 0) return head;
        ListNode node = head;
        ListNode preDeleteNode = head;
        int index = 1, i;
        for (i=1; null != node.next; ++i, node = node.next){
            if(i>n){
                preDeleteNode = preDeleteNode.next;
            }
        }
        if(n > i) return head;
        else if(n == i) return head.next;

        if(null == preDeleteNode.next) preDeleteNode.next = null;
        else preDeleteNode.next = preDeleteNode.next.next;
        return head;
    }

    public static void main(String [] args){
        LeetCode019 l = new LeetCode019();

        List list = List.generateRandomList(5,-5,5);
        list.displayList();

        ListNode node = l.removeNthFromEnd(list.getHead(),5);
        List.displayList(node);
    }
}
