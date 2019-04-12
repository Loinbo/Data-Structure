package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/9
 * TIME:9:07
 */

/**
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *
 * 给定一个链表的头指针 ListNode pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 *
 * 基本思路：创建新的链表，以x为界限，小于x的结点尾插存放在small，大于或等于x的结点尾插存放在big，最终合并两个表
 */

public class Partition {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        ListNode small = null;  //小于x的存放链表
        ListNode smallLast = null;  //小于x的链表的最后一个结点

        ListNode big = null;  //大于或等于x的存放链表
        ListNode bigLast = null;  //大于或等于x的链表的最后一个结点

        ListNode cur = pHead;   //定义链表元素变量，初始为pHead

        while(cur != null){

            ListNode next = cur.next; //存档

            //小于x，尾插至small
            if(cur.val < x){

                if(small == null){
                    small = cur;
                } else {
                    smallLast.next = cur;
                }
                smallLast = cur;   //更新最后一个结点

            } else {
                //大于或等于x，尾插至big
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;   //更新最后一个结点
                bigLast.next =null;
            }
            cur = next;  //回档
        }

        //当一个表为空
        if(small == null){
            return  big;
        } else {
            smallLast.next = big;
            return small;
        }
    }
}
