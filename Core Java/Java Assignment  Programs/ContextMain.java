package com.wipro.Assignments;

import java.util.Arrays;

public class ContextMain {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("Original array: " + Arrays.toString(arr));


        // Sort using BubbleSort
        Context context = new Context();
        context.setStrategy(new BubbleSort());
        context.sort(arr);
        System.out.println("Array sorted using BubbleSort: " + Arrays.toString(arr));


        // Sort using MergeSort
        int[] arr2 = {5, 2, 8, 1, 9};
        context.setStrategy(new MergeSort());
        context.sort(arr2);
        System.out.println("Array sorted using MergeSort: " + Arrays.toString(arr2));
    }
}

