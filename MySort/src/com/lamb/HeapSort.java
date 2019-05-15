package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/14
 * TIME:9:21
 */

//堆排序
public class HeapSort {

    //1.建堆
    private static void createHeap(int[] array){
        //1.堆整棵树建堆，需要左右子树已经是堆，对根结点向下调整
        //2.从最后一个非叶子结点一直到0，不断向下调整
        for(int i = (array.length - 2 ) / 2; i >= 0; i--){
            heapify(array , array.length , i);
        }
    }

    //2.向下调整 / 堆化
    private static void heapify(int[] array , int size ,int index){
        //1.判断要调整的结点是否为叶子结点（判断左子树的下标越界）
        if(2 * index + 1 > array.length){
            return;
        }
        while( 2 + index + 1 < size) {
            //2.找最大的孩子（没有右子树，最大孩子就是左孩子；否则，比较左右孩子并且选出最大的孩子）
            int max = 2 * index + 1;    //max保存最大数的下标
            if (max + 1 < size && array[ max + 1] > array[max]) {
                max = 2 * index + 2;
            }
            //3.比较双亲的值和最大孩子的值，如果双亲大，停止；否则交换两者的值，并以新结点开始继续向下调整
            if(array[max] > array[index]){
                swap(array , index , max);

                index = max;
            }
            else {
                break;
            }
        }
    }

    private static void heapify1(int[] array , int index){
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = left;  //用于保存最大值下标
        //1.判断叶子结点
        if(left >= array.length){
            return;
        }
        //2.找最大孩子
        if(right < array.length && array[right] > array[left]){
            max = right;
        }
        //3.比较双亲和孩子结点
        if(array[index] >= array[max]){
            return;  //双亲大，停止
        }
        //孩子大，交换
        swap(array , index , max);
        //4.继续向下调整
        heapify1(array , max);
    }

    //实现交换函数
    private static void swap(int[] array, int index, int max) {

        int tmp = array[index];
        array [index] = array[max];
        array[max] = tmp;
    }

    //3.堆排序
    private static void heapSort(int[] array){
        //1.建好一个大堆
        createHeap(array);

        //2.采用减治算法，每次选择一个无序部分最大数交换到无序部分的最后面
        for(int  i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            heapify(array , array.length - 1 - i, 0);
        }
    }
}
