package com.gyoge.itcs.misc.encryption;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SuppressWarnings("ClassCanBeRecord")
public class PasswordCipher {

    private final String pass;

    public PasswordCipher(String pass) {
        this.pass = pass.toLowerCase();
    }

    private Map<Character, Character> getMap() {
        Map<Character, Character> map = new HashMap<>();
        List<Character> cipher = new ArrayList<>();

        pass
            .toLowerCase()
            .chars()
            .distinct()
            .boxed()
            .map(c -> (char) (int) c)
            .filter(Character::isAlphabetic)
            .forEach(cipher::add);

        IntStream
            .range(97, 122)
            .boxed()
            .map(i -> (char) (int) i)
            .filter(i -> !cipher.contains(i))
            .forEach(cipher::add);

        IntStream
            .range(97, 122)
            .boxed()
            .map(i -> (char) (int) i)
            .forEach(i -> map.put(i, cipher.get(i % 97)));

        return map;

    }

    public String encrypt(String plaintext) {
        return plaintext
            .toLowerCase()
            .chars()
            .boxed()
            .map(c -> (char) (int) c)
            .map(c -> getMap().getOrDefault(c, c))
            .map(Object::toString)
            .collect(Collectors.joining(""));
    }

    public String decrypt(String ciphertext) {
        return ciphertext
            .toLowerCase()
            .chars()
            .boxed()
            .map(c -> (char) (int) c)
            .map(c -> (
                getMap()
                    .entrySet()
                    .stream()
                    .map(e -> Map.entry(e.getValue(), e.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
            ).getOrDefault(c, c))
            .map(Object::toString)
            .collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password: ");
        PasswordCipher passwordCipher = new PasswordCipher(scanner.nextLine());

        System.out.println("Enter text to encrypt: ");
        System.out.println("Ciphertext = " + passwordCipher.encrypt(scanner.nextLine()));

        System.out.println("Enter text to decrypt: ");
        System.out.println("Ciphertext = " + passwordCipher.decrypt(scanner.nextLine()));
    }
}
