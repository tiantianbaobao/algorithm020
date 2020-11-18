package com.tiantianbaobao.algorithm.homework.rewrite;

import java.util.Arrays;

/***
 * @description move zero to lasted location of geven params
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-17 19:35
 * @since V1.0.0
 */
public class MovedZeroToLastedBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{0, 2, 4, 0, 5, 3, 0, 1, 5, 6, 19, 34, 56, 33, 55, 0, 4, 0, 5, 5, 33, 56};
        System.err.println(Arrays.toString(_moveZero(givenParams)));
        System.err.println(Arrays.toString(_moveZeroOther(givenParams)));
    }

    /**
     * move zero to the lasted locations,
     * @param givenParams
     * @return
     */
    private static int[] _moveZero(int[] givenParams) {
        int j = 0;
        long begin = System.nanoTime();
        for (int i = 0; i < givenParams.length; i++) {
            if (givenParams[i] != 0) {
                int temp = givenParams[i];
                givenParams[i] = givenParams[j];
                givenParams[j++] = temp;
            }

        }
        System.err.println("cast " + (System.nanoTime() - begin) + ".");
        return givenParams;
    }

    /***
     * use two for-loop
     * @param givenParams
     * @return result
     */
    private static int[] _moveZeroOther(int[] givenParams) {
        //{0, 2, 4, 0, 5, 3, 0, 1}
        int j = 0;
        for (int i = 0; i < givenParams.length; i++) {
           if (givenParams[i] != 0) {
               givenParams[j++] = givenParams[i];
           }
        }
        for (int i = j; i < givenParams.length; i++) {
            givenParams[i] = 0;
        }
        return givenParams;
    }
}
