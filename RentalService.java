package com.company;
import java.util.Scanner;
import com.company.model.Car;
import com.company.model.Motorbike;
import com.company.model.Vehicle;

public class RentalService {

    private String name;
    private String address;
    private Vehicle stock[];

    public RentalService(String name, String address, Vehicle[] stock) {
        this.name = name;
        this.address = address;
        this.stock = stock;
    }

    public Vehicle[] getStock() {
        return stock;
    }

    public static void main(String[] args){
       Car fordFocus = new Car(1,"Ford", "Focus", 190);
       Car kiaCeed = new Car(2,"Kia", "Ceed", 180);
       Motorbike yamahaCbr = new Motorbike(3,"Yamaha", "CBR", 175);
       Motorbike ducatiMonster = new Motorbike(4, "Ducati", "Monster", 220);

       Vehicle[] wigryRentStock = {fordFocus, kiaCeed, yamahaCbr, ducatiMonster};

       RentalService wigryRent = new RentalService("Wigry Rental", "heheszki 5", wigryRentStock);
       wigryRent.run();

    }
    public void run(){
        Scanner scInput = new Scanner(System.in);
        int input = 0;
        System.out.println("Car rental Menu: \n" +
            "Press 1 to check available cars and bikes. \n" +
            "Press 2 to rent a vehicle. \n" +
            "Press 3 to return a vehicle. \n" +
            "Press 4 to check rented vehicles \n" +
            "Press 5 to exit");

        while (input != 5){
            input = scInput.nextInt();
            switch (input){
                case 1:
                    System.out.println("Available cars: ");
                    Vehicle[] cars = this.getStock();
                    for(int i = 0; i < cars.length; i++){
                        if(cars[i].isAvailable()) {
                            System.out.println("id: " +
                                    cars[i].getId() +
                                    ", brand: " + cars[i].getBrand() +
                                    ", model: " + cars[i].getModel() +
                                    ", price: " + cars[i].getPrice());
                        }
                     }
                    break;
                case 2:
                    System.out.println("Which vehicle would you like to rent? \n " +
                            "(please write vehicle id)");
                    int inputCarId = (scInput.nextInt()) - 1;
                    Vehicle[] cars2 = this.getStock();
                    if(cars2[inputCarId].isAvailable() == true){
                        cars2[inputCarId].rent();
                        System.out.println("Vehicle: \n" +
                                cars2[inputCarId].getBrand() + " " +
                                cars2[inputCarId].getModel() +
                                ", has been rented.");
                    }
                    break;
                case 3:
                    System.out.println("Which vehicle would you like to return? (id of vehicle needed.)");
                    int inputCarId2 = (scInput.nextInt()) - 1;
                    Vehicle[] cars3 = this.getStock();
                    if(cars3[inputCarId2].isAvailable() == false){
                        cars3[inputCarId2].returnVehicle();
                        System.out.println("Your vehicle has been return: \n" +
                                cars3[inputCarId2].getBrand() + " " +cars3[inputCarId2].getModel());
                    } else {
                        System.out.println("This vehicle is not rented.");
                    }
                    break;
                case 4:
                    System.out.println("List of rented vehicles: ");
                    Vehicle[] cars4 = this.getStock();
                    int countVehicles= 0;
                    for(int i = 0; i < cars4.length; i++) {
                        if (cars4[i].isAvailable() == false) {
                            countVehicles++;
                            System.out.println(cars4[i].getId() + " " +
                                    cars4[i].getModel() + " " +
                                    cars4[i].getBrand());
                        }
                    }
                    if(countVehicles == 0){
                        System.out.println("All vehicles availble.");
                    }
                    break;
            }
        }
        System.out.println("Good bye.");
    }
}
