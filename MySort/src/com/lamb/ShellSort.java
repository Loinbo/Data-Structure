package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/7
 * TIME:17:54
 */

/**
 * 希尔排序
 * 1.先选定一个整数，把待排序文件中所有记录分成个几组，并对每一组内的记录进行排序。
 * 2.重复上述分组和排序的工作。直到=1时，所有记录在统一组内排好序。
 * 分组插排：分组的个数从大到小，直到等于1最终插入排序
 * 预排序：gap > 1
 * 插排：gap == 1
 * gap = gap / 3 + 1 或 gap = gap / 2
 */
public class ShellSort {

    private static void shellSortWithGap(int[] array, int gap){
        for(int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;    //用来卡每个分组的边界值，方便分组内的数进行交换
            for(; j >= 0 && key < array[j]; j = j-gap){
                array[j - gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    private static void shellSort(int[] array) {
        int gap = array.length;
        while(true){
            //gap = gap / 2;
            gap = gap / 3 + 1;

            shellSortWithGap(array , gap);

            //gap == 1时，最后一次排序完成有序排序
            if(gap == 1){
                break;
            }
        }
    }
}
