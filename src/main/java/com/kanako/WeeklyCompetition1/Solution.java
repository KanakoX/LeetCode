package com.kanako.WeeklyCompetition1;

public class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int rowS = source[0], colS = source[1];
        int rowT = target[0], colT = target[1];
        if (rowS == rowT && colS == colT) return 0;
        if (rowS == rowT || colS == colT || Math.abs(rowS - rowT) == Math.abs(colS - colT)) {
            return 1;
        }
        return 2;
    }
}
