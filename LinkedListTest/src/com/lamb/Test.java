package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/11
 * TIME:18:53
 */

public class Test {

    public class Node {
        int val;
        Node next;
        Node(int x) { val = x; }
    }

    //反转链表

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
    public Node Reverse(Node head){
        if(head == null){
            return null;
        }

        Node result = null;  //创建新链表
        Node cur = head;

        while(cur != null) {
            Node next = cur.next;

            //头插
            cur.next = result;
            result = cur;

            cur = next;
        }
        return result;
    }


    //合并有序链表
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 基本思路：两个有序表合并
     * 判空
     * cur1和cur2同时不为空：尾插
     * cur1和cur2有一个为空(在合并过程中，一个表的元素全被转移到新表中)，将另一个表直接尾插进新表
     */

    public Node Merge(Node listA, Node listB){
       Node cur1 = listA;   //创建A表结点变量
       Node cur2 = listB;   //创建B表结点变量
       Node result = null;
       Node last = null;

       if(listA == null){
           return listB;
       }
       if(listB == null){
           return listA;
       }

       while(cur1 != null && cur2 != null){
           Node next = cur1.next;   //存档
           if(cur1.val<cur2.val){
           //尾插
           if(result == null){
               return cur1;
           } else {
               last.next = cur1;
               last = cur1;  //更新最后一个结点
           }
           cur1 = next;

           }else {
               if(result == null){
                   return cur2;
               } else {
                   last.next = cur2;
                   last = cur2;  //更新最后一个结点
               }
               cur2 = next;
           }
       }
       if(cur1 == null){
            last.next = cur2;
        }
        if(cur2 == null){
            last.next = cur1;
        }
        return result;
    }

}

/**
 * 链表中倒数第k个结点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 基本思路：定义两个结点变量(front,back) 前后引用
 * 让front先走k步，back再开始走
 * 当front为空的时候代表走到了链表的尽头，此时的back所指向的就是倒数第k个数
 *
 */

class FindKthToTailSolu {

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

        //front先走k步
        for(i = 0; i < k && front != null; i++){
            front = front.next;
        }

        //讨论两种情况：1.front == null && i<k越界找不到元素的
        //2.front == null && i>=k可以找到倒数第k个元素，即head
        if(front == null && i<k){
            return null;
        } else if(front == null) {
            return head;
        }

        //开始遍历，front先走K步，到front == null时back所指即为倒数第k个数
        while(front != null){
            front = front.next;
            back = back.next;
        }
        return back;
    }
}




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

 class DeleteDuplication1 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {

        ListNode dummy = new ListNode(0);   //创建假结点作为链表前驱假结点，为其赋值val = 0
        dummy.next = pHead;

        ListNode prev = dummy;   //创建链表前驱结点，用来删除相同结点
        ListNode p1 = pHead;
        ListNode p2 = pHead.next;

        while (p2 != null) {
            if (p1.val != p2.val) {
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                //值相同，p2后移一位
                while (p2 != null && p1.val == p2.val) {
                    p2 = p2.next;
                }

                prev.next = p2;  //删除相同的两个结点

                //p1,p2均后移
                p1 = p2;
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
        }
        return dummy.next;
    }

}
