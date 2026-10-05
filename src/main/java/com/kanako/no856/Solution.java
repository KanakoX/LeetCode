package com.kanako.no856;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int depth = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                depth++;
            } else if (chars[i] == ')') {
                depth--;
                if (chars[i - 1] == '(') {
                    ans += 1 << depth;
                }
            }
        }
        return ans;
    }
}
// (4)
