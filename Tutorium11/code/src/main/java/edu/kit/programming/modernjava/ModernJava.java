package edu.kit.programming.modernjava;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModernJava {
    public static void main(String[] args) {
        //records();
        //streams();
        switchExpressions();
    }

    private static void switchExpressions() {
        String input;
        try(Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
            Pattern format = Pattern.compile("(\\w+) (\\d+) (\\d+)");
            Matcher matcher = format.matcher(input);
            if (!matcher.matches()) {
                System.out.println("Invalid command");
                return;
            }
            String command = matcher.group(1);
            Integer a = Integer.parseInt(matcher.group(2));
            Integer b = Integer.parseInt(matcher.group(3));

            Integer result = switch (command) {
                case "add", "addiere", "ADD", "+" -> a + b;
                case "sub" -> a - b;
                case "mul" -> a * b;
                case "div" -> a / b;
                default -> null;
            };
            if (result == null)
                System.out.println("Invalid command");
            else
                System.out.println(result);
        }
    }

    private static void records() {
        Person person = new Person("Max", "Mustermann", 40);
        System.out.println(person);
    }

    public static void streams() {
        List<Integer> list = List.of(1, 3, 5, 6, 8);

        Optional<Integer> sum = list
                .stream()
                .filter(x -> x % 2 == 0)
                .reduce(Integer::sum);

        if(sum.isPresent())
            System.out.println("Sum of all even numbers: " + sum.get());
        else
            System.out.println("No even integers found");
    }
}
