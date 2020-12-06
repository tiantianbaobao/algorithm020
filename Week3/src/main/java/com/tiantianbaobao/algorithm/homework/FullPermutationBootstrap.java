package com.tiantianbaobao.algorithm.homework;

import java.util.*;

/***
 * @description given int[] params and return all permutations
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-06 22:46
 * @since V1.0.0
 */
public class FullPermutationBootstrap {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.err.println(_fullPermutations(nums));
    }

    /***
     * [1, 2, 3] ->[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]
     * @param nums
     * @return
     */
    private static List<List<Integer>> _fullPermutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(len, nums, 0, path, used, res);
        return res;
    }

    private static void dfs(int len, int[] nums, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        //terminator
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(len, nums,depth + 1, path, used, res );
            path.removeLast();
            used[i] = false;
        }
    }
}
