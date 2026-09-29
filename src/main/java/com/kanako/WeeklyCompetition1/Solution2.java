package com.kanako.WeeklyCompetition1;

public class Solution2 {
    /**
     * 操作：选 i≠j 和任意 delta，
     *   source[i] += source[j] - delta
     *   source[j] = delta
     * 不变式：source[i]+source[j] 不变 ⇒ 全数组总和不变。
     * delta 任意 ⇒ 只要 n≥2，同总和就能调成任意 target。
     * n==1 时无法操作，必须原本就相等。
     */
    public boolean canTransform(int[] source, int[] target) {
        int n = source.length;
        if (n == 1) {
            return source[0] == target[0];
        }
        long sumS = 0, sumT = 0;
        for (int i = 0; i < n; i++) {
            sumS += source[i];
            sumT += target[i];
        }
        return sumS == sumT;
    }
}
