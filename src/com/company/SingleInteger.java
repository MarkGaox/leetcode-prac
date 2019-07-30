package com.company;

/*
136. Single Number
Easy

2656

99

Favorite

Share
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */
public class SingleInteger {
    public int SingleInteger(int[] nums) {
        int res = 0;
        for(int a : nums) {
            res ^= a;
        }
        return res;
    }
}

/*
KEY THING:

1. 3 ^ 3 = 0;
2. 3 ^ 2 ^ 3 = 2;
3. 0 ^ 3 ^ 2 ^ 3 = 2;
 */