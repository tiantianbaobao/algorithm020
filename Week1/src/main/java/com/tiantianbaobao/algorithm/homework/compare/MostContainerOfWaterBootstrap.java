package com.tiantianbaobao.algorithm.homework.compare;

/***
 * @description the most area of water container
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-17 19:27
 * @since V1.0.0
 */
public class MostContainerOfWaterBootstrap {
    public static void main(String[] args) {
        int[] givenParams = new int[]{1, 1, 2, 3, 4, 5, 6};
        System.err.println("The most area of container is " + _mostAreaContainer(givenParams));
    }

    /***
     * calculate the most area of container by given params
     * <p> we can use double array pointer, this think called <i>Rule of clamp force</></p>
     * @param givenParams
     * @return the most area container for water
     */
    private static int _mostAreaContainer(int[] givenParams) {
        int a = 0, b = givenParams.length - 1, max = 0;
        while(a < b) {
            max = Math.max(max, Math.min(givenParams[a], givenParams[b]) * (b - a));
            if (givenParams[a] < givenParams[b]) {
                a++;
            }else {
                b--;
            }
        }
        return max;
    }
}
