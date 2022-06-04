package entity;

import boundary.StoredFiles;

public class RentalCard extends Card {
    private static StoredFiles rentalCards = new StoredFiles("rentalCards.json");
    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn;

    private BankCard bankCard;
    private RentalInfor rentalInfor;

    public RentalCard() {
        this.bankCard = null;
        this.rentalInfor = null;
        this.setiD(null);
        this.setName(null);
        this.setPhoneNumber(null);
        this.setBalance(null);
        this.username = null;
        this.password = null;
        this.email = null;
        this.loggedIn = false;
    }

    public RentalCard(Integer iD, String name, Integer phoneNumber, Integer balance, String username, Integer password,
            String email,RentalInfor rentalInfor,BankCard bankCard) {
        super(iD, name, phoneNumber, balance);
        this.bankCard = bankCard;
        this.rentalInfor = rentalInfor;
        this.username = username;
        this.rentalInfor.setUsername(this.username);
        this.password = password;
        this.email = email;

    }

    public void setRentalCard(Integer iD, String name, Integer phoneNumber, Integer balance, String username,
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

    public static StoredFiles getRentalCards() {
        return rentalCards;
    }

    public RentalInfor getRentalInfor() {
        return rentalInfor;
    }
    public void setRentalInfor(RentalInfor rentalInfor) {
        this.rentalInfor = rentalInfor;
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
