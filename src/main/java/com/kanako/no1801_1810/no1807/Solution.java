package com.kanako.no1801_1810.no1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> l : knowledge) {
            map.put(l.get(0), l.get(1));
        }
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                flag = true;
                continue;
            } else if (s.charAt(i) == ')') {
                flag = false;
                if (map.containsKey(tmp.toString())) {
                    result.append(map.get(tmp.toString()));
                } else {
                    result.append('?');
                }
                tmp.setLength(0);
                continue;
            }
            if (!flag) {
                result.append(s.charAt(i));
            } else {
                tmp.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
