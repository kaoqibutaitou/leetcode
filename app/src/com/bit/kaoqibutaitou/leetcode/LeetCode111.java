package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.Tree;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode111 {
    public int depth(TreeNode node, int minDepth, int level){
        if(null == node) return level;
        if(level < minDepth){
            if(null == node.left || null == node.right) {
                if (level + 1 < minDepth) minDepth = level + 1;
                return level + 1;
            }else{
                int leftLevel = depth(node.left,minDepth,level+1);
                int rightLevel = depth(node.right,minDepth,level+1);
                minDepth = leftLevel>rightLevel?rightLevel:leftLevel;
                return minDepth;
            }
        }
        return minDepth;
    }

    public int minDepth(TreeNode root) {
        if(null == root) return 0;
        if(null == root.left && null == root.right) return 1;

        int minDepth = Integer.MAX_VALUE;
        minDepth = depth(root,minDepth,0);
        return minDepth+1;
    }

    public static void main(String [] args){
        LeetCode111 l = new LeetCode111();

        TreeNode root = Tree.buildBinaryTree(-1,1,-1,1);
        System.out.println(l.minDepth(root));
    }
}
