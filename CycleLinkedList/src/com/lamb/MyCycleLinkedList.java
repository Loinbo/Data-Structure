package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/15
 * TIME:15:33
 */

/**
 * 给定一个链表，判断链表中是否有环，找出环的入口点
 *
 * 基本思路：快慢指针
 * 定义快慢指针fast,slow，初始化为head
 * 快2慢1    若为环形链表，fast肯定会先进入环中后slow进，并在某一点两指针相遇
 * 若为无环链表->fast先走到null或链表为null)
 *
 *
 * 设置两个结点指针p1,p2，p1从链表开头走，p2从相遇点开始走，两指针相遇即为环的入口点
 * 快指针太快，有可能会直接跳过慢指针
 *
 */

public class MyCycleLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //判断有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //链表为null或只有一个结点是没有环的
        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 求环的入口点
     *
     * 从链表起始点走到环的入口点 = 从相遇点走到环的入口点再加上若干个环长
     */
    public ListNode DetectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        //快2慢1遍历
        do{
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        } while(fast != null && fast != slow);

        if(fast == null){
            return  null;
        }

        ListNode p1 = head;  //p1从链表头结点开始走
        ListNode p2 = slow;  //p2从相遇点开始走
        //p1与p2相遇点----环的入口点
        while(p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}