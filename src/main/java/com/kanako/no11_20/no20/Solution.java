package com.kanako.no11_20.no20;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '{' || aChar == '[') {
                stack.push(aChar);
            } else if (aChar == ')' || aChar == '}' || aChar == ']') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(' && aChar == ')') stack.pop();
                else if (stack.peek() == '{' && aChar == '}') stack.pop();
                else if (stack.peek() == '[' && aChar == ']') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
