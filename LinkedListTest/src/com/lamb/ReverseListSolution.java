package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/8
 * TIME:21:23
 */

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 基本思路：创建新链表，将原表的元素头插进新表中
 */

public class ReverseListSolution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseList1(ListNode head) {
        ListNode result = null;

        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;   //存档

            //头插
            cur.next = result;
            result = cur;    //不断更新头结点

            cur = next;   //回档
        }
        return result;
    }


    /**
     * 进阶:
     * 三引用遍历反转链表
     *
     * 基本思路:定义三个结点：
     * prev--指向前一个结点,
     * cur--指向当前结点,
     * next--指向下一结点
     * 当cur == null时停止遍历
     */

    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = null;
        ListNode cur = head;

        //prev-->cur-->next
        while(cur != null){
            ListNode next = cur.next;

            cur.next = prev;    //反转 next-->cur-->prev

            prev = cur;
            cur = next;

        }
        // 返回反转后的链表 此时prev已经指向最后一个结点，cur和next都指向空
        return prev;
    }
}
