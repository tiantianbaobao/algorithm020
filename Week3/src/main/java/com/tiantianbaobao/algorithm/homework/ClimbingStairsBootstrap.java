package com.tiantianbaobao.algorithm.homework;

/***
 * @description climbing stairs -> Fibonacci
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-05 22:36
 * @since V1.0.0
 */
public class ClimbingStairsBootstrap {
    public static void main(String[] args) {
        System.err.println(_climbing(3));
        System.err.println(_climbingStairsByBollingArray(2));
    }

    /***
     * DP
     * @param n
     */
    public static int _climbing(int n) {
        int[] temp = new int[n + 1];
        temp[0] = 1;
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[n];
    }

    /***
     * look this : 1, 2, 3 -> 2, 3, 5 -> 3, 5, 8
     *             q  p  s -> p, s, q -> s, q, p
     *
     * @param n
     * @return
     */
    public static int _climbingStairsByBollingArray(int n) {
        int q = 0, p = 0, s = 1;
        for (int i = 0; i < n; ++i) {
            q = p;
            p = s;
            s = q + p;
        }
        return s;
    }

}
