package com.kanako.no32;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        int[] valid = new int[n];
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) valid[i] = 1;
                else stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            valid[stack.peek()] = 1;
            stack.pop();
        }
        System.out.println(Arrays.toString(valid));
        for (int i = 0; i < n; i++) {
            if (valid[i] == 1) {
                maxLen = Math.max(maxLen, curLen);
                curLen = 0;
                continue;
            }
            curLen++;
        }
        return Math.max(maxLen, curLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()"));
    }
}
