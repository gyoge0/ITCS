package com.gyoge.itcs.misc.pets;

import java.util.Objects;

@SuppressWarnings("all")
public class Cat extends Pet {

    @Override
    public void calculateAdoptionFee() {
        int fee= 0;
        switch (breed) {
            case "Ragamuffin" -> fee = 80;
            case "Domestic Shorthair" -> fee = 65;
        }
        fee += cuteness * 3;
        this.adoptionFee = fee;
    }

    /*
    pov java
     */

    private String furLength;

    public int getCuteness() {
        return cuteness;
    }

    public void setCuteness(int cuteness) {
        this.cuteness = cuteness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Cat cat = (Cat) o;
        return cuteness == cat.cuteness && Objects.equals(furLength, cat.furLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), furLength, cuteness);
    }

    @Override
    public String toString() {
        return "Cat{" +
            "furLength='" + furLength + '\'' +
            ", cuteness=" + cuteness +
            '}';
    }

    private int cuteness;

    public String getFurLength() {
        return furLength;
    }

    public void setFurLength(String furLength) {
        this.furLength = furLength;
    }

    public Cat(String name, int age, String breed, String furLength, int cuteness) {
        super(name, age, breed);
        this.furLength = furLength;
        this.cuteness = cuteness;

        cuteness += breed.equals("Ragamuffin") ? 2 : 0;
        cuteness = Math.min(age, 10);
    }


}
