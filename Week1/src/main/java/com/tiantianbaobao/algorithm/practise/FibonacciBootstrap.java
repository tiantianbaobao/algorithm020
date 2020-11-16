package com.tiantianbaobao.algorithm.practise;

/***
 * @description {Fibonacci}  practise case
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-11-13 22:26
 * @since V1.0.0
 */
public class FibonacciBootstrap {
    public static void main(String[] args) {
        long start = System.nanoTime();
//        long result = _defaultCalculateFibonacci(10);
//        long result = _memoryCalculateFibonacci(10000);
        long result = _bestCalculateFibonacci(1000000000);
        System.out.println("calculate fibonacci method and result is : "
                + result
                + ", and cast "
                + (System.nanoTime() - start)
                + "ns");
    }

    /**
     * if the parameter {x} is big ,it's easy cause java.lang.StackOverflowError
     *  and default implement  Big O nocation is O(2^n), the code style is very lower!
     * @param x
     * @return
     */
    private static long _defaultCalculateFibonacci(int x) {
        if (x < 2) {
            return x;
        }
        return _defaultCalculateFibonacci(x - 1) + _defaultCalculateFibonacci(x - 2);
    }

    /**
     * base memory, put f(x - 1) and f(x - 2) into cache, and get particular result from cache to calculate next
     * look at this -> [0, 1, 1 ,2, 3, 5, 8, 13, 21, ...] ->
     * @param x
     * @return
     */
    private static long _memoryCalculateFibonacci(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int[] cache = new int[x + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= x; i++) {
            cache[i] = cache[i - 1] + cache[i -2];
            //why mod 1000000007? because 1000000007 是最小的十位质数，这样可以保证中间变量和结果值都不会溢出
            cache[i] %= 1000000007;
        }
        return cache[x];
    }

    /**
     * best solution about fibonacci ,use dynamic programing
     * <i>the important message is to use  'sum % 1000000007' to protect not out of range about Integer</i>
     * @param  x the target location param
     * @return result
     */
    private static long _bestCalculateFibonacci(int x) {
        int a = 0, b = 1, sum;
        for (int i = 0; i< x; i++) {
            sum = (a + b) % 1000000007;
//            sum = a+ b;
            a = b;
            b = sum;
        }
        return a;
    }
}
