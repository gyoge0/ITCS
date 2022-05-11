package com.gyoge.itcs.misc.pets;

import java.util.Objects;

@SuppressWarnings("unused")
public class Pet {

    protected String name;
    protected int age;
    protected String breed;

    protected int fee;

    public int getFee() {
        return fee;
    }
    /*
    pov java
    */

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Pet{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", breed='" + breed + '\'' +
            ", fee=" + fee +
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
        Pet pet = (Pet) o;
        return age == pet.age && fee == pet.fee && Objects.equals(name, pet.name)
            && Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, breed, fee);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    protected Pet(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public void calculateAdoptionFee() {
        fee = 15;
    }

}
