package com.wipro.Assignments;

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public Pair<U, T> reverse() {
        return new Pair<>(second, first);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println("Original Pair: (" + pair.getFirst() + ", " + pair.getSecond() + ")");
        
        Pair<String, Integer> reversedPair = pair.reverse();
        System.out.println("Reversed Pair: (" + reversedPair.getFirst() + ", " + reversedPair.getSecond() + ")");
    }
}




