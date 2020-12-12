package com.tiantianbaobao.algorithm.homework;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-13 1:07
 * @since V1.0.0
 */
public class Sqrt {
    public static void main(String[] args) {
        int x = 1000000;
        System.err.println("sqrt of " + x +  " is " + _sqrt(x));
        System.err.println("sqrt of " + x +  " is " + _sqrtSpecialByNiuDun(x));
    }

    /***
     * 近似整数平方根， 即x = 8, 则_sqrt(8) ~= 2
     * principle  二分搜索，类似于二叉搜索树，利用单调递增的特性以及index的可访问性
     * @param x
     * @return ~= sqrt(x)
     */
    private static int _sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 1L, right = x;
        long mid = 1L;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            }else {
                left = left + 1;
            }
        }
        return (int)right;
    }

    /***
     * 利用牛顿法，是一个数学小窍门
     * @param x
     * @return
     */
    private static int _sqrtSpecialByNiuDun(int x) {
        long s = x;
        while(s * s > x) {
            s = (s + x / s) / 2;
        }
        return (int)s;
    }

}
