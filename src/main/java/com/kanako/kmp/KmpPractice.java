package com.kanako.kmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// aabaaab
public class KmpPractice {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] indexArray = compare("eeeeeeejjjjjjjjjjsssssssssaabcdbcdabcd", "abcd");
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(indexArray));
        System.out.println(end - start);
    }

    private static int[] prefixCal(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                String sub = s.substring(0, j);
                String sub2 = s.substring(i - j + 1, i + 1);
                if (sub.equals(sub2)) {
                    lps[i] = j;
                    break;
                }
            }
        }
        return lps;
    }

    private static int[] prefixCal2(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = lps[i - 1] + 1; j >= 0; j--) {
                String sub = s.substring(0, j);
                String sub2 = s.substring(i - j + 1, i + 1);
                if (sub.equals(sub2)) {
                    lps[i] = j;
                    break;
                }
            }
        }
        return lps;
    }

    private static int[] prefixCal3(String s) {
        int n = s.length();
        int[] lps = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

    private static int[] compare(String s, String t) {
        List<Integer> list = new ArrayList<>();
        int n = s.length();
        int m = t.length();
        int[] lps = prefixCal3(t);
        int i = 0, j = 0;
        while (i < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    list.add(i - m);
                    j = lps[j - 1];
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else i++;
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
