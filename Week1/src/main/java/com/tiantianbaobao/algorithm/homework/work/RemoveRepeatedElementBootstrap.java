package com.tiantianbaobao.algorithm.homework.work;

import java.util.*;

/***
 * @description remove repeated from given params
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-11-18 22:44
 * @since V1.0.0
 */
public class RemoveRepeatedElementBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{0,0,1,2,3,3,4,5,5,6,7,8,8,9};
        System.err.println("Remove repeated elements array length is : " + _removeRepeatedElements(givenParams));
    }

    /***
     * remove repeated elements from ordered {@param givenParams}
     * @param givenParams target
     * @return no-repeated array
     */
    private static int _removeRepeatedElements(int[] givenParams) {
        if (givenParams == null || givenParams.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < givenParams.length; i++) {
            if (givenParams[i] != givenParams[j]){
                if (i -j > 1) {
                    givenParams[j + 1] = givenParams[i];
                    j++;
                }
            }
        }
        return j + 1;
    }
}
