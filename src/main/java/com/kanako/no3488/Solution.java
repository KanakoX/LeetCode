package com.kanako.no3488;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = pos.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            pos.put(nums[i], list);
        }
        for (List<Integer> list : pos.values()) {
            list.add(list.getFirst() + n);
            list.addFirst(list.getLast() - n);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : queries) {

        }
        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
