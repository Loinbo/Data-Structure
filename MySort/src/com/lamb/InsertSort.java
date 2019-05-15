package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/7
 * TIME:8:40
 */

/**
 * 直接插入排序
 */
public class InsertSort {

    //遍历查找,顺序表，给定pos做插入
    private static void insertSort1(int[] array){
        //有序[0,i)
        //无序[i,array.length)
        for(int i = 0; i < array.length; i++){
            int j;
            //1.从后往前遍历
            for(j = i - 1; j >= 0 && array[i] < array[j]; j--){
            }

            //给定pos的位置，j+1即要插入的位置
            int pos = j + 1;
            int key = array[i];
            //从后往前移动数据
            for(int k = i; k > pos; k--){
                array[k] = array[k - 1];
            }
            array[pos] = key;
        }
    }

    //遍历排序,不给定pos
    private static void insertSort2(int[] array){
        for(int i = 0; i <array.length; i++){
            int key = array[i];
            int j = i - 1;
            for(; j >= 0 && key < array[j]; j--){
                array[j + 1] = array[j];  //j前移
            }
            array[j + 1] = key;
        }
    }

    //二分查找,给定pos
    private static void insertSort3(int[] array){
        for(int i = 0; i < array.length; i++){
            int left = 0;
            int right = i;
            int key = array[i];
            int mid = left + ( right + left ) / 2;
            //1.找合适的位置
            while(left < right){
                //判断key与mid的值大小
                if(key == array[mid]){
                    left = mid + 1; //调整left的值，left之前的数都已有序
                } else if(key < array[mid]){
                    //有序[left,mid)
                    //无序[mid,right)
                    right = mid;    //key值小，调整mid和right位置
                } else {
                    left = mid + 1;
                }
            }
            //2.把当前值插入到合适的位置
            int pos = left;
            for(int k = i; k > pos; k--){
                array[k] = array[k - 1];	//数据统一后移
            }
            array[pos] = key;
        }
    }
}
