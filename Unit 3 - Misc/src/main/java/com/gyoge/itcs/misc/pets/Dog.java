package com.gyoge.itcs.misc.pets;

import java.util.Objects;

@SuppressWarnings("all")
public class Dog extends Pet {

    @Override
    public void calculateAdoptionFee() {
        int fee = 0;
        switch (breed) {
            case "Beagle" -> fee = 100;
            case "German Shepard" -> fee = 135;
        }
        fee += trainingHours * 5;
        this.fee = fee;
    }

    /*
    pov java
    */

    private boolean shedding;
    private int trainingHours;
    private int barkVolume;

    public boolean isShedding() {
        return shedding;
    }

    public void setShedding(boolean shedding) {
        this.shedding = shedding;
    }

    public int getTrainingHours() {
        return trainingHours;
    }

    public void setTrainingHours(int trainingHours) {
        this.trainingHours = trainingHours;
    }

    public int getBarkVolume() {
        return barkVolume;
    }

    public void setBarkVolume(int barkVolume) {
        this.barkVolume = barkVolume;
    }

    public Dog(String name, int age, String breed, boolean shedding, int trainingHours,
        int barkVolume) {
        super(name, age, breed);
        this.shedding = shedding;
        this.trainingHours = trainingHours;
        this.barkVolume = Math.max(Math.max(70, barkVolume), 115);

        this.trainingHours += this.breed.equals("German Shepard") ? 3 : 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
            "shedding=" + shedding +
            ", trainingHours=" + trainingHours +
            ", barkVolume=" + barkVolume +
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
        Dog dog = (Dog) o;
        return shedding == dog.shedding && trainingHours == dog.trainingHours
            && barkVolume == dog.barkVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shedding, trainingHours, barkVolume);
    }
}
