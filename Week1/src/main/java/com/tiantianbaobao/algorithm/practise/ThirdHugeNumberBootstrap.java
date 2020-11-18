package com.tiantianbaobao.algorithm.practise;

/***
 * @description look for the third huge humber from given array
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-16 18:21
 * @since V1.0.0
 */
public class ThirdHugeNumberBootstrap {
    public static void main(String[] args) {
        int[] givenArray = new int[]{2,-1, 4, 2, 2, 0};
        System.err.println("the third huge number from given array is : " + _lookForThirdNumber(givenArray));
    }

    /***
     * look for the third biggest number from given array,if the length of array less than 3, then will return the biggest number
     * requirement:1、the complex must is O(n), and if has repeated number, it's should look for tne next;
     * just like this :[3, 2, 2] -> return 3; [3, 2, 2, 1] -> should return 1
     * @param givenArray
     * @return
     */
    private static long _lookForThirdNumber(int[] givenArray) {
        Integer max1 = null, max2 = null, max3 = null;
        for (Integer obj : givenArray) {
            if (obj.equals(max1) || obj.equals(max2) || obj.equals(max3)) {
                continue;
            }
            if (max1 == null || obj > max1) {
                max3 = max2;
                max2 = max1;
                max1 = obj;
            }else if (max2 == null || obj > max2) {
                max3 = max2;
                max2 = obj;
            }else if(max3 == null || obj > max3) {
                max3 = obj;
            }
        }
        return max3 == null ? max1 : max3;
    }

}
