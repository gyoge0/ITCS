package com.gyoge.itcs.misc.pets;


import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

import java.io.File;
import java.io.FileNotFoundException;

import java.time.LocalDate;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class PetAdoptionEvent {

    private LocalDate eventDate = LocalDate.now();
    private Set<Pet> availablePets;
    private Set<Pet> adoptedPets;
    private int totalFees;
    private String shelterName;

    /*
    pov java
    */

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Set<Pet> getAvailablePets() {
        return availablePets;
    }

    public void setAvailablePets(Set<Pet> availablePets) {
        this.availablePets = availablePets;
    }

    public Set<Pet> getAdoptedPets() {
        return adoptedPets;
    }

    public void setAdoptedPets(Set<Pet> adoptedPets) {
        this.adoptedPets = adoptedPets;
    }

    public int getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(int totalFees) {
        this.totalFees = totalFees;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public PetAdoptionEvent(Set<Pet> availablePets, Set<Pet> adoptedPets, int totalFees,
        String shelterName) {
        this.availablePets = availablePets;
        this.adoptedPets = adoptedPets;
        this.totalFees = totalFees;
        this.shelterName = shelterName;
    }

    /* TODO: add methods - addPet, rehomePet,
     *        displayAvailablePets, displayAdoptedPets,
     *        requestCat, requestDog, requestHamster
     */
    public int rehomePet(String petName) {
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        Pet pet = availablePets
            .stream()
            .filter(p -> p.getName().equals(petName))
            .findFirst()
            .get();

        availablePets.remove(pet);
        adoptedPets.add(pet);
        pet.calculateAdoptionFee();
        totalFees += pet.getFee();
        return pet.getFee();
    }

    public void displayAvailablePets() {
        availablePets.forEach(System.out::println);
    }

    public void displayAdoptedPets() {
        adoptedPets.forEach(System.out::println);
    }

    public List<Pet> requestCat(String furLength) {
        return availablePets
            .stream()
            .filter(Cat.class::isInstance)
            .map(Cat.class::cast)
            .filter(c -> c.getFurLength().equals(furLength))
            .map(Pet.class::cast)
            .toList();
    }

    public List<Pet> requestDog(Boolean shedding) {
        return availablePets
            .stream()
            .filter(Dog.class::isInstance)
            .map(Dog.class::cast)
            .filter(d -> d.isShedding() == shedding)
            .map(Pet.class::cast)
            .toList();
    }

    public List<Pet> requestHamster(double speed) {
        return availablePets
            .stream()
            .filter(Hamster.class::isInstance)
            .map(Hamster.class::cast)
            .filter(h -> h.getSpeed() >= speed)
            .map(Pet.class::cast)
            .toList();
    }

    public Scanner getScanner(String fileName) {
        File myFile = new File(fileName);
        Scanner scan;

        try {
            scan = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
            return null;
        }

        excludeComments(scan);

        return scan;
    }

    public void processCats(String fileName) {
        Scanner scan = getScanner(fileName);

        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            if (!Objects.equals(text, "")) {
                int age = Integer.parseInt(scan.nextLine());
                String breed = scan.nextLine();
                String furLength = scan.nextLine();
                int cuteness = Integer.parseInt(scan.nextLine());
                availablePets.add(new Cat(text, age, breed, furLength, cuteness));
            }
        }
        scan.close();
    }

    public void processDogs(String fileName) {
        Scanner scan = getScanner(fileName);

        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            if (!Objects.equals(text, "")) {
                int age = Integer.parseInt(scan.nextLine());
                String breed = scan.nextLine();
                boolean shedding = Boolean.parseBoolean(scan.nextLine());
                int trainingHours = Integer.parseInt(scan.nextLine());
                int barkVolume = Integer.parseInt(scan.nextLine());
                availablePets.add(new Dog(text, age, breed, shedding, trainingHours, barkVolume));
            }
        }
        scan.close();
    }

    public void processHamsters(String fileName) {
        Scanner scan = getScanner(fileName);

        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            if (!Objects.equals(text, "")) {
                int age = Integer.parseInt(scan.nextLine());
                String breed = scan.nextLine();
                String eyeColor = scan.nextLine();
                availablePets.add(new Hamster(text, age, breed, eyeColor));
            }
        }
        scan.close();
    }

    public void processPets(String fileName) {
        File myFile = new File(fileName);
        Scanner scan;

        try {
            scan = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
            return;
        }

        excludeComments(scan);

        while (scan.hasNextLine()) {
            String text = scan.nextLine();
            if (!Objects.equals(text, "")) {
                int age = Integer.parseInt(scan.nextLine());
                String breed = scan.nextLine();
                // TODO: create a Pet object with the above data and add it to the ArrayList
                availablePets.add(new Pet(text, age, breed));
            }
        }
        scan.close();
    }

    public void excludeComments(Scanner scan) {
        //get past the comments in the file
        boolean comments = true;
        while (scan.hasNextLine() && comments) {
            String text = scan.nextLine();
            if (Objects.equals(text, "")) {
                comments = false;
            }
        }
    }
}
