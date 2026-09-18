package com.kanako.no1511_1520.no1520;

import java.util.*;

public class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c)[1] = i;
            } else {
                map.put(c, new int[]{i, i});
            }
        }

        List<int[]> intervals = new ArrayList<>();
        for (int[] range : map.values()) {
            int L = range[0];
            int R = range[1];
            boolean valid = true;
            for (int j = L; j <= R; j++) {
                int[] cur = map.get(s.charAt(j));
                if (cur[0] < L) {
                    valid = false;
                    break;
                }
                R = Math.max(R, cur[1]);
            }
            if (valid) {
                intervals.add(new int[]{L, R});
            }
        }

        intervals.sort(Comparator.comparingInt(a -> a[1]));
        List<String> ans = new ArrayList<>();
        int prevEnd = -1;
        for (int[] it : intervals) {
            if (it[0] > prevEnd) {
                ans.add(s.substring(it[0], it[1] + 1));
                prevEnd = it[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxNumOfSubstrings("adefaddaccc"));
        System.out.println(solution.maxNumOfSubstrings("abbaccd"));
    }
}
