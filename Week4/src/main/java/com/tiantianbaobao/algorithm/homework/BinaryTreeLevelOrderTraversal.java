package com.tiantianbaobao.algorithm.homework;

import java.time.temporal.ChronoUnit;
import java.util.*;

/***
 * @description binary-tree-level-order-traversal
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-13 21:35
 * @since V1.0.0
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        LinkedList<Integer>nums = new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null,null,8,null,7));
        TreeNode treeNode = _buildBinaryTree(nums);
        System.err.println("binary-tree-level-order-traversal is : " + _levelOrderTraversal(treeNode));
    }

    private static List<List<Integer>> _levelOrderTraversal(TreeNode treeNode) {
        List<List<Integer>> res = new ArrayList<>();
        _bfs(treeNode, res);
        return res;
    }

    private static void _bfs(TreeNode treeNode, List<List<Integer>> res) {
        if (treeNode == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(treeNode);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.remove();
                currentLevel.add(node.value);
                if(node.left != null){
                    deque.add(node.left);
                }
                if(node.right!=null){
                    deque.add(node.right);
                }
            }
            res.add(currentLevel);
        }
    }

    private static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }

    private static TreeNode _buildBinaryTree(LinkedList<Integer> nums) {
        TreeNode node = null;
        if (nums == null || nums.size() == 0) {
            return null;
        }
        Integer value = nums.removeFirst();
        if (value != null){
            node = new TreeNode(value);
            node.left = _buildBinaryTree(nums);
            node.right = _buildBinaryTree(nums);
        }
        return node;
    }
}
