package com.lamb;

import java.util.Random;

/**遍历查找、二分查找、冒泡排序、递归
 * Created by Loinbo
 * DATE:2019/4/8
 * TIME:15:40
 */

public class MySearch {
    /**
     * 遍历查找O(n)
     * 基本思想：将整个数组从头开始遍历，匹配要查找的元素
     */
    private static int search(int[] array, int v) {
        for (int i = 0; i < array.length; i++) {
            if (v == array[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 二分查找：O(log(n))
     * 前提：数组本身就有序
     * 基本思想：用要查找的元素value和数组的中间元素mid进行比较
     * 1.定义三个变量：left--区间左边界,right--区间右边界
     * 2.int mid = left+(right - left)/2
     * 3.value=mid  返回mid
     * 4.value<mid   right = mid
     * 5.value>array[mid]  left = mid+1
     * 6.当right = left+1 区间内只有一个数
     * 7.当right = left  区间内没有数
     */
    //[left,right] [0,9]
    //[left,right) [0,10)
    //当right = left+1 区间内只有一个数[9，10)
    //当right = left  区间内没有数 [ 10,10]

     public static int BinarySearch(int[] array, int value) {

         //[left,right)
         int left = 0;
         int right = array.length - 1;
         //区间内还有一个数需要查找，没有数就可以停了
         while (left <= right) {
             //[10,10]区间内还有一个数
             int mid = left+(right - left) / 2;//考虑数组越界
             if (array[mid] < value) {
                 left = mid + 1;
             } else if (array[mid] > value)
                 right = mid - 1;
             else
                 return mid;
         }

         return -1;
     }

    /**
     * 冒泡排序：时间复杂度O(n^2)
     * 基本思想:如果一次交换都不做，证明是有序的数组
     * 每次冒泡前，都假设有序：  boolean sorted = true;
     * 每一次冒泡过程，都要保证最大的数能被循环置换到最后
     * 经过一次冒泡过程，如果此过程中一次交换都没发生过，假设有序就成立
     * if(sorted == true){break};
     */
    private static void bubbleSort(int[] array) {

        //外部循环表示冒泡的次数，共array.length次
        // 更优化的方式是 array.length - 1，最后一次不用再置换
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;  //每次冒泡之前，假设数组已经有序

            // 一次完整循环，大的数有序的放在后面
            for (int j = 0; j <= array.length - 2 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int s = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = s;

                    sorted = false;
                }
            }

            // 如果过程一次交换都没发生过，假设有序成立
            if (sorted == true) {
                break;
            }
        }
    }

    /**
     *递归函数
     */

    // 计算阶乘递归Factorial的时间复杂度O(n)
    long Factorial(int N) {
        return N < 2 ? N : Factorial(N-1) * N;
    }//f(n) = n

    // 计算斐波那契递归Fibonacci的时间复杂度O(2^n) --求树的最长边
    long Fibonacci(int N) {
        return N < 2 ? N : Fibonacci(N-1)+Fibonacci(N-2);
    }

    private static int[] createArray(int size) {
        Random rand = new Random(20190330);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }

        return array;
    }

    private static void test(int size) {
        System.out.format("数据规模: %d 万\n", size / 10000);
        int[] array = createArray(size);
        long s, e;
        double ms;

        s = System.nanoTime();
        search(array, size + 1);
        e = System.nanoTime();
        ms = (e - s) * 1.0 / 1000 / 1000;
        System.out.format("遍历查找耗时: %.3f 毫秒\n", ms);

        s = System.nanoTime();
        bubbleSort(array);
        e = System.nanoTime();
        ms = (e - s) * 1.0 / 1000 / 1000;
        System.out.format("冒泡排序耗时: %.3f 毫秒\n", ms);

        s = System.nanoTime();
        BinarySearch(array, size + 1);
        e = System.nanoTime();
        ms = (e - s) * 1.0 / 1000 / 1000;
        System.out.format("二分查找耗时: %.3f 毫秒\n", ms);
    }


    public static void main(String[] args) {
        //test(2 * 10000);
        //test(8 * 10000);
        MyArrayList arrayList = new MyArrayList(10);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(3);
        arrayList.pushFront(10);
        arrayList.pushFront(20);
        arrayList.pushFront(30);
        arrayList.add(100, 3);
        arrayList.add(200, 4);
        arrayList.add(300, 5);
        arrayList.add(300, 5);
        arrayList.add(300, 5);
        arrayList.popBack();
        arrayList.popBack();
        arrayList.popBack();
        arrayList.popFront();
        arrayList.popFront();
        arrayList.popFront();
        arrayList.remove(0);
        arrayList.remove(0);
        arrayList.remove(0);
    }


}
