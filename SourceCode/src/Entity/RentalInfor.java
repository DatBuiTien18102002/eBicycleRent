package entity;

import java.util.Date;

public class RentalInfor {
    private String username;
    private Integer numberPlate;
    private Date rentalTime;

    public RentalInfor(){
        this.username = null;
        this.numberPlate = null;
        this.rentalTime = null;
    }

    public RentalInfor(String username, Integer numberPlate, Date rentalTime) {
        this.username = username;
        this.numberPlate = numberPlate;
        this.rentalTime = rentalTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(Integer numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Date getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Date rentalTime) {
        this.rentalTime = rentalTime;
    }

    

    

    
}
