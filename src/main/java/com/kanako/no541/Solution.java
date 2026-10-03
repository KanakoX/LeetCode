package com.kanako.no541;

import java.util.Arrays;

public class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % (2 * k) == 0) {
                char[] newChars = reverse(Arrays.copyOfRange(c, i - 2 * k + 1, i - k + 1));
                System.arraycopy(newChars, 0, c, i - 2 * k + 1, k);
            } else if (i == n - 1 && n % (2 * k) != 0) {
                int less = n % (2 * k);
                char[] newChars;
                if (less >= k) {
                    newChars = reverse(Arrays.copyOfRange(c, n - less, n - less + k));
                } else {
                    newChars = reverse(Arrays.copyOfRange(c, n - less, n));
                }
                System.arraycopy(newChars, 0, c, n - less, Math.max(k, n));
            }
        }
        return new String(c);
    }

    private char[] reverse(char[] c) {
        int n = c.length;
        for (int left = 0, right = n - 1; left < right; left++, right--) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
        }
        return c;
    }
}
