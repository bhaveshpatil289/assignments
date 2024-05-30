package com.wipro.Assignments;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class PersonDemo {
    private String name;
    private int age;

    public PersonDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class FunctionInterfacesExample {

    // Method accepting functions as parameters
    public static void operateOnPerson(PersonDemo person,
                                       Predicate<PersonDemo> predicate,
                                       Function<PersonDemo, PersonDemo> function,
                                       Consumer<PersonDemo> consumer,
                                       Supplier<PersonDemo> supplier) {
        // Check condition using Predicate
        if (predicate.test(person)) {
            // Apply transformation using Function
            PersonDemo modifiedPerson = function.apply(person);
            // Perform some action using Consumer
            consumer.accept(modifiedPerson);
        } else {
            // If condition not met, create a new Person using Supplier
            PersonDemo newPerson = supplier.get();
            // Perform some action using Consumer
            consumer.accept(newPerson);
        }
    }

    public static void main(String[] args) {
        PersonDemo person = new PersonDemo("Alice", 30);

        // Example usage of operateOnPerson method
        operateOnPerson(person,
                p -> p.getAge() >= 18, // Predicate to check if age is greater than or equal to 18
                p -> {                  // Function to transform person's name to uppercase
                    p.setName(p.getName().toUpperCase());
                    return p;
                },
                p -> System.out.println("Modified Person: " + p.getName() + " - " + p.getAge()), // Consumer to print modified person
                () -> new PersonDemo("Unknown", 0) // Supplier to create a new Person
        );
    }
}



