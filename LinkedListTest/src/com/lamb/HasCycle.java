package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/11
 * TIME:19:52
 */

/**
 * 给定一个链表，判断链表中是否有环，找出环的入口点
 *
 * 基本思路：快慢指针  快2慢1
 * 设置两个结点指针p1,p2，p1从链表开头走，p2从相遇点开始走，两指针相遇即为环的入口点
 * 快指针太快，有可能会直接跳过慢指针
 *
 */


public class HasCycle {

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    //获取链表的长度
    public int getLength(ListNode head){
        int len = 0;
        ListNode cur = head;

        while(cur != null){
            len ++;
            cur = cur.next;
        }
        return len;
    }

    //反转
    public ListNode reverse(ListNode head){
        ListNode result = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;

            //头插
            cur.next = result;
            result = cur;

            cur = next;
        }
        return result;
    }

    //判断有环
    public boolean hasCycle(ListNode head) {
        int len = getLength(head);
        int halfLen = len/2;

        ListNode middle = head;

        for(int i = 0; i < halfLen; i++){
            middle = middle.next;
        }

        ListNode r = reverse(middle);
        ListNode p1 = head;
        ListNode p2 = r;


        while (p2 != null && p1 != null){

            if(p1.val != p2.val){
                return  false;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return true;
    }

    //求环的入口点
    public ListNode detectCycle(ListNode head) {
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
