package com.tiantianbaobao.algorithm.homework;

import java.util.Arrays;
import java.util.LinkedList;

/***
 * binary tree  traverse
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-28 11:31
 * @since V1.0.0
 */
public class BinaryTreeBootstrap {
    public static void main(String[] args) {
        LinkedList<Integer> resources = new LinkedList<>(
                Arrays.asList(2,8,9,null,null,10,null,null,6,null,7));
        Node treeNode = createBinaryTree(resources);
        System.err.println("前序遍历：");
        preTraverse(treeNode);
        System.err.println("中序遍历：");
        middleTraverse(treeNode);
        System.err.println("后序遍历：");
        postTraverse(treeNode);
    }

    /***
     * 前序遍历
     * @param node
     */
    public static void preTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.err.println(node.value);
        preTraverse(node.leftChild);
        preTraverse(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postTraverse(Node node) {
        if (node == null) {
            return;
        }
        postTraverse(node.leftChild);
        postTraverse(node.rightChild);
        System.err.println(node.value);
    }

    /***
     * 中序遍历
     * @param node
     */
    public static void middleTraverse(Node node) {
        if (node == null) {
            return;
        }
        middleTraverse(node.leftChild);
        System.err.println(node.value);
        middleTraverse(node.rightChild);
    }

    public static Node createBinaryTree(LinkedList<Integer> resources) {
        Node node = null;
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        Integer value = resources.removeFirst();
        if (value != null) {
            node = new Node(value);
            node.leftChild = createBinaryTree(resources);
            node.rightChild = createBinaryTree(resources);
        }
        return node;
    }

    private static class Node{
        private Node leftChild;
        private Node rightChild;
        private Integer value;
        public Node(Integer value) {
            this.value = value;
        }
    }
}
