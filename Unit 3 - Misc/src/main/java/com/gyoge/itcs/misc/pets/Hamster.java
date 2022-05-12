package com.gyoge.itcs.misc.pets;

import java.util.Objects;
import java.util.Random;

@SuppressWarnings("all")
public class Hamster extends Pet {

    @Override
    public void calculateAdoptionFee() {
        int fee = 0;

        switch (this.breed) {
            case "Roborovski Dwarf" -> fee = 10;
            case "Fancy Bear" -> fee = 7;
        }

        if (eyeColor.equals("red") || eyeColor.equals("pink")) {
            fee += 2;
        }

        this.adoptionFee = fee;

    }

    /*
    pov java
    */

    public String getEyeColor() {
        return eyeColor;
    }

    @Override
    public String toString() {
        return "Hamster{" +
            "eyeColor='" + eyeColor + '\'' +
            ", speed=" + speed +
            '}';
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
        Hamster hamster = (Hamster) o;
        return Objects.equals(eyeColor, hamster.eyeColor) && Objects.equals(speed,
            hamster.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eyeColor, speed);
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    private String eyeColor;

    private static final Random random = new Random();

    public Hamster(String name, int age, String breed, String eyeColor) {
        super(name, age, breed);
        this.eyeColor = eyeColor;
        this.speed = random.nextDouble(3.0, breed.equals("Roborovski Dwarf") ? 10.0 : 6.0);
    }

    private Double speed;

}
