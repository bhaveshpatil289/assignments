package com.wipro.Assignments;

//MergeSort implementation
public class MergeSort implements SortingStrategy {
 @Override
 public void sort(int[] arr) {
     if (arr.length > 1) {
         // Merge sort the first half
         int[] firstHalf = new int[arr.length / 2];
         System.arraycopy(arr, 0, firstHalf, 0, arr.length / 2);
         sort(firstHalf);


         // Merge sort the second half
         int secondHalfLength = arr.length - arr.length / 2;
         int[] secondHalf = new int[secondHalfLength];
         System.arraycopy(arr, arr.length / 2, secondHalf, 0, secondHalfLength);
         sort(secondHalf);


         // Merge firstHalf and secondHalf into arr
         merge(firstHalf, secondHalf, arr);
     }
 }


 private void merge(int[] firstHalf, int[] secondHalf, int[] arr) {
     int i = 0, j = 0, k = 0;
     while (i < firstHalf.length && j < secondHalf.length) {
         if (firstHalf[i] < secondHalf[j]) {
             arr[k++] = firstHalf[i++];
         } else {
             arr[k++] = secondHalf[j++];
         }
     }


     while (i < firstHalf.length) {
         arr[k++] = firstHalf[i++];
     }


     while (j < secondHalf.length) {
         arr[k++] = secondHalf[j++];
     }
 }
}

