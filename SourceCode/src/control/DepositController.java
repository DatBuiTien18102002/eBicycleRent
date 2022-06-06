package control;

import entity.RentalCard;

public class DepositController {
    private RentalCard rentalCard;

    public DepositController(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public void addMoneyCard(Integer money) {
        if(rentalCard.getiD().equals("123")){
            rentalCard.setBalance(rentalCard.getBalance()+money);
            int index = RentalCard.getRentalCards().search("username",rentalCard.getUsername());
            

        }
    }
}
