package com.gyoge.itcs.misc.encryption;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Frequency {

    public static void main(String[] args) {
        new Scanner(System.in)
            .nextLine()
            .toLowerCase()
            .chars()
            .boxed()
            .filter(Character::isAlphabetic)
            .map(Character::toString)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
            .forEach((l, c) -> System.out.printf("%s: %d%n", l, c));
    }

}
