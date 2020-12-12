package com.tiantianbaobao.algorithm.homework;

/***
 * @description nums of island
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-13 0:17
 * @since V1.0.0
 */
public class NumsOfIsland {
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        System.err.println("the nums of island is " + _numsOfIsland(nums));
    }

    /***
     * nums of island
     * principle : for loop, and check nums[i][j] == 1, then change nums[i][j] to 0
     * @param nums
     * @return
     */
    private static int _numsOfIsland(int[][] nums) {
        int count = 0;
        int x = nums.length;
        int y = nums[0].length;
        if (x == 0 || y == 0) {
            return 0;
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (nums[i][j] == 1){
                    ++count;
                    dfsMarkingZero(nums, i, j);
                }
            }
        }

        return count;
    }

    /***
     * marking 1 to 0
     * @param nums
     * @param i
     * @param j
     */
    private static void dfsMarkingZero(int[][] nums, int i, int j) {
        if (i < 0 || j < 0 || i >= nums.length || j >= nums[0].length || nums[i][j] != 1) {
            return;
        }
        //将某处的1的四周替换成0
        nums[i][j] = 0;
        dfsMarkingZero(nums, i + 1, j);
        dfsMarkingZero(nums, i - 1, j);
        dfsMarkingZero(nums, i, j + 1);
        dfsMarkingZero(nums, i, j - 1);
    }
}
