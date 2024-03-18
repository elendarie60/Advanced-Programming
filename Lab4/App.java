package com.carpooling;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        // Generate random persons and destinations
        Random random = new Random();
        Stream<Person> personsStream = Stream.generate(() ->
                new Person(generateRandomName(), random.nextInt(50) + 18, generateRandomDestination()));
        // Filter drivers and passengers
        LinkedList<Person> drivers = personsStream.filter(person -> random.nextBoolean())
                .collect(Collectors.toCollection(LinkedList::new));
        Set<Person> passengers = personsStream.filter(person -> !drivers.contains(person))
                .collect(Collectors.toCollection(TreeSet::new));
        // Print sorted drivers by age
        System.out.println("Drivers (sorted by age):");
        drivers.stream().sorted((p1, p2) -> p1.getAge() - p2.getAge()).forEach(System.out::println);
        // Print sorted passengers by name
        System.out.println("\nPassengers (sorted by name):");
        passengers.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(System.out::println);
    }


    // Generate random name
    private static String generateRandomName() {
        return RandomStringUtils.randomAlphabetic(5, 10);
    }

    // Generate random destination
    private static String generateRandomDestination() {
        String[] destinations = {"City A", "City B", "City C", "City D", "City E"};
        return destinations[new Random().nextInt(destinations.length)];
    }
}
