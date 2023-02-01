package edu.kit.programming.modernjava;

public record Person(String firstname, String lastName, int age) {
    public boolean isAdult() {
        return age >= 18;
    }
}
