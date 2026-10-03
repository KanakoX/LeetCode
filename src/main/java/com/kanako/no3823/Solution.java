package com.kanako.no3823;

public class Solution {
    public String reverseByType(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < n - 1 && (c[left] < 'a' || c[left] > 'z')) left++;
            while (right >= 1 && (c[right] < 'a' || c[right] > 'z')) right--;
            if (left >= right) break;
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        left = 0;
        right = n - 1;
        while (left < right) {
            while (left < n - 1 && c[left] >= 'a' && c[left] <= 'z') left++;
            while (right >= 1 && c[right] >= 'a' && c[right] <= 'z') right--;
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        return new String(c);
    }
}
