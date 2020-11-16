package com.tiantianbaobao.algorithm.practise;

import java.util.Arrays;

/***
 * @description move zero object to array last location
 * @author <h>tiantiabaobao</h>
 * @date 2020-11-16 10:02
 * @since V1.0.0
 */
public class MovedZeroBootstrap {
    public static void main(String[] args) {
        int[] target = new int []{1,2,3,4,0,4,0,0,0,2,3,0,0,7,4};
        System.err.println(Arrays.toString(_defaultSolution(target)));
        System.err.println(Arrays.toString(_bestSolution(target)));
    }

    /**
     * requirement：don't need other array
     *  the not-smart solution of move zero object to last location
     *  look at this -> [0,2,3,4,5,0, 4] -> [2,3,4,5,4,0,0]
     * @param target need to handle unOrdered  array
     * @return current {@param target} which has moved zero to last location
     */
    private static int[] _defaultSolution(int[] target) {
        int index = 0;
        //遇0删除，后者往前进位
        for (int i=0;i<target.length - 1;i++){
            if (target[i] == 0 ) {
                target[i] = target[i + 1];
                index ++;
            }
        }
        //补齐末尾的0
        for (int i = index; i<target.length; i++) {
            target[i] = 0;
        }
        return target;
    }

    /***
     * the best solution of moved zero object to the last location
     * swap location with i and i+1 when arr[i] == 0 and arr[i+1] !=0;
     * look at this -> [0,2,3,4,0,0,4] -> [2,3,4,4,0,0,0]
     * @param target need to handle unOrdered array
     * @return current {@param target} which has moved zero to last location
     */
    private static int[] _bestSolution(int[] target) {
        for(int i=0,count=0;i<target.length;i++){
            if(target[i] != 0){
                //执行替换操作
                if(count != i){
                    target[count] = target[i];
                    target[i] = 0;
                }
                count++;
            }
        }
        return target;
    }


}
