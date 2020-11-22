package com.tiantianbaobao.algorithm.homework.work;

import java.util.Arrays;

/***
 * @description turn over array by k step
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-18 23:07
 * @since V1.0.0
 */
public class TurnOverArrayBootstrap {
    public static void main(String[] args) {
        int[] params = new int[]{1,2,3,4,5,6, 7};
        int k = 3;
        System.err.println("The result of after turn over is " + Arrays.toString(_turnOverArrayByK(params, k)));
    }

    /***
     * turn over array, and the kong jian O() must is O(1)
     * @param params needed turn over array param
     * @param k interval of turn over
     * @return after result
     */
    private static int[] _turnOverArrayByK(int[] params, int k) {
            k %= params.length;
            reverse(params, 0, params.length - 1);
            reverse(params, 0, k - 1);
            reverse(params, k, params.length - 1);
            return params;
    }

    /***
     *
     * @param params
     * @param start
     * @param end
     */
    public static void reverse(int[] params, int start, int end) {
        while (start < end) {
            int temp = params[start];
            params[start] = params[end];
            params[end] = temp;
            start++;
            end--;
        }
    }
}
