package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/7
 * TIME:18:34
 */

/**
 * 选择排序
 * 1. 每次选一个最大的数，放到无序部分的最后
 * 2. 需要选n或n - 1次
 * 无序[0 , array.length - i)   有序[array.length - i , array.length)
 * 3. 在无序部分选最大的一个数，找出其下标
 * 4. 把最大的数交换到无序区间的最后
 */
public class SelectSort {

    //选择排序，直接遍历
    private static void selectSort(int[] array){

        //选出一个最大数，将其放在无序部分的最后
        for(int i = 0; i < array.length; i++){
            int max = 0;//用来记录最大的值的下标

            //无序[0 , array.length - i)
            //有序[array.length - i ,array.length)
            for(int j = 1; j < array.length - i; j++){
                //选出最大的数
                if(array[max] < array[j]){
                    max = j;
                }

                //将最大的数换到无序部分的最后面
                int tmp = array[max];
                array[max] = array[array.length - i - 1];
                array[array.length - i - 1] = tmp;
            }
        }
    }

    //选择排序，递归
    private static void selectSortRecursion(int[] array , int size){
        int max = 0;  //用来记录最大数的下标

        for(int i = 0; i < array.length; i++){
            //把最大的数换到无序部分的最后面
            if(array[i] > array[max]){
                max = i;
            }
        }

        int tmp = array[max];
        array[max] = array[size - 1];
        array[size - 1] = tmp;

        selectSortRecursion(array , size - 1);
    }
}
