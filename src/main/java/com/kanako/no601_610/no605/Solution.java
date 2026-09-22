package com.kanako.no601_610.no605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 0) return false;
        if (n == 0) return true;
        if (flowerbed.length == 1) {
            return (n == 1 && flowerbed[0] == 0) || n == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i >= 1 && i < flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                } else if (i == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                } else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
            if (n == 0) return true;
        }
        return false;
    }
}
