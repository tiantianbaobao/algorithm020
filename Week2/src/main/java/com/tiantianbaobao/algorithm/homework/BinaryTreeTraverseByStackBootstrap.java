package com.tiantianbaobao.algorithm.homework;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author tiantianbaobao
 * @version V1.0.0
 * @ClassName BinaryTreeTraverseByStackBootstrap
 * @description <p>TODO</p>
 * @date 2020/11/30 22:34
 * @since V1.0.0
 **/
public class BinaryTreeTraverseByStackBootstrap {
    public static void main(String[] args) {
        LinkedList<Integer> resources = new LinkedList<>(
                Arrays.asList(2,8,9,null,null,10,null,null,6, null,7));
        TreeNode treeNode = createBinaryTree(resources);
        System.err.println("前序遍历by-Stack:");
        preTraverseByStack(treeNode);
        System.err.println("中序遍历by-Stack:");
        middleTraverseByStack(treeNode);
        System.err.println("后序遍历by-Stack:");
        postTraverseByStack(treeNode);
    }

    /**
     * use {@link java.util.Stack} to traverse tree-node with pre-way
     * @param root
     */
    public static void preTraverseByStack(TreeNode root) {
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while(treeNode != null || !stack.isEmpty()) {
            while(treeNode != null) {
                System.err.println(treeNode.value);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /***
     * traverse tree-node by {@link java.util.Stack} and with post-way
     * @param root
     */
    public static void postTraverseByStack(TreeNode root) {
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        while(treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                stack1.push(1);
                treeNode = treeNode.leftChild;
            }
            while(!stack.isEmpty() && stack1.peek() == 2) {
                stack1.pop();
                System.err.println(stack.pop().value);
            }
            if (!stack.isEmpty() && stack1.peek() == 1) {
                stack1.pop();
                stack1.push(2);
                treeNode = stack.peek().rightChild;
            }
        }
    }

    /***
     * traverse tree-node by {@link java.util.Stack} by middle-way
     * @param root
     */
    public static void middleTraverseByStack(TreeNode root) {
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || treeNode != null) {
            while(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()) {
                treeNode = stack.pop();
                System.err.println(treeNode.value);
                treeNode = treeNode.rightChild;
            }
        }
    }
    /***
     * create tree by {@link LinkedList}
     * @param resources
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> resources) {
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        TreeNode treeNode = null;
        Integer value = resources.removeFirst();
        if (value != null) {
            treeNode = new TreeNode(value);
            treeNode.leftChild = createBinaryTree(resources);
            treeNode.rightChild = createBinaryTree(resources);
        }
        return treeNode;
    }
    private static class TreeNode {
        private TreeNode leftChild;
        private TreeNode rightChild;
        private Integer value;
        public TreeNode(Integer value) {
            this.value = value;
        }
    }
}
