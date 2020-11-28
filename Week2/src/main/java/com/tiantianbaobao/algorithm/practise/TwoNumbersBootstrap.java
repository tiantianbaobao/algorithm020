package com.tiantianbaobao.algorithm.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * @description get  two numbers from given array params, and the sum is target, and return the index
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-24 15:55
 * @since V1.0.0
 */
public class TwoNumbersBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{2, 7, 11, 16, 22, 35};
        int[] result = _searchAnswerByForLoop(333, givenParams);
        result = _searchAnswerSmart(29, givenParams);
        System.err.println("the index is " + Arrays.toString(result));
    }

    /***
     * complexity is O(N)
     * @param target target
     * @param givenParams given params array
     * @return index of element
     */
    private static int[] _searchAnswerSmart(int target, int[] givenParams) {
        if (givenParams.length < 2) {
            return new int[0];
        }
        //use has map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < givenParams.length; i++) {
            if (map.containsKey(target - givenParams[i])) {
                return new int[]{map.get(target - givenParams[i]), i};
            }
            map.put(givenParams[i], i);
        }
        return new int[0];
    }

    /***
     * search the index and return
     * @param target target
     * @param givenParams given params
     * @return index of element
     */
    private static int[] _searchAnswerByForLoop(int target, int[] givenParams) {
        if (givenParams.length < 2) {
            return new int[]{};
        }
        for (int i = 0; i < givenParams.length; i++) {
            for (int j = i + 1; j < givenParams.length; j++) {
                if (givenParams[i] + givenParams[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
