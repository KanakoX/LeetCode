package com.kanako.no125;

public class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left]) && !Character.isDigit(chars[left])) left++;
            while (left < right && !Character.isLetter(chars[right]) && !Character.isDigit(chars[right])) right--;
            if (left >= right) break;
            if (!String.valueOf(chars[left]).equalsIgnoreCase(String.valueOf(chars[right]))) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
