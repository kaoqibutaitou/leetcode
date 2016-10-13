package com.bit.kaoqibutaitou.leetcode.com.bit.kaoqibutaitou.leetcode.util;

/**
 * Created by Yun on 2016/10/11.
 */
public class Tree {
    public static void buildBinaryTreeNode(int parent, TreeNode root, int specialNode, int ... nodes){
        int leftIndex = (parent<<1)+1;
        if(leftIndex < nodes.length){
            if(nodes[leftIndex] == specialNode) {
                root.left = null;
            }else {
                TreeNode leftNode = new TreeNode(nodes[leftIndex]);
                root.left = leftNode;
                buildBinaryTreeNode(leftIndex, leftNode,specialNode, nodes);
            }
        }
        int rightIndex = (parent<<1)+2;
        if(rightIndex < nodes.length){
            if(nodes[rightIndex] == specialNode){
                root.right = null;
            }else {
                TreeNode rightNode = new TreeNode(nodes[rightIndex]);
                root.right = rightNode;
                buildBinaryTreeNode(rightIndex, rightNode, specialNode, nodes);
            }
        }
    }

    public static TreeNode buildBinaryTree(int specialNode,int ... nodes){
        if(null == nodes) return null;
        TreeNode root = new TreeNode(nodes[0]);
        buildBinaryTreeNode(0,root,specialNode,nodes);
        return root;
    }
}
