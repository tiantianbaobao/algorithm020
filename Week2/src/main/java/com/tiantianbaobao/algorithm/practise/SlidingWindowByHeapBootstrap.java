package com.tiantianbaobao.algorithm.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/***
 * @description calculate sliding window in k and return 
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-26 15:08
 * @since V1.0.0
 */
public class SlidingWindowByHeapBootstrap {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        List<Integer> result = _slidingWithK(3, nums);
        result.forEach(s -> System.err.println("the max of current sliding windows is " + s));
    }

    /***
     * calculate the max value by heap. look at {@link java.util.PriorityQueue}
     * @param k
     * @param nums
     * @return
     */
    private static List<Integer> _slidingWithK(int k, int[] nums) {
        if (nums.length < k) {
            return new ArrayList<>(0);
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(11, (x, y) -> y - x);
        PriorityQueue<Integer> min = new PriorityQueue<>(11);
        for (int i = 0; i < nums.length; i++) {

        }
        return result;
    }
}
