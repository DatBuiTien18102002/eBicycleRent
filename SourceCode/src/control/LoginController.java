/*
*  created date: May 23, 2022
*  author: cgm
*/
package control;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import entity.BankCard;
import entity.Bicycle;
import entity.RentalCard;
import entity.RentalInfor;

public class LoginController {

    // login
    private RentalCard rentalCard;

    public LoginController(RentalCard rentalCard) {
        this.rentalCard = rentalCard;
    }

    public void login(String username, Integer password) {

        JsonArray tempMemory = RentalCard.getRentalCards().getAll();

        int index = -1;
        index = RentalCard.getRentalCards().search("username", username);

        // 1. already logined ==> username == object.username
        // logedIn = true
        if (username.equals(this.rentalCard.getUsername())) {
            System.out.println("[ALREADY LOGGED IN] You have already logged in.");

            // 2. dang nhap nhieu tai khoan=> username nhap vao != objcAccount.username
        } else if (this.rentalCard.getUsername() != null && !this.rentalCard.getUsername().equals(username)) {
            System.out.println("[INVALID MULTIPLE LOGINS] You need  to logout first to try another login.");
            // 4. dang nhap binh thuong|
        } else if (index != -1) {// accountObject => un =null, ps = null, email = null; loggedIn = false
            JsonObject jsonObject = tempMemory.get(index).getAsJsonObject();
            int passwordAcc = jsonObject.get("password").getAsInt();
            if (passwordAcc == password) {
                String iD = jsonObject.get("iD").getAsString();
                String name = jsonObject.get("name").getAsString();
                String phoneNumber = jsonObject.get("phoneNumber").getAsString();
                Integer balance = jsonObject.get("balance").getAsInt();
                String email = jsonObject.get("email").getAsString();
                Bicycle bicycle = new Bicycle();
                RentalInfor rentalInfor = new RentalInfor(bicycle);
                BankCard bankCard = new BankCard();
                JsonObject jsonObject1 = new JsonObject();
                if(iD.equals("123") == false){
                    jsonObject1 = jsonObject.get("bankCard").getAsJsonObject();
                    bankCard.setiD(jsonObject1.get("iD").getAsString());
                    bankCard.setName(jsonObject1.get("name").getAsString());
                    bankCard.setPhoneNumber(jsonObject1.get("phoneNumber").getAsString());
                    bankCard.setBalance(jsonObject1.get("balance").getAsInt());
                    bankCard.setPin(jsonObject1.get("pin").getAsInt());
                    bankCard.setBankName(jsonObject1.get("bankName").getAsString());
                }
                jsonObject1 = jsonObject.get("rentalInfor").getAsJsonObject();

                if(jsonObject1.get("numberPlate").getAsString() != "0000"){
                    rentalInfor.setUsername(username);
                    rentalInfor.setNumberPlate(jsonObject1.get("numberPlate").getAsString());
                    rentalInfor.setRentalTime(jsonObject1.get("rentalTime").getAsLong());
                    jsonObject1 =  jsonObject1.get("bicycle").getAsJsonObject();
                    rentalInfor.getBicycle().setNumberPlate(jsonObject1.get("numberPlate").getAsString());
                    rentalInfor.getBicycle().setType(jsonObject1.get("type").getAsString());
                    rentalInfor.getBicycle().setColor(jsonObject1.get("color").getAsString());
                    rentalInfor.getBicycle().setManufacturer(jsonObject1.get("manufacturer").getAsString());
                }
                // update value data to account
                this.rentalCard.setRentalCard(iD, name, phoneNumber, balance, username, password, email, rentalInfor, bankCard);
                System.out.println("[LOGGED IN] You are logged in.");

            } else {
                System.out.println("[WRONG PASSWORD] The password  you enterd is incorrect!!!");
            }

        } else {
            System.out.println("[NOT REGISTERD] You have to  register first.!!! ");
        }

        // else
        // 3. chua dang ky
    }
    // logout

    public void logout(){
        this.rentalCard.logout();
    }

}
