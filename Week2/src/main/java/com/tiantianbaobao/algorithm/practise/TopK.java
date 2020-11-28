package com.tiantianbaobao.algorithm.practise;

import java.util.*;

/***
 * @description topK
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-26 15:23
 * @since V1.0.0
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = new int[]{8,9};
        List<Integer> topK = _topK(nums, 3);
        System.err.println("the top k of nums is " + topK);
    }

    /***
     * we can use binary heap, look at {@link java.util.PriorityQueue}
     * @param nums given params
     * @param k top k
     * @return
     */
    private static List<Integer> _topK(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        //default is min heap, and 11 is the default capacity
//        PriorityQueue minHeap = new PriorityQueue<Integer>(11);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(11, (x, y) -> y - x);
        for (int i = 0; i < nums.length; i++) {
            priorityQueue.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }
}
