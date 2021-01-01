package com.tiantianbaobao.algorithm;

import java.util.*;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-20 21:11
 * @since V1.0.0
 */
public class Solution {
    public static void main(String[] args) {
        System.err.println(jump(new int[]{1,0,0,-1,2,-2}, 0));
    }
    public static List<Set<Integer>> jump(int[] nums, int target) {
        List<Set<Integer>> result = new ArrayList<>();
        for(int i = 0; i<nums.length;i++) {
            for(int j = 1;j<nums.length;j++){
                for(int k = 2;k<nums.length;k++) {
                    for(int s = 3; s<nums.length;s++) {
                        if(nums[i] + nums[j] + nums[k] + nums[s] == target) {
                            result.add(new HashSet<>(Arrays.asList(nums[i], nums[j], nums[k], nums[s])));
                        }
                    }
                }
            }
        }
        return result;
    }

    public static Node buildTree(ArrayList<Integer> nums, int level) {
        Node root = null;
        if(level >= nums.size()) {
            return null;
        }
        Integer value = nums.get(level);
        if(value != null){
            root = new Node(value);
            List<Node> children = new ArrayList<>();
            for(int i = 1; i <= value; i++) {
                children.add(buildTree(nums, level + i));
            }
            root.children = children;
        }
        return root;
    }
    public static class Node {
        private Integer value;
        private List<Node> children;
        public Node(Integer value) {
            this.value = value;
        }
    }
}
