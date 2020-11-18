package com.tiantianbaobao.algorithm.homework.rewrite;

/***
 * @description {Fibonacci} rewrite twice bootstrap, <p>and current implement is best</p>
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-17 19:13
 * @since V1.0.0
 */
public class FibonacciRewriteBootstrap {
    public static void main(String[] args) {
        int targetLocation = 6;
        System.err.println("the number of fibonacci at location " + targetLocation + " is " + _fibonacciCalculate(targetLocation));
    }

    /**
     * calculate fibonacci number of {@param targetLocation}
     * @param targetLocation
     * @return result
     */
    private static int _fibonacciCalculate(int targetLocation) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < targetLocation; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
