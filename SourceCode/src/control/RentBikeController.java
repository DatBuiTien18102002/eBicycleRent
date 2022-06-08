package control;

import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.Bicycle;
import entity.RentalCard;

public class RentBikeController {

    private RentalCard rentalCard = new RentalCard();

    public RentBikeController(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public void RentBicycle(int i) {
        if (rentalCard.getBicycle().getStatus().equals("Currently for rent")) {
            System.out.println("[RENT FAILED] You need to return the bicycle before renting another one");
            return;
        }else if(rentalCard.checkTypeCard() == 1 && rentalCard.checkBalance() != true){
            System.out.println("[RENT FAILED] You need to top up to rent the bike");
            return;
        } else {
            JsonArray tempMemory = Bicycle.getBicycles().getAll();
            JsonObject jsonObject = new JsonObject();
            jsonObject = tempMemory.get(i).getAsJsonObject();
            Bicycle bicycle = Bicycle.convertToObject(jsonObject);
            if (bicycle.getStatus().equals("Currently for rent")) {
                System.out.println("[RENT FAILED] The bicycle has been rented!!!, choice another one");
                return;
            }
            bicycle.setStatus("Currently for rent");
            rentalCard.setNumberPlate(bicycle.getNumberPlate());
            rentalCard.setRentalTime(new Date().getTime());
            rentalCard.setBicycle(bicycle);
            int index = RentalCard.getRentalCards().search("username", rentalCard.getUsername());
            RentalCard.getRentalCards().set(index, RentalCard.convertToJsonObject(rentalCard));
            RentalCard.getRentalCards().write();
            Bicycle.getBicycles().set(i, Bicycle.convertToJsonObject(bicycle));
            Bicycle.getBicycles().write();
            System.out.println("[RENT SUCCESS] You can drive a bike to anywhere");
        }
    }

    public void showListRentBicycle() {
        JsonObject jsonObject = new JsonObject();
        JsonArray memory = Bicycle.getBicycles().getAll();
        System.out.println(
                "*****************************************************************************************");
        System.out.println(
                "**                                Bicycle Rental List                                  **");                
        System.out.println(
                "**-------------------------------------------------------------------------------------**");
        System.out.printf("%-4s %-5s %-15s %-12s %-12s %-14s %-18s %-3s\n","**","ID","NumberPlate","Type","Color","Manufacturer","Status","**");
        System.out.println(
                "**-------------------------------------------------------------------------------------**");
        for (int i = 0; i < Bicycle.getBicycles().getAll().size(); i++) {
            jsonObject = memory.get(i).getAsJsonObject();
            Bicycle bicycle = Bicycle.convertToObject(jsonObject);
            System.out.printf("%-4s %-6d", "**", i);
            bicycle.showInfor();
            System.out.printf("%-4s\n", "**");
        }
        System.out.println(
                "*********************************************************************************8888****");
    }
}
