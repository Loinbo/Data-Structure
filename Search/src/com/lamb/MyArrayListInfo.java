package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/4/8
 * TIME:15:47
 */

public interface MyArrayListInfo {
    //实现对顺序表元素的增删

    /**
     * 把item插入到线性表前面
     */
    void pushFront(int item);

    /**
     * 把item插入到线性表最后
     */
    void pushBack(int item);


    /**
     * 把item插入index下标位置处，index后的数据后移
     */
    void add(int item,int index);

    /**
     * 删除最前面的数据
     */
    void popFront();

    /**
     * 删除最后的数据
     */
    void popBack();

    /**
     * 删除index下标位置处，index后的数据前移
     */
    void remove(int index);


}
