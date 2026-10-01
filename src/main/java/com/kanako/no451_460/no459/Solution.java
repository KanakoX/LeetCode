package com.kanako.no451_460.no459;

import java.util.Arrays;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
