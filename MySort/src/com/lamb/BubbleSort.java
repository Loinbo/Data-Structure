package com.lamb;

/**
 * Created by Loinbo
 * DATE:2019/5/15
 * TIME:15:08
 */

public class BubbleSort {

    /**
     * 普通冒泡：
     * 1.1 设置数组长度为N
     * 1.2 比较相邻两个数据大小，前 > 后,交换两个数
     * 1.3 从第0个数据遍历到第(N - 1)数，最大的数就沉到第(N - 1)个位置
     * 1.4 N = N - 1,如果 N != 0 , 重复 1.2-1.3 两步，否则排序完成
     */
    private static void bubbleSort1(int[] array, int N){
        int i,j;
        //共(N - 1)次循环
        for(i = 0; i < N; i++){
            //一层循环
            for(j = 1; j < N - i; j++){
                if(array[j - 1] > array[j]){
                    swap(array, array[j - 1] , array[j]);
                }
            }
        }

    }

    /**
     * 优化冒泡1.0：
     * 2.1 对普通冒泡进行优化，设置一个标志flag
     * 2.2 如果这一趟排序发生了交换 flag == true,否则 flag == false
     * 2.3 如果flag == false 就代表这组数已经有序了
     */
    private static void bubbleSort2(int[] array, int N){
        int i;
        int j = N;
        boolean flag = true;

        while(flag){
            flag = false;
            for(i = 1; i < j; i++){
                if(array[i - 1] > array[i]){
                    swap(array, array[i -1], array[i]);
                    flag = true;
                }
                j--;
            }
        }
    }

    /**
     * 优化冒泡2.0
     * 3.1 假设一组数有50个元素，仅前10个元素无序，后40个数都已经排好序
     * 3.2 第一趟遍历完毕，发生交换的最后一个位置必定 < 10,并且这个位置之后的数据都已经有序
     * 3.3 定义一个标志flag记录下最后这个位置，下一次只要从数组头遍历到这个位置就可以了
     */
    private static void bubbleSort3(int[] array, int N){
        int i,j;
        int flag = N;
        while(flag > 0){
            j = flag;
            flag = 0;
            for(i = 1; i < j; i++){
                if(array[i - 1] > array[i]){
                    swap(array, array[i - 1], array[i]);
                    flag = i;
                }
            }
        }
    }

    //把最小的数冒泡到最前面
    private static void bubbleSort(int[] array){

        for(int i = 0; i < array.length; i++){
            boolean flag = true;
            //有序[0,i)   无序[i,array.length - 1)
            //要把最小的数冒泡的最前面，需要从后往前冒泡
            for(int j = array.length - 1; j > i; j--){
                if(array[j - 1] > array[j]){
                    swap(array, array[j - 1], array[j]);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    //把最大的数冒泡到最后面
    private static void bubbleSort4(int[] array) {
        // 外部的循环表示的是，冒泡的次数
        // 一次冒泡可以解决一个数的问题
        // 一共需要 array.length
        // 更优化的方式是 array.length - 1
        for (int i = 0; i < array.length; i++) {
            // 每次冒泡之前，假设数组已经有序
            boolean sorted = true;

            // 一次冒泡的过程，保证最大的数被推到最后去
            for (int j = 0; j <= array.length - 2 - i; j++) {
                // 保证相邻的两个数，最大的在后面
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;

                    sorted = false;
                }
            }

            // 如果过程一次交换都没发生过，假设有序成立
            if (sorted == true) {
                break;
            }
        }
    }

    private static void swap(int[] array, int a, int b){
        int t = a;
        a = b;
        b = t;
    }
}
