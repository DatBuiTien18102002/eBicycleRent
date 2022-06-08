import java.text.SimpleDateFormat;
import java.util.Date;

import control.DepositController;
import control.LoginController;
import control.NewRentalCardController;
import control.RefundCard;
import control.RentBikeController;
import control.ReturnBikeController;
import entity.RentalCard;

public class Testc {
    public static void main(String[] args) {
        RentalCard rentalCard = new RentalCard();
        LoginController loginController = new LoginController(rentalCard);
        loginController.login("khaitq", 23145);

        // DepositController depositController = new DepositController(rentalCard);
        // depositController.addMoneyCard(1);
        //NewRentalCardController newRentalCardController = new NewRentalCardController(new RentalCard());
        //newRentalCardController.createPostpaidCard("ductmsa", 99999, "ductms@gmail.com", "11294881" , 121122);

          //RentBikeController rentBicycleController = new RentBikeController(rentalCard);
          //rentBicycleController.RentBicycle(0);

        //  ReturnBikeController returnBicycleController = new ReturnBikeController(rentalCard);
        //  returnBicycleController.ReturnBike(new Date());
        // SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        // System.out.println("You rented the bike at "+ sdf.format(new Date(rentalCard.getRentalTime())));;

        RefundCard refundCard = new RefundCard(rentalCard);
        refundCard.Refund();
    }
}
