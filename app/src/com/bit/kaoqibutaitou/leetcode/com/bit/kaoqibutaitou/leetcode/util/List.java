package com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util;

/**
 * Created by Yun on 2016/10/8.
 */
public class List {
    private ListNode head;
    public ListNode getHead() {
        return head;
    }
    public boolean insertBefore(ListNode node){
        ListNode p = node;
        while(null != p.next) p = p.next;

        p.next = head;
        head = node;
        return true;
    }
    public boolean insertAfter(ListNode node){
        if(null == head){
            head = node;
        }else{
            ListNode p = node;
            while (null != p.next) p = p.next;

            node.next = head.next;
            head.next = node;
        }
        return true;
    }
    public boolean insertLast(ListNode node){
        if(null == head){
            head = node;
        }else {
            ListNode p = head;
            while (null != p.next) p = p.next;
            p.next = node;
        }
        return true;
    }
    public static List generateRandomList(int n, int min, int max){
        List list = new List();
        if(min>max) {
            int t = max;
            max = min;
            min = t;
        }
        for (int i=0;i<n;++i){
            int v = (int)(Math.random()*(max-min))+min;
            ListNode node = new ListNode(v);
            list.insertAfter(node);
        }
        return list;
    }
    public static List generateSortedList(int start, int stepSize, int n){
        List list = new List();
        ListNode node = new ListNode(start);
        list.insertLast(node);
        for (int i=1;i<n;++i){
            int step = (int)(Math.random()*n);
            start += (step*stepSize);
//            System.out.println(start);
            node = new ListNode(start);
            list.insertLast(node);
        }
        return list;
    }
    public static void displayList(ListNode headNode){
        if(null == headNode) return;
        ListNode node = headNode;
        int i;
        for(i = 1;null != node.next; ++i, node = node.next){
            System.out.print("<#"+": "+node.val+">--");
        }
        System.out.print("<#"+": "+node.val+">\n");
    }
    public static void displayList(List list) {
        if(null == list) return;
        displayList(list.getHead());
    }
    public void displayList(){
        displayList(this);
    }
}
