package com.kanako.no151_160.no160;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null && !set.add(headA)) {
                return headA;
            }
            if (headB != null && !set.add(headB)) {
                return headB;
            }
            if (headA != null) headA = headA.next;
            if (headB != null) headB = headB.next;
        }
        return null;
    }
}
