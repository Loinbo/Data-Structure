package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/11
 * TIME:20:11
 */

/**
 * 复杂链表的复制
 *
 * 基本思路：先把元素复制出来，再处理random
 * 先遍历原链表的每一个结点，新建新结点，不处理random,只保留元素结构
 * 再遍历处理random
 *
 * 步骤：
 * 1.遍历原链表的每一个结点，复制新结点，插到原链表的后面
 * 2.遍历原链表的每个新结点，进行新结点random的设置
 * cur.next.random = cur.random.next;
 * 3.把一天链表拆分成原链表和新链表
 */
public class CopyRandomList {

    class Node {

        public int val;
        public Node next;
        public Node random;  //保存链表中任意结点的引用或者==null

        public Node() {}

        public Node(int v) {
            val = v;
        }
    };

    public Node copyRandomList(Node head) {

        //遍历原链表的每一个结点，创建新结点，把新结点插到原链表的后面
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);  //创建新结点对其赋值

            //把newNode插到cur后面
            newNode.next = cur.next;  //将新结点的next指向老结点的next
            cur.next = newNode;   //让老结点指向新结点

            //cur走向下一个原链表的结点
            cur = cur.next.next;
        }

        //设置新结点的random
        cur = head;
        while(cur != null){
            Node newNode = cur.next;
            if(cur.random == null){
                newNode.random = null;
            } else {
                newNode.random = cur.random.next;
            }
            //cur走到下一个老结点
            cur = cur.next.next;
        }

        //拆
        cur = head;
        Node result = head.next;
        while(cur != null){
            Node newNode = cur.next;
            cur.next = newNode.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;  //画三角，将链表拆分
            }
            cur = cur.next;
        }
        return  result;
    }
}
