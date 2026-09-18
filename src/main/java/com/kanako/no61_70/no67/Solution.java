package com.kanako.no61_70.no67;

public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int aIdx = aLen - 1;
        int bIdx = bLen - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (aIdx >= 0 || bIdx >= 0) {
            if (aIdx >= 0 && bIdx >= 0) {
                int aVal = a.charAt(aIdx) - '0';
                int bVal = b.charAt(bIdx) - '0';
                int sum = aVal + bVal + carry;
                carry = 0;
                if (sum >= 2) {
                    carry = 1;
                    sum -= 2;
                }
                result.append(sum);
            } else if (aIdx >= 0) {
                int aVal = a.charAt(aIdx) - '0';
                int sum = aVal + carry;
                carry = 0;
                if (sum >= 2) {
                    carry = 1;
                    sum -= 2;
                }
                result.append(sum);
            } else {
                int bVal = b.charAt(bIdx) - '0';
                int sum = bVal + carry;
                carry = 0;
                if (sum >= 2) {
                    carry = 1;
                    sum -= 2;
                }
                result.append(sum);
            }
            aIdx--;
            bIdx--;
        }
        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
