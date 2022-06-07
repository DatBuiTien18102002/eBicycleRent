import control.LoginController;
import control.NewRentalCardController;
import entity.RentalCard;

public class Testc {
    public static void main(String[] args) {
        LoginController loginController = new LoginController(new RentalCard());
        loginController.login("thuanlq", 437890);

        //NewRentalCardController newRentalCardController = new NewRentalCardController(new RentalCard());

        //newRentalCardController.createPostpaidCard("ductmsa", 99999, "ductms@gmail.com", "11294881" , 121122);
    }
}
