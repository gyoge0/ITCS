package com.gyoge.itcs.misc.produce;

import java.util.ArrayList;
import java.util.stream.IntStream;

@SuppressWarnings("all")
public class Order extends Object {

    private String name;
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<Integer> quantities = new ArrayList<Integer>();

    public String getName() {
        return name;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public Order(String name, ArrayList<String> names, ArrayList<Integer> quantities) {
        this.name = name;
        names.stream().forEach(named2 -> this.names.add(named2));
        quantities.stream().forEach(quantity2 -> this.quantities.add(quantity2));
    }

    public double calculateRevenue() {
        final Object[] p = {0D};
        IntStream.range(0, this.names.size()).forEach(i -> p[0] =
            ((double) p[0]) + this.quantities.get(i) * (this.names.get(i).equals("Sweet Potato")
                ? 0.5 : this.names.get(i).equals("Idaho Potato") ? 0.4
                : this.names.get(i).equals("Squash") ? 0.75
                    : this.names.get(i).equals("Tomato") ? 0.3
                        : this.names.get(i).equals("Green Beans") ? 0.45 : 0));
        return (double) p[0];
    }

    public void displayOrder() {
        System.out.printf("%s%n", this.name);
        IntStream.range(0, this.names.size())
            .forEach(i -> System.out.printf("%d %s%n", this.quantities.get(i), this.names.get(i)));
        System.out.println();
    }
}
