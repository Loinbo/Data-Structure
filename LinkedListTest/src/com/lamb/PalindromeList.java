package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/12
 * TIME:9:42
 */

/**
 * 链表的回文结构
 *
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 *
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 * 测试样例：
 *         1->2->2->1
 * 返回：
 *      true
 *
 * 基本思路：找中间结点+反转后半部分链表与前半部分进行比较
 *
 * 先求出链表的长度-->求链表的一半长度---->找中间结点
 * 再反转后半部分链表
 * 最后判断回文
 */

public class PalindromeList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //获取链表长度
    public int getLength(ListNode head){
        int len = 0;
        ListNode cur = head;

        while(cur != null){
            len ++;
            cur = cur.next;
        }
        return len;
    }

    //反转函数
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
        return  result;
    }

    //判断回文
    public boolean chkPalindrome(ListNode A) {
        ListNode middle = A;
        int len = getLength(A);
        int halfLen = len/2;

        //寻找中间结点middle
        for(int i = 0; i < halfLen; i++){
            middle = middle.next;
        }

        //从middle开始到尾结点进行链表反转
        ListNode r = reverse(middle);

        ListNode c1 = A;  //c1初始化为原链表头结点
        ListNode c2 = r;  //c2初始化为反转后的链表头结点

        //遍历进行值比对
        while(c1 != null && c2 != null){
            if(c1.val != c2 .val){
                return false;
            } else {
            c1 = c1.next;
            c2 = c2.next;
            }
        }
        return true;
    }

}
