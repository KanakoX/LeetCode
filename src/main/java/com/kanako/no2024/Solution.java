package com.kanako.no2024;

public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        char[] ansArray = answerKey.toCharArray();
        int fCnt = 0, tCnt = 0;
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (ansArray[i] == 'T') tCnt++;
            else if (ansArray[i] == 'F') fCnt++;
            while (tCnt > fCnt ? fCnt > k : tCnt > k) {
                char leftChar = ansArray[left++];
                if (leftChar == 'T') tCnt--;
                else if (leftChar == 'F') fCnt--;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
