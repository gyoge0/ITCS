package com.gyoge.itcsmisc;

import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

@SuppressWarnings("SpellCheckingInspection")
public class FilePractice {

    public static void main(String[] args) {
        fileTestOne();
        fileTestTwo();
        fileTestTwoExtension();
    }

    public static void fileTestOne() {
        try (Scanner scanner = new Scanner(new File(
            "src/main/resources/FilePractice/filetest1.txt"
        ))) {
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    public static void fileTestTwo() {
        try (Scanner scanner = new Scanner(new File(
            "src/main/resources/FilePractice/filetest2.txt"
        ))) {
            int sum = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                sum += scanner.nextInt();
                scanner.nextLine(); // remove \n after nextInt()
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }

    public static void fileTestTwoExtension() {
        try (Scanner scanner = new Scanner(new File(
            "src/main/resources/FilePractice/filetest2.txt"
        ))) {
            while (scanner.hasNextLine()) {
                System.out.printf("%s: %s%n", scanner.nextLine(), scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        }
    }
}
