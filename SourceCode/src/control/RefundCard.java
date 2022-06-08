package control;

import entity.RentalCard;

public class RefundCard {
    private RentalCard rentalCard = new RentalCard();

    public RefundCard(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public void Refund() {
        if(!rentalCard.getNumberPlate().equals("0000")){
            System.out.println("[REFUND FAILED] You need to return the bike before refund card!!!");
            return;
        }else{
            if(rentalCard.checkTypeCard() == 1){
                System.out.println("You will get the remaining  " + rentalCard.getBalance() +" d in the card");
            }
            System.out.println("[REFUND SUCCESS] Thank you for using our service");
            RentalCard.getRentalCards().remove(RentalCard.getRentalCards().search("username", rentalCard.getUsername()));
            RentalCard.getRentalCards().write();
        }
    }
}
