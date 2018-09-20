package com.ty.sort;

/**
 * 数组类
 *
 * @author tianyi
 */
public class SortArray {

    /**
     * 需排序的数组
     */
    private long[] theArray;

    /**
     * 数据当前下标
     */
    private int cIndex;

    /**
     * 构造函数
     *
     * @param max
     */
    public SortArray(int max) {
        theArray = new long[max];
        cIndex = 0;
    }

    /**
     * 插入数据
     *
     * @param value
     */
    public void insert(long value) {
        theArray[cIndex] = value;
        cIndex++;
    }

    /**
     * 展示数据
     */
    public void display() {
        for (int i = 0; i < cIndex; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    /**
     * 交换
     */
    public void swap(int front, int after) {
        long temp = theArray[after];
        theArray[after] = theArray[front];
        theArray[front] = temp;
    }

    /**
     * 冒泡排序
     * 比较次数：O(N*(N-1)/2)
     */
    public void bubbleSort() {
        System.out.println("bubbleSort");
        for (int i = cIndex - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (theArray[j] > theArray[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * 选择方法排序
     * 比较次数：O(N*(N-1)/2)
     * 交换次数比冒泡低
     */
    public void selectionSort() {
        System.out.println("selectionSort");
        for (int i = 0; i < cIndex - 1; i++) {
            for (int j = i + 1; j < cIndex; j++) {
                if (theArray[i] > theArray[j]) {
                    swap(i, j);
                }
            }
        }
    }

    /**
     * 插入排序
     * 比较次数：O(N*(N-1)/4)
     */
    public void insertSort() {
        int in, out;
        System.out.println("insertSort");
        for (out = 1; out < cIndex; out++) {
            long temp = theArray[out];
            in = out;
            while (in > 0 && theArray[in - 1] > temp) {
                theArray[in] = theArray[in - 1];
                --in;
            }
            theArray[in] = temp;
        }
    }

    /**
     * 希尔排序
     * 比较次数：O(N(2^3))
     */
    public void shellSort() {
        System.out.println("shellSort");
        int in, out;
        long temp;

        int h = 1;
        while (h < cIndex / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (out = 1; out < cIndex; out++) {
                temp = theArray[out];
                in = out;

                while (in > h - 1 && theArray[in - h] > temp) {
                    theArray[in] = theArray[in - h];
                    in -= h;
                }
                theArray[in] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 划分位置
     *
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    public int partitionIt(int left, int right, long pivot) {
        //左边指针
        int leftPtr = left - 1;
        //右边指针
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot) {
            }
            while (rightPtr > left && theArray[--rightPtr] > pivot) {
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    /**
     * 快速排序的划分
     *
     * @param left
     * @param right
     * @param pivot
     * @return
     */
    public int partitionItByQuickSort(int left, int right, long pivot) {
        //左边指针
        int leftPtr = left - 1;
        //右边指针
        int rightPtr = right;
        while (true) {
            while (theArray[++leftPtr] < pivot) {
            }
            while (rightPtr > 0 && theArray[--rightPtr] > pivot) {
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    /**
     * 快速排序
     * 比较次数：O(N*logN)
     *
     * @param left
     * @param right
     */
    public void quickSort(int left, int right) {
        if (right - left <= 0) {
        } else {
            long pivot = theArray[right];
            int partition = partitionItByQuickSort(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

}
