package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/9
 * TIME:12:55
 */

/**
 * 链表中倒数第k个结点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 基本思路：定义两个结点变量(front,back) 前后引用
 * 让front先走k步，back再开始走
 * 当front为空的时候代表走到了链表的尽头，此时的back所指向的就是倒数第k个数
 *
 * 判断两个状况：若front为空并且k大于结点数时，意味着找不到这个元素，直接返回null [1,6) i=6,k=7
 * 当front为null,而i>=k时，直接返回head [1,6] i=6,k=6
 *
 */

public class FindKthToTail {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindLastKth(ListNode head,int k) {

        ListNode front = head;
        ListNode back = head;
        int i;

        for (i = 0; front != null && i < k; i++) {
            front = front.next;            //front先走到正数第k个元素
        }

        if (front == null && i < k) {
            // k 大于 结点个数
            return null;
        } else if (front == null) {    //[1,6]
            return head;
        }

        //front和back一前一后对链表进行遍历，直到front == null
        while (front != null) {
            front = front.next;
            back = back.next;
        }

        return back;
    }
}
