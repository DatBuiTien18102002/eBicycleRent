package control;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.RentalCard;

public class DepositController {
    private RentalCard rentalCard;

    public DepositController(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public void addMoneyCard(Integer money) {
        if(rentalCard.checkTypeCard() == 1){
            rentalCard.setBalance(rentalCard.getBalance()+money);
            int index = RentalCard.getRentalCards().search("username",rentalCard.getUsername());
            JsonObject jsonObject = RentalCard.convertToJsonObject(rentalCard);

            RentalCard.getRentalCards().set(index, jsonObject);
            RentalCard.getRentalCards().write();
            System.out.println("[DEPOSIT SUCCESS] Money has been transferred to your card" );
        }else{
            System.out.println("[Deposit failed] You can't top up your postpaid card !!!");
        }
    }
}
