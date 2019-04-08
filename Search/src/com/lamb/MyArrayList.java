package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/8
 * TIME:15:51
 */

public class MyArrayList implements MyArrayListInfo {

    private int[] array;    // 保存数据的空间
    private int size;       // 保存有效数据个数

    MyArrayList(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     *头插O(n)
     * 1.需要移动size个元素
     * 2.为避免数据被覆盖，从最后一个元素开始移动
     * 3.循环范围：空间下标为基准 [size,1]   数据下标为基准 [size-1,0]
     * 4.array[空间] = array [数据]
     * 5.空间 = 数据+1
     */
    @Override
    public void pushFront(int item) {

        for(int i = this.size; i >= 1; i--){
            this.array[i] = this.array[i - 1];  //从最后一个元素开始移动
        }

        this.array[0] = item;
        this.size++;
    }

    /**
     * 尾插O(1)
     */

    @Override
    public void pushBack(int item) {
        this.array[this.size] = item;   //新元素直接放最后
        this.size++;
    }

    /**
     * 按下标位置插O(n)
     * 空间的下标 [this.size,inidex+1]  [size,index)
     * 数据的下标 [size -1,index]
     * array[空间] = array[数据]
     */
    @Override
    public void add(int item, int index) {
        if(index < 0 || index > this.size){
            throw new Error();   //越界
        }
        //index=0--头插   index=this.size--尾插

        for(int i = this.size - 1; i >= index; i++){
            this.array[i + 1] = this.array[i];   //从后往前遍历，数组元素后移i-->i+1
        }
        this.array[index] = item;
        this.size++;
    }

    /**
     * 头删O(n)
     * 1.一共要移size-1
     * 2.从前往后
     * 3.数据[1,size-1]   **空间[0,size-2]**
     */
    @Override
    public void popFront() {
        if(this.size == 0){
            throw new Error();
        }

        for(int i = 0; i < this.size - 1; i++){
            this.array[i] = this.array[i + 1];
        }
        this.array[--this.size] = 0;    //this.size--;
    }

    /**O(1)
     * 尾删
     */
    @Override
    public void popBack() {
        if(this.size == 0){
            throw new Error();
        }
        this.array[--this.size] = 0;

    }

    /**
     * 根据下标位置删O(n)
     *
     */

    @Override
    public void remove(int index) {
        if(index < 0 || index >= this.size){
            throw new Error();
        }
        if(this.size == 0){
            throw new Error();
        }

        //从下标位置起始
        for(int i = index ; i > this.size - 2 ; i--){     //注意：this.size-2
            this.array[i] = this.array[i+1];
        }
        this.array[--this.size] = 0;
    }

    /**
     * 扩容：保证数组容量够用O(n)
     * 基本思路：
     * 先判断数组容量是否够用：
     * 1.不够用将容量扩至原来的两倍
     * 2.将元素转移到扩容后的新数组中
     * 3.用新数组替代原数组
     */
    private void ensureCapacity() {
        if(this.size < this.array.length){
            return;    //够用无需扩容
        }

        //不够用则扩容至原来两倍
        int capacity = this.array.length*2;
        int [] newArray = new int[capacity];

        //转移元素
        for(int i = 0; i < this.size; i++){
            newArray[i] = this.array[i];
        }

        //替代原数组
        this.array = newArray;
    }

    /*
      简单来讲，扩容就好比找房子
      this.array-->住的老房子
      this.size-->房子里住的人
      搬家条件：this.size == this.array.length (不用考虑大于的情况)
      1.先找新房子，找原来的两倍大
      2.搬家
      3.this.array = 新房子的地址
      4.退掉老房子 (JVM自行处理)
     */
}
