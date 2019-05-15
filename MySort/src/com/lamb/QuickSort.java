package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/14
 * TIME:9:47
 */

public class QuickSort {

    private static void quickSortInner(int[] array , int left , int right){

        //1.停止条件：size == 1 && size == 0
        if(left == right){
            return;
        }
        if(left > right){
            return;
        }

        //2.选基准值array[right]---此处选取边界值array[left] 或 arry[right]作为基准值
        /**
         * 1.1 随机法
         * 1.2 取边界值(最左边的值或最右边的值)
         * 1.3 三数取中法
         */
        int pivot = medianOfThree(array, left, right);  //找基准值
        swap(array, pivot, right);  //将基准值放在最右边

        //3.划分三个区间
        int pivotIndex = Partition1(array, left, right);

        //4.分治算法
        quickSortInner(array,left,pivotIndex - 1);  //处理比基准值小的区间
        quickSortInner(array, pivotIndex +1, right);    //处理比基准值大的区间
    }

    //实现基准值的三数取中法
    private static int medianOfThree(int[] array, int left, int right) {
        int mid = left + (left + right) / 2;
        if(array[left] > array[right]){
            if(array[left] < array[mid]){
                return left;
            } else if(array[mid] > array[right]){
                return mid;
            } else {
                return right;
            }
        } else {
            if (array[right] < array[mid]) {
                return right;
            } else if (array[mid] > array[left]) {
                return mid;
            } else {
                return left;
            }
        }
    }

    /**
     * 做Partition分段
     * 1.Hover
     * 2.挖坑法
     * 3.前后下标法
     */

    /**
     * 1.Hover法
     * 1.1 begin = left, end = right, 选取最右边的数作为基准值
     * 1.2 begin ++ 由前往后找比它大的数，将其交换到end的右边
     * 1.3 end -- 由后往前找比它小的数，将其放在begin的左边
     * 1.4 分治算法重复2，3步为左右两个小区间进行排序，直到begin == end时停止,将pivot交换到中间来并返回元素下标
     */
    private static int Partition1(int[] array, int left, int right){
        int begin = left;
        int end = right;
        int pivot = array[right];   //选最右边的数作为基准值

        while(begin < end){
            //array[begin] <= pivot
            while(begin < end && array[begin] <= pivot){
                begin ++;
            }
            //array[end] >= pivot
            while(begin < end && array[end] > pivot){
                end --;
            }
            swap(array, begin, end);
        }

        //将pivot交换到中间
        swap(array, begin, right);
        return begin;
    }

    /**
     *2.挖坑法
     * 2.1 begin = left, end = right, 将基准值挖出形成第一个坑
     * 2.2 end --由后往前找比它小的数，找到后挖出这个数填到前一个array[begin]坑中
     * 2.3 begin ++由前往后找比它大的数找到后也挖除这个数填到前一个array[end]坑中
     * 2.4 分治算法重复2，3步，直到begin == end时停止，将基准值填入array[begin]中并返回元素下标
     */
    private static int Partition2(int array[], int left, int right) //返回调整后基准数的位置
    {
        int begin = left, end = right;
        int pivot = array[left]; //选最左边的元素作为基准值，同时让基准值成为第一个坑
        while (begin < end)
        {
            // 从右向左找小于pivot的数来填array[begin]
            while(begin < end && array[end] >= pivot)
                end--;
            if(begin < end)
            {
                array[begin] = array[end]; //将array[end]填到array[begin]中，array[end]就形成了一个新的坑
                begin++;
            }

            // 从左向右找大于或等于pivot的数来填array[j]
            while(begin < end && array[begin] < pivot)
                begin++;
            if(begin < end)
            {
                array[end] = array[begin]; //将array[begin]填到array[end]中，array[begin]就形成了一个新的坑
                end--;
            }
        }
        //begin等于end退出,将pivot填到这个坑中
        array[begin] = pivot;
        return begin;
    }

    /**
     * 3.前后下标法
     * 3.1 选最右边的数作为基准值array[right]
     * 3.2 定义前后下标遍历这组数, < array[right]的放左边 ,  > array[right]的放右边
     * 3.3 当数组遍历完毕，将基准值array[right]交换到中间并返回元素下标
     */
    private static int Partition3(int[] array, int left, int right){
        int begin = left;
        for(int i = left; i < right; i ++){
            if(array[i] < array[right]){
                swap(array, begin, i);
                begin ++;
            }
        }
        swap(array, begin, right);
        return begin;
    }

    private static void swap(int[] array, int begin, int end) {
        int t = array[begin];
        array[begin] = array[end];
        array[end] = t;
    }

    //快速排序
    private static void quickSort(int[] array){
        quickSortInner(array, 0, array.length - 1);
    }
}
