package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.List;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.ListNode;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode024 {
    public ListNode swapPairs(ListNode head) {
        if(null == head || null == head.next) return head;
        ListNode p = head, preNode = head, tt = null;
        head = null == p.next?p:p.next;
        while (null != p && null != p.next){
            tt = p.next.next;

            preNode.next = p.next;
            preNode = p;

            p = p.next;
            p.next = preNode;

            p = tt;
        }
        if(null != p && null == p.next) preNode.next = p;
        else preNode.next = tt;
        return head;
    }

    public static void main(String [] args){
        LeetCode024 l = new LeetCode024();
//        List list1 = List.generateSortedList(-10,10,5);
//        list1.displayList();
        List list1 = new List();
        list1.insertLast(new ListNode(1));
        list1.insertLast(new ListNode(2));
        list1.displayList();

        ListNode head = l.swapPairs(list1.getHead());
        List.displayList(head);
    }
}
