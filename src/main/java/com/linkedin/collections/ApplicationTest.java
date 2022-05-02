package com.linkedin.collections;

import java.util.List;

public class ApplicationTest {
    public static void main(String[] args) {
        Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room westminister = new Room("Westminister", "Premiere Room", 4, 175.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);
        Room victoria = new Room("Victoria", "Suite", 5, 225.0);
        Room manchester = new Room("Manchester", "Suite", 5, 225.0);

        Guest john, maria, sonia, siri, bob;


        john = new Guest("John", "Doe", false);
        john.getPreferredRooms().addAll(List.of(oxford, victoria, manchester));

        maria = new Guest("Maria", "Doe", true);
        maria.getPreferredRooms().addAll(List.of(cambridge, oxford));

        sonia = new Guest("Sonia", "Doe", true);
        sonia.getPreferredRooms().addAll(List.of(cambridge));

        siri = new Guest("Siri", "Doe", true);

        bob = new Guest("Bob", "Doe", false);




    }
}
