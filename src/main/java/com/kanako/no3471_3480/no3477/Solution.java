package com.kanako.no3471_3480.no3477;

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count = 0;
        for (int fruit : fruits) {
            int flag = 1;
            for (int j = 0; j < baskets.length; j++) {
                if (fruit <= baskets[j]) {
                    baskets[j] = 0;
                    flag = 0;
                    break;
                }
            }
            count += flag;
        }
        return count;
    }
}
