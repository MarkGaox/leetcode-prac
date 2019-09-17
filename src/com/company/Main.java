package com.company;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        Example:
//
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // QuickSort test
        int[] nums = {17,231,-23,585,6,1, 342, 54, 57,  4324};
        QuickSort a = new QuickSort();
        a.QuickSort(nums,0, nums.length - 1);

        // Kth largest element test
        int[] b = {3,2,3,1,2,4,5,5,6};
        int[] c = {3,1,2,4,5,6,7,9};
        KthLargest k = new KthLargest();
        k.findKthLargest(c, 4);
        //System.out.println(Arrays.toString(c));

        // test longestCommonPrefix to see why it works.
        String[] q = {"flower", "floor", "flight"};
        LongestCommonPrefix tset = new LongestCommonPrefix();
        String qwq = tset.longestCommonPrefix(q);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (a.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = a.get(target - nums[i]);
            }
            a.put(nums[i], i);
        }
        return result;
    }

}
