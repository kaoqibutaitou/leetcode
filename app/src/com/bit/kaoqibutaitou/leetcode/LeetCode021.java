package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.List;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.ListNode;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) return null;
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode sortList = null;
        if(l1.val>l2.val){
            sortList = l2;
            l2 = l2.next;
        }else{
            sortList = l1;
            l1 = l1.next;
        }
        ListNode node = sortList;
        while(null != l1 && null != l2){
            if(l1.val>l2.val){
                node.next = l2;
                l2 = l2.next;
            }else{
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if(null == l1) node.next = l2;
        if(null == l2) node.next = l1;
        return sortList;
    }


    public static void main(String [] args){
        LeetCode021 l = new LeetCode021();
        List list1 = List.generateSortedList(-10,10,5);
        list1.displayList();
        List list2 = List.generateSortedList(-1, 5, 10);
        list2.displayList();
        ListNode head = l.mergeTwoLists(list1.getHead(),list2.getHead());
        List.displayList(head);
    }
}
