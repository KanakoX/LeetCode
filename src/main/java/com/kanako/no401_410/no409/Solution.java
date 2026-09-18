package com.kanako.no401_410.no409;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        AtomicInteger result = new AtomicInteger();
        map.values().forEach(v -> {
            result.addAndGet((v / 2 * 2));
            if (result.get() % 2 == 0 && v % 2 == 1) {
                result.getAndIncrement();
            }
        });
        return result.get();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
}
