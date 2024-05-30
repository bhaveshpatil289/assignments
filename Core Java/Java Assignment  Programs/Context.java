package com.wipro.Assignments;

//Context class
public class Context {
 private SortingStrategy strategy;


 public void setStrategy(SortingStrategy strategy) {
     this.strategy = strategy;
 }


 public void sort(int[] arr) {
     strategy.sort(arr);
 }
}



