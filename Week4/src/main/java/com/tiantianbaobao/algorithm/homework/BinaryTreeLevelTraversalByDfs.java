package com.tiantianbaobao.algorithm.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-13 22:49
 * @since V1.0.0
 */
public class BinaryTreeLevelTraversalByDfs {
    public static void main(String[] args) {
        LinkedList<Integer> nums = new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null,null,8,null,7));
        LinkedList<Integer> nums1 = new LinkedList<>(Arrays.asList(3, 9, 20,15,null,null,7));
        TreeNode treeNode = _buildBinaryTree(nums1);
        System.err.println("level traversal is " + _levelTraversalByDfs(treeNode));
    }

    /***
     *
     * @param treeNode 当前树节点
     * @return {@param res}
     */
    private static List<List<Integer>> _levelTraversalByDfs(TreeNode treeNode) {
        List<List<Integer>> res = new ArrayList<>();
        _dfs(treeNode, 0, res);
        return res;
    }

    /***
     * principle：二维数组，第一维维护level关系，第二维维护具体的结果对象
     * @param treeNode
     * @param level
     * @param res
     */
    private static void _dfs(TreeNode treeNode, int level, List<List<Integer>> res) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(treeNode.value);
        if (treeNode.left != null) {
            _dfs(treeNode.left, level + 1, res);
        }
        if (treeNode.right != null) {
            _dfs(treeNode.right, level + 1, res);
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
