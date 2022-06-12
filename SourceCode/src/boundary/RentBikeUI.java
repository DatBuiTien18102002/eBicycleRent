package boundary;

import java.util.Scanner;

import control.RentBikeController;

public class RentBikeUI {
    private RentBikeController rentBikeController;
    private static Scanner sc = new Scanner(System.in);
    
    public RentBikeUI(RentBikeController rentBikeController) {
        this.rentBikeController = rentBikeController;
    }

    public void handleRentBike() {
        rentBikeController.showListRentBicycle();
        int index = rentBikeInputs();
        rentBikeController.RentBicycle(index);
    }

    public int rentBikeInputs(){
        System.out.print("Enter the ID of the bike you want to rent: ");
        return sc.nextInt();
    }

    
}
