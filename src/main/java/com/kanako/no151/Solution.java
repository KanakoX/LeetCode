package com.kanako.no151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                String temp = s.substring(start, i);
                if (!temp.equals(" ") && !temp.isEmpty()) {
                    list.add(temp);
                }
                start = i + 1;
            }
        }
        String temp = s.substring(start, n);
        if (!temp.equals(" ") && !temp.isEmpty()) {
            list.add(temp);
        }
//        System.out.println(Arrays.toString(list.toArray()));
        String[] words = list.toArray(new String[0]);
        for (int left = 0, right = words.length - 1; left < right; left++, right--) {
            String tmp = words[left];
            words[left] = words[right];
            words[right] = tmp;
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("t"));
    }
}
