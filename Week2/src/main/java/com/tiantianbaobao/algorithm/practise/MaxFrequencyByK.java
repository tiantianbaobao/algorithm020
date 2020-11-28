package com.tiantianbaobao.algorithm.practise;

import java.util.ArrayList;
import java.util.List;

/***
 * @description calculate and return the max frequency top k 
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-26 15:46
 * @since V1.0.0
 */
public class MaxFrequencyByK {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,2,2,3,3};
        List<Integer> result = _topFrequencyElement(2, nums);
        System.err.println("the max frequency of nums is " + result);
    }

    /**
     * the frequency element
     * principle:use max binary heap, look at {@link java.util.PriorityQueue}
     * @param k
     * @param nums
     * @return
     */
    private static List<Integer> _topFrequencyElement(int k, int[] nums) {
        List<Integer> result = new ArrayList<>();

        return  result;
    }
}
