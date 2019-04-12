package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/8
 * TIME:21:05
 */

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 基本思路：建立新链表，遍历筛选非val值尾插进新链表中
 */

public class RemoveEle {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = null;  //创建结果链表，初始为null
        ListNode last = null;   //结果链表的尾结点，初始为null

        ListNode cur = head;
        while(cur.next != null){
            ListNode next = cur.next;   //此处为cur存档

            if(cur.val != 6){
                //尾插
                if(result == null){
                    result = cur;
                }else{
                    last.next = cur;
                }

                last = cur;  //更新链表的最后一个元素
            }

            cur = next;    //回档，继续读原链表的下一个元素
        }
        return result;
    }
}
