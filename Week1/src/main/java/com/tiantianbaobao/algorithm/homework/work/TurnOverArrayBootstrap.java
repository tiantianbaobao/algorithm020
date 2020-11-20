package com.tiantianbaobao.algorithm.homework.work;

import java.util.Arrays;
import java.util.Stack;

/***
 * @description turn over array by k step
 * @author <h>cuitao@aixuexi.com</h>
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

        return params;
    }
}
