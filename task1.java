// Реализовать алгоритм сортировки слиянием(merge) и выборкой(selection).
// (Самое эффективное , это тзучить эти сортировки на Питоне , 
// и постораться написать их на java)

import java.util.Arrays;



public class task1 {

    public static int[] mergeSort(int[] list){
        int[] buffer1 = Arrays.copyOf(list, list.length);
        int[] buffer2 = new int[list.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, list.length);
        return result;
    }


    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }





    public static void selectionSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            int minIdx = list[i];
            int pos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < minIdx) {
                    pos = j;
                    minIdx = list[j];
                }
            }
            list[pos] = list[i];
            list[i] = minIdx;
        }
    }


    public static void main(String[] args) {

        int[] list = {12, 6, 4, 1, 15, 10};

        System.out.println(mergeSort(list));


        selectionSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
