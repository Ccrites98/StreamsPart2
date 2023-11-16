package com.pluralsight.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        //nightmare dinner party
        people.add(new Person("Charles", "Manson", 83));
        people.add(new Person("Jim", "Jones", 47));
        people.add(new Person("David", "Koresh", 33));
        people.add(new Person("Marshall", "Applewhite", 65));
        people.add(new Person("Shoko", "Asahara", 63));
        people.add(new Person("Joseph", "Di Mambro", 68));
        people.add(new Person("Luc Jouret", "Jouret", 47));
        people.add(new Person("Sun Myung", "Moon", 92));
        people.add(new Person("Warren", "Jeffs", 65));
        people.add(new Person("Roch", "Thériault", 63));
        Scanner scanner = new Scanner(System.in);
        //Stream for youngest
        int oldestAge = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(Integer.MIN_VALUE);
//Stream for oldest
        int youngestAge = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(Integer.MAX_VALUE);

        System.out.println("Oldest Age: " + oldestAge);
        System.out.println("Youngest Age: " + youngestAge);
//give the average below
        double averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println("Average: " + averageAge);
        //find the person by name
        System.out.print("Enter a name: ");
        String searchName = scanner.nextLine();
        List<Person> matchingPeople = people.stream()
                .filter(person -> person.firstName.equalsIgnoreCase(searchName) || person.lastName.equalsIgnoreCase(searchName))
                .collect(Collectors.toList());
                    //be kind and insult the user, always.
        if (matchingPeople.isEmpty()) {
            System.out.println("Nobody like that out here. Get lost scrub.");
        } else {
            System.out.println("Here they is: ");
            matchingPeople.forEach(person -> System.out.println(person.firstName + " " + person.lastName));
        }}}
