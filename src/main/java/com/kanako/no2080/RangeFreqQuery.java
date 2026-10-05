package com.kanako.no2080;

import java.util.*;

public class RangeFreqQuery {

    Map<Integer, List<Integer>> pos = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = pos.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            pos.put(arr[i], list);
        }
    }

    public int query(int left, int right, int value) {
        int n = right - left + 1;
        List<Integer> list = pos.get(value);
        if (list == null) return 0;
        int start = lowerBound(list, left);
        if (start == n) return 0;
        int end = lowerBound(list, right + 1) - 1;
        return end - start + 1;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
