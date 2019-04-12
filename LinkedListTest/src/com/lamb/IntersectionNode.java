package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/11
 * TIME:19:33
 */

/**
 * 两个单链表交叉
 *(条条大路通罗马----尾结点)
 *
 * 1.判断链表是否发生了交叉
 * 2.如果交叉找出是哪个结点交叉了
 * 长的链表先走lengthlong-lengthshort步----保证循环初始两个链表长短相同
 * 然后长短链表一起遍历，两个结点第一次相遇的即为结点
 */

public class IntersectionNode {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    //获取链表长度
    private int getLength(ListNode head){

        int len = 0 ;
        /*
         ListNode cur = head;
         while(cur != null){
             len ++;
             cur = cur.next;
        */
        for(ListNode cur =head;cur!= null;cur = cur.next){
            len ++;
        }
        return len;
    }

    //判断交叉+求交叉结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        ListNode longer = headA;
        ListNode shorter = headB;

        int diff = lenA-lenB;

        if(lenA < lenB){
            diff = lenB-lenA;
            longer = headB;
            shorter = headA;
        }

        //让长的链表先走diff步,保证下一步while值对比循环初始两个链表长度是相同的
        for(int i = 0; i < diff; i++){
            longer =longer.next;
        }

        //循环遍历，当值相等时停止循环
        while(longer != shorter){
            longer = longer.next;
            shorter = shorter.next;
        }
        //返回交叉结点
        return longer;
    }
}
