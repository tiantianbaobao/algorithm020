package com.tiantianbaobao.algorithm.homework.compare;


import java.util.Stack;

/***
 * @description calculate the most area can be created by given params bootstrap
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-17 19:31
 * @since V1.0.0
 */
public class MostAreaBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{3,6,8,9,3};
        System.err.println("The most area can be created by given params is " + _calculateMostAreaCanBeCreated(givenParams));
    }

    /***
     * calculate the most area can be created by given params{@param givenParams}
     * <p>We can use {@link java.util.Stack} to help the processing of calculate</p>
     * 单调递增的栈
     * @param givenParams
     * @return the most area
     */
    private static int _calculateMostAreaCanBeCreated(int[] givenParams) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        //put -1
        stack.push(-1);
        for (int i = 0; i < givenParams.length; i++) {
            //-,3,6,8,9,3
            while(stack.peek() != -1 && givenParams[stack.peek()] > givenParams[i]) {
                max = Math.max(max, givenParams[stack.pop()] * (i - stack.peek() -1));
            }
            stack.push(i);
        }
        while(stack.peek() != -1) {
            max = Math.max(max, givenParams[givenParams.length -1] * (givenParams.length -stack.pop() -1));
        }
        return max;
    }
}
