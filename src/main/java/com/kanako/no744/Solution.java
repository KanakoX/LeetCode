package com.kanako.no744;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] < (target + 1)) left = mid + 1;
            else right = mid - 1;
        }
        if (left == n) return letters[0];
        return letters[left];
    }
}
