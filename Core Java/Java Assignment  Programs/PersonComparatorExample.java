package com.wipro.Assignments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class PersonComparatorExample {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Comparator using lambda expression to sort by age
        Comparator<Person> ageComparator = (p1, p2) -> p1.getAge() - p2.getAge();

        // Sorting the list of people by age
        people.sort(ageComparator);

        // Printing sorted list
        System.out.println("People sorted by age:");
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}




