package com.tiantianbaobao.algorithm.practise;

/***
 * @description calculate the most container of water from given choices
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-11-16 10:25
 * @since V1.0.0
 */
public class CalculateMostContainerOfWaterBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{1,8,6,2,5,4,8,3,7};
        System.err.println("the most container of water when use two layers for-loop is : " + _defaultCalculate(givenParams));
        System.err.println("the most container of water when use once while-loop and use squeeze is : " + _bestCalculate(givenParams));
    }

    /**
     * default of calculate the most container, it's not smart, but it's easy to understand the principle
     * <p>base principle: use two layers of for-loop</p>
     * @param givenParams given params
     * @return the most area of container
     */
    private static int _defaultCalculate(int[] givenParams) {
        if (givenParams == null || givenParams.length < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < givenParams.length; i++) {
            for (int j = i + 1; j < givenParams.length; j++) {
                //Math.min(givenParams[i], givenParams[j]) is important~
                max = Math.max(Math.min(givenParams[i], givenParams[j]) * (j - i), max);
            }
        }
        return max;
    }

    /**
     * the best way to calculate container area, which use only once while-loop, and the time-min-O(x).
     * <p>base principle:use squeeze method to operate two pointer</p>
     * @param givenParams given params
     * @return the most area of container
     */
    private static int _bestCalculate(int[] givenParams) {
        if (givenParams == null || givenParams.length < 2) {
            return 0;
        }
        int max= 0, i = 0, j = givenParams.length - 1;
        while (i < j) {
            //area = min(h(i), h(j)) * (j - i)
            max = Math.max(max, Math.min(givenParams[i], givenParams[j]) * (j - i));
            //短板移动，以获取最大值
            if(givenParams[i] < givenParams[j]) {
                i++;
            }else {
                j--;
            }
        }
        return max;
    }
}
