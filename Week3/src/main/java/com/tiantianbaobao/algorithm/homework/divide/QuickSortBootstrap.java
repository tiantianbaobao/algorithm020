package com.tiantianbaobao.algorithm.homework.divide;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 * @description
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-05 23:44
 * @since V1.0.0
 */
public class QuickSortBootstrap {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 1 ,3 ,9, 0, 2, 5, 8};
        _quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /***
     * principle:choice a target, and divide
     * @param nums
     * @return
     */
    private static void _quickSort(int[] nums, int start, int last) {
        if (start >= last) {
            return;
        }
        //while loop + two pointer
//        int pivot = partition(nums, start, last);
        //for loop + mark
        int pivot = partitionII(nums, start, last);
        _quickSort(nums, start, pivot - 1);
        _quickSort(nums, pivot + 1, last);
    }

    /***
     * use while loop and two pointer
     * @param nums
     * @param start
     * @param last
     * @return
     */
    private static int partition(int[] nums, int start, int last) {
        int pivot = nums[start];
        int left = start;
        int right = last;
        while (left != right) {
            //right-obj more than pivot
            while(left < right && nums[right] > pivot) {
                right--;
            }
//            while(left < right && nums[right--] > pivot);
//            while(left < right && nums[left++] <= pivot);
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            //exchange
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //pivot exchange with nums[left]
        nums[start] = nums[left];
        nums[left] = pivot;
        return left;
    }

    /***
     * we can use while loop
     *
     * principle: 2,    4,    6,    0,     3,    1
     *            pivot
     *               mark ->
     *            2      1     6     0       3     4
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int partitionII(int[] nums, int start, int end) {
        int mark = start;
        int pivot = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
                mark++;
                int temp = nums[mark];
                nums[mark] = nums[i];
                nums[i] = temp;
            }
        }
        nums[start] = nums[mark];
        nums[mark] = pivot;
        return mark;
    }
}
