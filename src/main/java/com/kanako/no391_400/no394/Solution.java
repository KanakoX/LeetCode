package com.kanako.no391_400.no394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        StringBuilder current = new StringBuilder();
        int inner = 0;
        StringBuilder count = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count.append(c);
            } else if (c == '[') {
                stack.push(count.toString());
                count = new StringBuilder();
                stack.push(current.toString());
                current = new StringBuilder();
                inner++;
            } else if (Character.isLetter(c)) {
                current.append(c);
            } else if (c == ']') {
                inner--;
                // 栈顶是进入本层 [ 之前的字符串，下面是重复次数
                String prev = stack.pop().toString();
                int repeat = Integer.parseInt(stack.pop().toString());
                // 只重复括号里的 current，不要先和 prev 拼再重复
                StringBuilder sb = new StringBuilder();
                sb.repeat(current.toString(), repeat);
                String decoded = prev + sb;
                if (inner != 0) {
                    // 还在外层括号里：解码结果继续当作当前串
                    current = new StringBuilder(decoded);
                } else {
                    result.append(decoded);
                    current = new StringBuilder();
                }
            }
        }
        if (!current.isEmpty()) result.append(current);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[c]]"));
    }
}
