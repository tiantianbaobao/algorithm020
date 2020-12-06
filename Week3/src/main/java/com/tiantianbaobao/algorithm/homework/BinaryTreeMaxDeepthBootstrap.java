package com.tiantianbaobao.algorithm.homework;

import java.util.Arrays;
import java.util.LinkedList;

/***
 * binary tree  traverse
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-28 11:31
 * @since V1.0.0
 */
public class BinaryTreeMaxDeepthBootstrap {
    public static void main(String[] args) {
        LinkedList<Integer> resources = new LinkedList<>(
                Arrays.asList(2,8,9,null,null,10,null,null,6,null,7));
        Node treeNode = createBinaryTree(resources);
        int maxDeepth = _calculateMaxDeepth(treeNode);
        int minDeep = _calculateMinDeepth(treeNode);
        System.err.println("maxDeepth :" + maxDeepth);
        System.err.println("minDeep : " + minDeep);
    }

    /***
     * 计算树的最小深度
     * @param treeNode
     * @return
     */
    private static int _calculateMinDeepth(Node treeNode) {
        if (treeNode == null) {
            return 0;
        }else {
            int left = _calculateMinDeepth(treeNode.leftChild);
            int right = _calculateMinDeepth(treeNode.rightChild);
            return Math.min(left, right) + 1;
        }
    }

    /***
     * 计算树的最大深度
     * @param treeNode
     * @return
     */
    private static int _calculateMaxDeepth(Node treeNode) {
        ///terminator
//        if (treeNode == null){
//            return 0;
//        }else {
//            int left = _calculateMaxDeepth(treeNode.leftChild);
//            int right = _calculateMaxDeepth(treeNode.rightChild);
//            return Math.max(left , right) + 1;
//        }
        //drill down
        //reverse
        if (treeNode == null) {
            return 0;
        } else {
            int leftHeight = _calculateMaxDeepth(treeNode.leftChild);
            int rightHeight = _calculateMaxDeepth(treeNode.rightChild);
            return Math.max(leftHeight, rightHeight) + 1;
        }

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
