package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.Tree;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode101_0 {
    public boolean isSymmetric(TreeNode root) {
        if(null == root) return true;
        Queue<TreeNode> leftQueue = new LinkedList<>(), rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        boolean r = true;
        while(r && !leftQueue.isEmpty() && !leftQueue.isEmpty()){
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.poll();

            if(null == left && null == right) continue;
            if(null == left || null == right || (left.val != right.val)) {
                r = false;
                break;
            }
            if(null != left.left && null != right.right){
                leftQueue.offer(left.left);
                rightQueue.offer(right.right);
            } else if((null == left.left || null == right.right) && left.left != right.right){
                r = false;
                break;
            }
            if(null != left.right && null != right.left){
                leftQueue.offer(left.right);
                rightQueue.offer(right.left);
            } else if((null == left.right || null == right.left) && left.right != right.left){
                r = false;
                break;
            }
        }
        return r;
    }

    public static void main(String [] args){
        LeetCode101_0 l = new LeetCode101_0();

        TreeNode root = Tree.buildBinaryTree(-1,2,3,3,4,5,5,4);
        System.out.println(l.isSymmetric(root));
    }
}
