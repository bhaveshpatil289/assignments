package com.wipro.Assignments;

public class ArrayUtils {

    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices");
        }
        
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"apple", "banana", "orange", "grape", "kiwi"};
        
        // Swapping elements in Integer array
        System.out.println("Before swapping in Integer array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        swap(intArray, 0, 2);
        System.out.println("After swapping in Integer array:");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        
        // Swapping elements in String array
        System.out.println("Before swapping in String array:");
        for (String fruit : strArray) {
            System.out.print(fruit + " ");
        }
        System.out.println();
        swap(strArray, 1, 3);
        System.out.println("After swapping in String array:");
        for (String fruit : strArray) {
            System.out.print(fruit + " ");
        }
    }
}




