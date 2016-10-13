package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.Tree;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode104 {
    public int depth(TreeNode node, int d){
        if(null == node) return d;
        if(null == node.left && null == node.right) return d+1;
        if(null == node.left && null != node.right) return depth(node.right, d+1);
        else if(null != node.left && null == node.right) return depth(node.left, d+1);
        else {
            int leftDepth = 0, rightDepth = 0;
            if (null != node.left) leftDepth = depth(node.left, d+1);
            if (null != node.right) rightDepth = depth(node.right, d+1);
            return leftDepth>rightDepth?leftDepth:rightDepth;
        }
    }

    public int maxDepth(TreeNode root) {
        if(null == root) return 0;

        return depth(root,0);
    }

    public static void main(String [] args){
        LeetCode104 l = new LeetCode104();

        TreeNode root = Tree.buildBinaryTree(-1,2,3,3,4,-1,-1,4);
        System.out.println(l.maxDepth(root));
    }
}
