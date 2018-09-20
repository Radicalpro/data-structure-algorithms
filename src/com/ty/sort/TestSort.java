package com.ty.sort;

import java.util.Random;

/**
 * 测试类
 *
 * @author tianyi
 */
public class TestSort {
    public static void main(String[] args) {
        int max = 16;
        SortArray sortArray = new SortArray(max);
        for (int i = 0; i < max; i++) {
            long value = (new Random().nextInt(100));
            sortArray.insert(value);
        }

        //原始数据
        sortArray.display();
//        //冒泡
//        sortArray.bubbleSort();
//        sortArray.display();
//        //选择
//        sortArray.selectionSort();
//        sortArray.display();
//        //插入
//        sortArray.insertSort();
//        sortArray.display();
//        //希尔
//        sortArray.shellSort();
//        sortArray.display();
        //划分
//        int position = sortArray.partitionIt(0, max -1, 50);
//        System.out.println("划分的位置：" + position);

        //快速排序
        sortArray.quickSort(0, max - 1);
        sortArray.display();
    }
}
