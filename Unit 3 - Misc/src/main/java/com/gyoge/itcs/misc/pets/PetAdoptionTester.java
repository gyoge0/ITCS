package com.gyoge.itcs.misc.pets;


import java.util.ArrayList;

public class PetAdoptionTester {

    public static void main(String[] args) {
        PetAdoptionEvent myEvent = new PetAdoptionEvent("Fur-ever Home");
        myEvent.processCats("src/main/resources/Pets/EventCats.txt");
        myEvent.processDogs("src/main/resources/Pets/EventDogs.txt");
        myEvent.processHamsters("src/main/resources/Pets/EventHamsters.txt");
        myEvent.processPets("src/main/resources/Pets/EventPets.txt");

        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        myEvent.rehomePet("Starla");
        System.out.println(
            "Congratulations!  You just adopted Starla!  Your fee is $" + myEvent.getAdoptedPets()
                .get(myEvent.getAdoptedPets().size() - 1).getAdoptionFee());
        System.out.println();
        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        myEvent.rehomePet("Frank");
        System.out.println(
            "Congratulations!  You just adopted Frank!  Your fee is $" + myEvent.getAdoptedPets()
                .get(myEvent.getAdoptedPets().size() - 1).getAdoptionFee());
        System.out.println();
        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        myEvent.rehomePet("Oreo");
        System.out.println(
            "Congratulations!  You just adopted Oreo!  Your fee is $" + myEvent.getAdoptedPets()
                .get(myEvent.getAdoptedPets().size() - 1).getAdoptionFee());
        System.out.println();
        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        myEvent.rehomePet("Hat Trick");
        System.out.println("Congratulations!  You just adopted Hat Trick!  Your fee is $"
            + myEvent.getAdoptedPets().get(myEvent.getAdoptedPets().size() - 1).getAdoptionFee());
        System.out.println();
        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        myEvent.rehomePet("Sunset");
        System.out.println(
            "Congratulations!  You just adopted Sunset!  Your fee is $" + myEvent.getAdoptedPets()
                .get(myEvent.getAdoptedPets().size() - 1).getAdoptionFee());
        System.out.println();
        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        myEvent.rehomePet("Thurmond");
        System.out.println(
            "Congratulations!  You just adopted Thurmond!  Your fee is $" + myEvent.getAdoptedPets()
                .get(myEvent.getAdoptedPets().size() - 1).getAdoptionFee());
        System.out.println();
        System.out.println("Adopted Pets:");
        myEvent.displayAdoptedPets();
        System.out.println("Total Revenue: $" + myEvent.getTotalFees());
        System.out.println();

        ArrayList<Pet> request = myEvent.requestCat("short");
        System.out.println(request.size() + " pets fit your criteria:");
        for (int i = 0; i < request.size(); i++) {
            System.out.println(request.get(i).getName() + ": " + request.get(i).getBreed());
        }
        System.out.println();

        request = myEvent.requestDog(false);
        System.out.println(request.size() + " pets fit your criteria:");
        for (int i = 0; i < request.size(); i++) {
            System.out.println(request.get(i).getName() + ": " + request.get(i).getBreed());
        }
        System.out.println();

        request = myEvent.requestDog(true);
        System.out.println(request.size() + " pets fit your criteria:");
        for (int i = 0; i < request.size(); i++) {
            System.out.println(request.get(i).getName() + ": " + request.get(i).getBreed());
        }
        System.out.println();

        request = myEvent.requestHamster(3.0);
        System.out.println(request.size() + " pets fit your criteria:");
        for (int i = 0; i < request.size(); i++) {
            System.out.println(request.get(i).getName() + ": " + request.get(i).getBreed());
        }
        System.out.println();

        request = myEvent.requestHamster(7.0);
        System.out.println(request.size() + " pets fit your criteria:");
        for (int i = 0; i < request.size(); i++) {
            System.out.println(request.get(i).getName() + ": " + request.get(i).getBreed());
        }
        System.out.println();

        System.out.println(
            "Thank you for visiting " + myEvent.getShelterName() + " on " + myEvent.getEventDate()
                + "!");
        System.out.println(myEvent.getAdoptedPets().size() + " pets were adopted! We raised $"
            + myEvent.getTotalFees() + "!");
        System.out.println();
        System.out.println("There are " + myEvent.getAvailablePets().size()
            + " pets still available.  Come check them out!");
        myEvent.displayAvailablePets();

    }

}
