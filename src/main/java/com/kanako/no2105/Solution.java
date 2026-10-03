package com.kanako.no2105;

public class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int left = 0;
        int right = n - 1;
        int capA = capacityA, capB = capacityB;
        int count = 0;
        while (left < right) {
            if (plants[left] > capA) {
                count++;
                capA = capacityA - plants[left];
            } else {
                capA -= plants[left];
            }
            if (plants[right] > capB) {
                count++;
                capB = capacityB - plants[right];
            } else {
                capB -= plants[right];
            }
            left++;
            right--;
            if (left == right) {
                if (capA < plants[left] && capB < plants[left]) {
                    return count + 1;
                }
            }
        }
        return count;
    }
}
