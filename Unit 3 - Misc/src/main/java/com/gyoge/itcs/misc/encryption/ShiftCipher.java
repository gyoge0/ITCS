package com.gyoge.itcs.misc.encryption;

import java.util.Scanner;
import java.util.stream.Collectors;

@SuppressWarnings("ClassCanBeRecord")
public class ShiftCipher {

    private final int shift;

    public ShiftCipher(int shift) {
        this.shift = shift % 26;
    }

    public String encrypt(String plaintext) {
        return plaintext
                .toLowerCase()
                .chars()
                .boxed()
                .map(c -> (char) (int) c)
                .map(c -> !Character.isAlphabetic(c)
                        ? c // non-alphabetic characters are unchanged
                        : c + shift > 'z' // is it overflowing past 'z'?
                        ? c + shift - 26 // yes, subtract 26
                        : c + shift < 'a' // no, is it underflowing past 'a'?
                        ? c + shift + 26 // yes, add 26
                        : c + shift // no, it's fine
                )
                .map(c -> (char) (int) c)
                .map(Object::toString)
                .collect(Collectors.joining(""));

    }

    public String decrypt(String ciphertext) {
        return ciphertext
                .toLowerCase()
                .chars()
                .boxed()
                .map(c -> (char) (int) c)
                .map(c -> !Character.isAlphabetic(c)
                        ? c // non-alphabetic characters are unchanged
                        : c + (-shift) > 'z' // is it overflowing past 'z'?
                        ? c + (-shift) - 26 // yes, subtract 26
                        : c + (-shift) < 'a' // no, is it underflowing past 'a'?
                        ? c + (-shift) + 26 // yes, add 26
                        : c + (-shift) // no, it's fine
                )
                .map(c -> (char) (int) c)
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numerical shift: ");
        ShiftCipher shiftCipher = new ShiftCipher(scanner.nextInt());

        scanner.nextLine(); // flush out the \n

        System.out.println("Enter text to encrypt: ");
        System.out.println("Ciphertext = " + shiftCipher.encrypt(scanner.nextLine()));

        System.out.println("Enter text to decrypt: ");
        System.out.println("Ciphertext = " + shiftCipher.decrypt(scanner.nextLine()));
    }
}
