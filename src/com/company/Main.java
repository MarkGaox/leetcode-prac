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
	// write your code here
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
