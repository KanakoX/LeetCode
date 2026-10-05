package com.kanako.no1170;

import java.util.Arrays;

public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int m = words.length;
        int[] convert = new int[m];
        for (int i = 0; i < m; i++) {
            convert[i] = f(words[i]);
        }
        Arrays.sort(convert);

        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int target = f(queries[i]);
            int index = binary(convert, target + 1);
            ans[i] = m - index;
        }
        return ans;
    }

    private int f(String s) {
        char[] chars = s.toCharArray();
        char minC = 'z';
        int cnt = 0;
        for (char aChar : chars) {
            if (aChar < minC) {
                minC = aChar;
                cnt = 1;
            } else if (aChar == minC) cnt++;
        }
        return cnt;
    }

    private int binary(int[] words, int target) {
        int left = 0, right = words.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (words[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
