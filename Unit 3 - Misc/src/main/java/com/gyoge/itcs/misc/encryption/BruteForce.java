package com.gyoge.itcs.misc.encryption;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BruteForce {

    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        IntStream
            .range(1, 25)
            .boxed()
            .map(ShiftCipher::new)
            .map(i -> i.decrypt(s))
            .forEach(System.out::println);
    }
}