package com.gyoge.itcs.misc.produce;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import java.io.File;
import java.io.FileNotFoundException;

// ITCS Order Handler Lab Shell Code
@SuppressWarnings("all")
public class OrderHandler {

    // TODO: Declare and initialize an ArrayList of Order objects here
    ArrayList<Order> orderList = new ArrayList<Order>();


    /* TODO: This method should read the file given.
     * 		 The files should be in a subfolder called Sales in your project directory.
     *       Order objects will be created and added to the ArrayList.
     */
    public void readFile(String fileName) {
        try {
            Object q = new Scanner(new File("src/main/resources/Sales/" + fileName + ".txt"));

            Object w;
            Object e = "";
            while (((Scanner) q).hasNextLine()) {
                e = (String) e + ((Scanner) q).nextLine() + "\n";
            }

            Arrays.stream(((String) e).split("\\n\\n")).forEach(order -> {
                Object r = ((String) order).split("\n")[0];
                Object t = new ArrayList<String>();
                Object y = new ArrayList<Integer>();
                IntStream.range(0, ((String) order).split("\n").length).skip(1).filter(u -> {
                    try {
                        int i = Integer.parseInt(((String) order).split("\n")[u]);
                        return false;
                    } catch (Exception i) {
                        return true;
                    }
                }).forEach(o -> {
                    ((ArrayList<Object>) t).add(((String) order).split("\n")[o]);
                    ((ArrayList<Object>) y).add(
                        Integer.parseInt(((String) order).split("\n")[o + 1]));
                });
                orderList.add(new Order((String) r, (ArrayList<String>) t, (ArrayList<Integer>) y));
            });
        } catch (FileNotFoundException h) {
            h.printStackTrace();
        }
    }

    // TODO: Call the displayOrder method on all Order objects in the ArrayList
    public void displayOrders() {
        this.orderList.forEach(Order::displayOrder);
    }

    // TODO: Calculate and return the total revenue from all Orders in the ArrayList
    //       Just call the calculateRevenue method on each Order object and sum up the results
    public double calculateTotalRevenue() {
        final Object[] f = {0D};
        this.orderList.forEach(g -> {
            f[0] = ((double) f[0]) + g.calculateRevenue();
        });
        return ((double) f[0]);
    }

    // contains tester code
    public static void main(String[] args) {
        // Get file name and read file
        OrderHandler testHandler = new OrderHandler();
        Scanner s = new Scanner(System.in);
        System.out.println("Which file should be read? (do not include .txt extension)");
        testHandler.readFile(s.nextLine());

        // display the orders and calculate revenue
        System.out.println("\nOrders Read:");
        testHandler.displayOrders();
        System.out.println("\nTotal Revenue From Orders: ");
        System.out.println(testHandler.calculateTotalRevenue());
    }
}
