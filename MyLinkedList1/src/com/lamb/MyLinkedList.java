package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/8
 * TIME:19:36
 */

public class MyLinkedList {
    /**
     * 链表中的一个结点
     */
    public class Node {
        public int value;   // 保存的是有效数据
        public Node next;   // 下一个结点的线索（引用）

        Node(int v) {
            this.value = v;
            this.next = null;
        }
    }

    // 如果一个结点都没有， head == null
    private Node head;      // 保存链表中第一个结点的引用

    MyLinkedList() {
        this.head = null;
    }

    /**
     *头插O(1)
     * 1.新结点的next指向head
     * 2.将新结点赋给head
     */
    public void pushFront(int item) {
        Node node = new Node(item);
        node.next = this.head;
        this.head = node;
    }

    /**
     * 尾插
     * 判断链表是否为空
     * 1.为空，直接插入元素
     * 2.不为空，先找到最后一个结点，再将它的next指向新结点
     */

    //找最后一个结点O(n)
    private Node getLast(){
        Node cur = this.head;   //定义结点变量，初始值为head
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }

    //尾插
    public void pushBack(int item) {
        Node node = new Node(item);
        if(this.head == null){
            this.head = node;
        }
        Node last = getLast();
        last.next = node;
    }

    /**
     *头删O(1)
     */
    public void popFront() {
        if(this.head == null){
            throw new Error();
        }
        this.head = this.head.next;
    }

    /**
     * 尾删
     * 1.先判断链表长度：为空则异常，只有一个元素则直接删，元素个数>=2如下：
     * 2.链表中元素个数 >= 2时，将倒数第二个元素的next置为null
     */

    //获取倒数第二个元素O(n)
    private Node getLastSecond() {
        Node cur = this.head;
        while(cur.next.next != null){
            cur = cur.next;
        }
        return cur;
    }

    //尾删O(n)
    public void popBack() {
        if(this.head == null){
            throw new Error();
        }

        //链表中只有一个元素
        if(this.head.next == null){
            this.head = null;
        }else{
            Node lastSecond = getLastSecond();
            lastSecond.next = null;
        }
    }

    public void display(){  //打印所有结点
        Node cur = this.head;
        while(cur != null){
            System.out.format("%d--->",cur.value);
            cur = cur.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);

        list.display();
    }
}
