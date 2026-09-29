package com.kanako.no1343;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int currentSum = 0;
        int index = 0;
        int count = 0;
        while (index < arr.length) {
            currentSum += arr[index++];
            int left = index - k;
            if (left < 0) continue;
            if (currentSum / k >= threshold) count++;
            currentSum -= arr[left];
        }
        return count;
    }
}
