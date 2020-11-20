package com.tiantianbaobao.algorithm.homework.compare;

import java.util.Stack;

/***
 * @description calculate the most capacity of rain
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-17 19:53
 * @since V1.0.0
 */
public class MostRainCapacityBootstrap {
    public static void main(String[] args) {
//        int[] givenParams = new int[]{1, 2, 3, 1 ,2 ,3, 7};
        int[] givenParams = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.err.println("The most capacity of given params is " + _calculateMostRainCapacity(givenParams));
    }

    /***
     * calculate the most capacity by given params
     * principle:
     * @param givenParams params to calculate
     * @return the most capacity
     */
    private static int _calculateMostRainCapacity(int[] givenParams) {
        if (givenParams == null || givenParams.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int sum = 0, j = 0, i = 0;
        while(i < givenParams.length) {
            while (!stack.isEmpty() && givenParams[i] > givenParams[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                //(min(h(a), h(b)) - he(down)) * distance
                sum += (Math.min(givenParams[i], givenParams[stack.peek()]) - givenParams[top]) * (i - stack.peek() -1);
            }
            stack.push(i++);
        }
        return sum;
    }
}
