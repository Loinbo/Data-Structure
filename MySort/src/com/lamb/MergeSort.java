package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/15
 * TIME:15:09
 */

public class MergeSort {

    private static void mergeSortInner(int[] array, int low, int high, int[] extra){
        //1.判断终止条件(没有数||只有一个数)
        if(low >= high || low == high - 1){
            return;
        }

        //2.划分成两个有序区间
        int mid = low + (low + high) / 2;
        //分治算法处理两个小区间
        mergeSortInner(array, low, mid, extra);
        mergeSortInner(array, mid, high, extra);

        //3.合并两个区间为一个区间
        merge(array, low, mid, high, extra);

    }

    private static void merge(int[] array, int low, int mid, int high, int[] extra){
        //int[] extra = new int[high - low]
        int i = low;    //遍历[ low,mid )
        int j = mid;    //遍历[ mid,high )
        int x = 0;  //遍历extra

        while(i < mid && j < high){
            if(array[i] < array[j]){
                extra[x++] = array[i++];
            }
            if(array[i] > array[j]){
                extra[x++] = array[j++];
            }
            while(i < mid){
                extra[x++] = array[i++];
            }
            while(j < high){
                extra[x++] = array[j++];
            }
        }

        for(int k = low; k < high; k ++){
            array[k] = extra[k - low];
        }
    }

    private static void mergeSort(int[] array){

        //先开辟一个新的空间extra[]
        int[] extra = new int[array.length];

        mergeSortInner(array, 0, array.length - 1, extra);
    }
}

