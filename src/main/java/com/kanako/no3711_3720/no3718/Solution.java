package com.kanako.no3711_3720.no3718;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int multiple = k;
        while (set.contains(multiple)) {
            multiple += k;
        }
        return multiple;
    }
}
