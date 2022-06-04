package entity;

import java.util.Date;

import boundary.StoredFiles;

public class RentalInfor {

    private static StoredFiles rentalInfors = new StoredFiles("rentalInfors.json");
    
    private String username;
    private String numberPlate;
    private Date rentalTime;

    private Bicycle bicycle;

    public RentalInfor(){
        this.bicycle = null;
        this.username = null;
        this.numberPlate = null;
        this.rentalTime = null;
    }

    public RentalInfor(String username, String numberPlate, Date rentalTime,Bicycle bicycle) {
        this.bicycle = bicycle;
        this.username = username;
        this.numberPlate = numberPlate;
        this.rentalTime = rentalTime;
    }

    public static StoredFiles getRentalInfors() {
        return rentalInfors;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }
    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Date getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Date rentalTime) {
        this.rentalTime = rentalTime;
    }

    

    

    
}
