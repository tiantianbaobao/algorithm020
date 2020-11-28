package com.tiantianbaobao.algorithm.practise;

import java.util.*;

/***
 * @description three nums practise
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-24 10:28
 * @since V1.0.0
 */
public class ThreeNumsBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{-1, 0, -1, -1, 1, 2, -4};
//        List<List<Integer>> result = _theBadSolution(givenParams);
//        List<List<Integer>> result = _searchOptionsByHashMap(givenParams);
        List<List<Integer>> result = _searchAllOptions(givenParams);
        result.forEach(x -> System.err.println("one of option is " + Arrays.toString(x.toArray())));
    }

    /**
     * use a map and two for loop
     * @param nums given params
     * @return result
     */
    private static List<List<Integer>> _searchOptionsByHashMap(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        return result;
    }

    /***
     * the bad solution which O() is O(3^n), it's stupid
     * @param givenParams
     * @return
     */
    private static List<List<Integer>> _theBadSolution(int[] givenParams) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(givenParams);
        for (int i = 0; i <= givenParams.length - 1; i++) {
            for (int j = i + 1; j <= givenParams.length - 1; j++) {
                for (int k = j + 1; k <= givenParams.length - 1; k++) {
                    if (givenParams[i] + givenParams[j] + givenParams[k] == 0) {
                       result.add(Arrays.asList(givenParams[i], givenParams[j], givenParams[k]));
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /***
     * search all options which the sum of three random element from given params is zero
     * principle: a + b + c = 0 -> a + b = -c
     * @param givenParams given params
     * @return all options
     */
    private static List<List<Integer>> _searchAllOptions(int[] givenParams) {
        if (givenParams.length < 3) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(givenParams);
        for (int i = 0; i < givenParams.length - 2; i++) {
            if (givenParams[i] > 0) {
                break;
            }
            if (i > 0 && givenParams[i] == givenParams[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = givenParams.length - 1;
            while(j < k) {
                if (givenParams[i] + givenParams[j] + givenParams[k] < 0) {
                    while(j < k && givenParams[j] == givenParams[++j]);
                }else if(givenParams[i] + givenParams[j] + givenParams[k] > 0) {
                    while(j < k && givenParams[k] == givenParams[--k]);
                }else {
                    result.add(Arrays.asList(givenParams[i], givenParams[j], givenParams[k]));
                    while(j < k && givenParams[j] == givenParams[++j]);
                    while(j < k && givenParams[k] == givenParams[--k]);
                }
            }
        }
        return result;
    }
}