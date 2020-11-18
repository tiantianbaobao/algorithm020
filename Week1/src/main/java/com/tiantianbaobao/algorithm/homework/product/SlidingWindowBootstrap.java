package com.tiantianbaobao.algorithm.homework.product;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
/***
 * @description sloping windows
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-17 22:25
 * @since V1.0.0
 */
public class SlidingWindowBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{};
        int k = 2;
        System.err.println("The biggest value of window is " + _calculateBiggestValueFromK(givenParams, k));
    }

    /**
     * calculate from given params{@param givenParams} in the scope of k{@param k}
     * <p>principle:we can use a {@link Stack} and a {@link java.util.Queue} to deal current question</p>
     * look this: {1, 2, 4, 6, 0, 1}, k = 2  -->{[1, 2], 4, 6, 0, 1}, --> {1, [2, 4], 6, 0, 1}
     * @param givenParams given params
     * @param k window scope
     * @return the biggest value
     */
    private static int[] _calculateBiggestValueFromK(int[] givenParams, int k) {

        return new int[]{};
    }
}
