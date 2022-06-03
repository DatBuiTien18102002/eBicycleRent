package entity;

import boundary.StoredFiles;

public class RentalCard extends Card{
    private static StoredFiles accounts = new StoredFiles("rentalCards.json");
    private String username;
    private Integer password;
    private String email;
    private boolean loggedIn;

    public RentalCard() {
        this.username = null;
        this.password = null;
        this.email = null;
        this.loggedIn = false;
    }      

    public RentalCard(Integer iD, String name, Integer phoneNumber, Integer balance, String username, Integer password,
            String email, boolean loggedIn) {
        super(iD, name, phoneNumber, balance);
        this.username = username;
        this.password = password;
        this.email = email;
        this.loggedIn = loggedIn;
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
        System.out.println("[LOGGED_OUT] You have been logged out");

    }

    public static StoredFiles rententalCards() {
        return accounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean checkLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    

    
    
    

}
