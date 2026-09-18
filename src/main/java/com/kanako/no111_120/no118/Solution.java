package com.kanako.no111_120.no118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>(i + 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}
