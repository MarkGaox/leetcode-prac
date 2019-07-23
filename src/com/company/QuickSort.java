package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void main() {
        int[] nums = {3,2,4,5,6,1};
        QuickSort(nums,0, 5);
    }

    public static void QuickSort(int[] nums, int l, int h) {
        //System.out.println(Arrays.toString(nums));
        if (l < h) {
            int index = partition(nums, l, h);
            QuickSort(nums, l, index -1);
            QuickSort(nums, index+1, h);
        }
    }

    private static int partition(int[] nums, int l, int h) {
        int pivot = nums[(l + h)/2];

        while (h > l) {
            while (nums[l] < pivot) {
                l++;
            }
            while (nums[h] > pivot) {
                h--;
            }
            int temp = nums[l];
            nums[l] = nums[h];
            nums[h] = temp;
        }
        return l;
    }
}
