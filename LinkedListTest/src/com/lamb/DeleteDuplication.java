package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/12
 * TIME:11:23
 */

/**
 * 删除链表中重复的结点
 *
 * 在一个有序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *
 * 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 *
 * 基本思路：
 * 1.创建结点，假结点dummy，指针结点prev,p1,p2
 * 2.令dummy.next->head  prev = dummy  p1->head   p2->head.next
 * 3.在p2不为空的条件下对p1,p2的值进行比较
 * 3.1 当P1和P2值不等，指针统一后移
 * 3.2 当P1和P2值相等且P2不为空，删除当前结点，仅将P2后移一位
 */

public class DeleteDuplication {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null){
            return null;
        }

        ListNode dummy = new ListNode(0);  //为前驱结点变量赋值,消除第一个结点没有前驱的特殊性
        dummy.next = pHead;

        ListNode prev = dummy;  // prev 永远是 p1 的前驱结点，用来删除结点
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;

        //比较p1和p2的值
        while (p2 != null) {
            if (p1.val != p2.val) {
                //值不同结点变量统一后移
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                //值相同p2后移，其余两个结点不动
                while (p2 != null && p1.val == p2.val) {
                    p2 = p2.next;
                }

                prev.next = p2; //将两个相同的p1和p2所指的结点同时删除

                p1 = p2;   //p1后移
                if (p2 != null) {
                    p2 = p2.next;  //p2后移
                }

            }
        }
        return dummy.next;
    }
}