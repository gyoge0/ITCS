package com.gyoge.itcs.misc.encryption;

import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Frequency {

    public static void main(String[] args) {
        new BufferedReader(new InputStreamReader(System.in))
            .lines()
            .collect(Collectors.joining(""))
            .toLowerCase()
            .chars()
            .boxed()
            .filter(Character::isAlphabetic)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
            .forEach((l, c) -> System.out.printf("%s: %d%n", l, c));
    }

}
