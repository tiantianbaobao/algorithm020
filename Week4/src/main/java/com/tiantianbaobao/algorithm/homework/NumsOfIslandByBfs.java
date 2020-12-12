package com.tiantianbaobao.algorithm.homework;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-13 0:38
 * @since V1.0.0
 */
public class NumsOfIslandByBfs {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        System.err.println("the nums of island is " + _numsOfIslandByBfs(nums));
    }

    private static int _numsOfIslandByBfs(int[][] nums) {
        int count = 0;
        if (nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1) {
                    _bfs(nums, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    /***
     *
     * @param nums
     * @param i
     * @param j
     */
    private static void _bfs(int[][] nums, int i, int j) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i, j});
        while (!deque.isEmpty()) {
            int[] loc = deque.remove();
            i = loc[0];
            j = loc[1];
            if (0 <= i && i < nums.length && 0 <= j && j < nums[0].length && nums[i][j] == 1 ) {
                //置于0，并处理前后左右的顺序
                nums[i][j] = 0;
                deque.add(new int[]{i + 1, j});
                deque.add(new int[]{i - 1, j});
                deque.add(new int[]{i, j + 1});
                deque.add(new int[]{i, j - 1});
            }
        }
    }
}
