package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/16
 * TIME:15:59
 */

/**
 * 复杂链表的复制
 *
 * 基本思路：
 * 遍历链表的所有结点，复制结点并且仅保留元素结构，将其插进链表后面
 * 接下来再遍历原链表的每个结点，设置新结点的random
 * 最终将链表拆分成原链表和新链表
 *
 * 步骤：
 * 1.遍历原链表的每个结点，复制结点并将其插入到链表后面
 * 2.结点不指向空时，将cur.random指向新结点中与它value相同的结点，并将其赋给newNode.random
 * 3.用画三角的方式将原链表与拼接再其后的新链表拆分，将newNode指向newNode.next.next
 */

public class CopyRandomList {

    class RNode {

        public int val;
        public RNode next;
        public RNode random;  //保存链表中任意结点的引用或者==null

        public RNode() {
        }

        public RNode(int v) {
            val = v;
        }
    }

    RNode CopyRandomList(RNode head) {

        if (head == null) {
            return null;
        }

        //1.创建新结点，把新结点插到链表后面
        //遍历原链表的每个结点，复制结点并将其插入到链表后面
        RNode cur = head;
        while (cur != null) {

            RNode newNode = new RNode(cur.val);  //创建新结点给其赋值为原链表结点的val

            //把newNode插到cur后面
            newNode.next = cur.next;  //将新结点的next指向老结点的next
            cur.next = newNode;  //让老结点指向新结点

            //cur走向原链表的下一个结点
            cur = cur.next.next;
        }

        //2.设置random
        //结点不指向空时，将cur.random指向新结点中与它value相同的结点，并将其赋给newNode.random
        cur = head;
        while(cur != null){
            RNode newNode = cur.next;

            if(cur.random == null){
                newNode.random = null;
            } else {
                //令cur的random指向新结点它所对应的值
                newNode.random = cur.random.next;
            }

            //cur走向原链表的下一个结点
            cur = cur.next.next;
        }

        //3.拆分链表
        //用画三角的方式将原链表与拼接再其后的新链表拆分，将newNode指向newNode.next.next
        cur = head;
        RNode result = head.next; //要拆分成的新链表头结点为head.next
        while(cur != null){
            RNode newNode = cur.next;

            //画三角
            cur.next = newNode.next;
            if(newNode.next != null){
                newNode.next = newNode.next.next;
            }

            cur = cur.next.next;
        }
        return  result;
    }
}
