package com.kanako.no1921_1930.no1927;

public class Solution {
    public boolean sumGame(String num) {
        return compare(num);
    }

    private boolean compare(String num) {
        int a = 0, b = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i < num.length() / 2) {
                a += num.charAt(i) - '0';
            } else {
                b += num.charAt(i) - '0';
            }
        }
        return a != b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumGame("50?223"));
    }
}
