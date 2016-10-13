package com.bit.kaoqibutaitou.leetcode;

import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.Tree;
import com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yun on 2016/10/8.
 */
public class LeetCode107 {
    public void travelLevel(List<TreeNode> preLevelNodes, List<List<Integer>> r){
        if(null == preLevelNodes || preLevelNodes.size() <= 0) return;
        List<TreeNode> curLevelNodes = new ArrayList<>();
        List<Integer> curLevelValue = new ArrayList<>();
        for (TreeNode node:preLevelNodes) {
            if(null != node.left){
                curLevelNodes.add(node.left);
                curLevelValue.add(node.left.val);
            }
            if(null != node.right){
                curLevelNodes.add(node.right);
                curLevelValue.add(node.right.val);
            }
        }
        if(curLevelNodes.size()>0) {
            r.add(curLevelValue);
            travelLevel(curLevelNodes, r);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> level = new ArrayList<>(1);
        level.add(root.val);
        r.add(level);

        List<TreeNode> preLevelNodes = new ArrayList<>();
        preLevelNodes.add(root);

        travelLevel(preLevelNodes,r);

        return r;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> r = levelOrder(root);
        List<Integer> t = null;
        for (int i=0;i<(r.size()>>>1);++i){
            t = r.get(i);
            r.set(i,r.get(r.size()-1-i));
            r.set(r.size()-1-i,t);
        }
        return r;
    }

    public static void main(String [] args){
        LeetCode107 l = new LeetCode107();

        TreeNode root = Tree.buildBinaryTree(-1,2,3,3,4,-1,-1,4);
        System.out.println(l.levelOrderBottom(root));
    }
}
