package com.lamb;

import java.util.List;

/**
 * Created by Loinbo
 * DATE:2019/4/9
 * TIME:8:43
 */

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

public class MergeTwoLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null;   //创建新链表，初始为空
        ListNode last = null;   //创建最后一个结点，初始为null

        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                ListNode next = cur1.next;   //存档

                //cur1尾插
                if(result == null){
                    result = cur1;
                }else{
                    last.next = cur1;
                }
                    last = cur1;   //更新最后一个结点

                cur1 = next;   //回档
            }else{
                ListNode next = cur2.next;

                //cur2尾插
                if(result == null){
                    result = cur2;
                }else{
                    last.next = cur2;
                }

                last = cur2;   //更新最后一个结点

                cur2 = next;  //回档
            }

        }

        //当cur1或cur2两个表在合并过程中，一个表的元素全被转移到新表中，剩下的另一个表直接尾插
        if(cur1 == null){
            last.next =  cur2;
        }
        if(cur2 == null){
            last.next = cur1;
        }
        return result;
    }
}
