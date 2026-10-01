package com.kanako.no2901_2910.no2904;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int oneCnt = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '1') oneCnt++;
            while (oneCnt == k) {
                int len = i - left + 1;
                if (len < minLen) {
                    list.clear();
                    list.add(s.substring(left, i + 1));
                    minLen = len;
                } else if (len == minLen) {
                    list.add(s.substring(left, i + 1));
                }
                if (chars[left++] == '1') oneCnt--;
            }
        }
        list.sort(String::compareTo);
        return list.isEmpty() ? "" : list.getFirst();
    }
}
