package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/9
 * TIME:12:59
 */

/**
 * 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3
 * 返回的结点值为 3 。
 *
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4
 *
 * 基本思路：双指针遍历---->快慢指针：快2慢1
 * 返回慢指针
 */

public class MiddleNode {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

    /*
        //fast遍历
        while(fast != null){
            fast = fast.next;
            if(fast == null){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
    */
        return slow;
    }

}
