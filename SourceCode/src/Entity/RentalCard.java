package entity;

import com.google.gson.JsonObject;

import boundary.StoredFiles;

public class RentalCard extends Card {
    private static StoredFiles rentalCards = new StoredFiles("rentalCards.json");
    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn = false;

    private BankCard bankCard;
    private RentalInfor rentalInfor;

    public RentalCard() {

    }

    public RentalCard(String iD, String name, String phoneNumber, Integer balance, String username, Integer password,
            String email,RentalInfor rentalInfor,BankCard bankCard) {
        super(iD, name, phoneNumber, balance);
        this.bankCard = bankCard;
        this.rentalInfor = rentalInfor;
        this.username = username;
        this.rentalInfor.setUsername(this.username);
        this.password = password;
        this.email = email;
        this.loggedIn = true;   
    }

    public void setRentalCard(String iD, String name, String phoneNumber, Integer balance, String username,
            Integer password,String email,RentalInfor rentalInfor,BankCard bankCard) {
        this.setiD(iD);
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.setBalance(balance);
        this.bankCard = bankCard;
        this.rentalInfor = rentalInfor;
        this.username = username;
        this.rentalInfor.setUsername(username);
        this.password = password;
        this.email = email;
        this.loggedIn = true;
    }

    public void logout() {
        this.setiD(null);
        this.setName(null);
        this.setPhoneNumber(null);
        this.setBalance(null);
        this.loggedIn = false;
        this.username = null;
        this.password = null;
        this.email = null;
        bankCard = null;
        rentalInfor = null;
        System.out.println("[LOGGED_OUT] You have been logged out");

    }

    public static JsonObject convertToJsonObject(RentalCard rentalCard){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", rentalCard.getUsername());
        jsonObject.addProperty("password", rentalCard.getPassword());
        jsonObject.addProperty("email", rentalCard.getEmail());
        jsonObject.add("bankCard", BankCard.convertToJsonObject(rentalCard.getBankCard()));
        jsonObject.add("rentalInfor",RentalInfor.convertToJsonObject(rentalCard.getRentalInfor()));
        jsonObject.addProperty("iD", rentalCard.getiD());
        jsonObject.addProperty("name", rentalCard.getName());
        jsonObject.addProperty("phoneNumber", rentalCard.getPhoneNumber());
        jsonObject.addProperty("balance", rentalCard.getBalance());
        return jsonObject;
    }

    public static RentalCard convertToObject(JsonObject jsonObject){
        RentalCard rentalCard = new RentalCard();
        rentalCard.setUsername(jsonObject.get("username").getAsString());
        rentalCard.setPassword(jsonObject.get("password").getAsInt());
        rentalCard.setEmail(jsonObject.get("email").getAsString());
        rentalCard.setBankCard(BankCard.convertToObject(jsonObject.get("bankCard").getAsJsonObject()));
        rentalCard.setRentalInfor(RentalInfor.convertToObject(jsonObject.get("rentalInfor").getAsJsonObject()));
        rentalCard.setiD(jsonObject.get("iD").getAsString());
        rentalCard.setName(jsonObject.get("name").getAsString());
        rentalCard.setPhoneNumber(jsonObject.get("phoneNumber").getAsString());
        rentalCard.setBalance(jsonObject.get("balance").getAsInt());
        return rentalCard;
    }

    public boolean checkBalance(){
        if(this.getBalance()>1000000){
            return true;
        }
        return false;
    }

    public static StoredFiles getRentalCards() {
        return rentalCards;
    }

    public RentalInfor getRentalInfor() {
        return rentalInfor;
    }
    public void setRentalInfor(RentalInfor rentalInfor) {
        this.rentalInfor = rentalInfor;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        this.rentalInfor.setUsername(this.username);

    }



    public Integer getPassword() {
        return password;
    }
    public void setPassword(Integer password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public String getEmail() {
        return email;
    }



    public boolean checkLoggedIn() {
        return loggedIn;
    }



}
