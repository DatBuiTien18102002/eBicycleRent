package entity;

import java.util.Date;

import com.google.gson.JsonObject;

import boundary.StoredFiles;

public class RentalInfor {

    private static StoredFiles rentalInfors = new StoredFiles("rentalInfors.json");
    
    private String username;
    private String numberPlate = "0000";
    private Long rentalTime;

    private Bicycle bicycle;

    public RentalInfor(Bicycle bicycle){
        this.bicycle = bicycle;
    }

    public RentalInfor(String username, String numberPlate, Long rentalTime,Bicycle bicycle) {
        this.bicycle = bicycle;
        this.username = username;
        this.numberPlate = numberPlate;
        this.rentalTime = rentalTime;
    }

    public static JsonObject convertToJsonObject(RentalInfor rentalInfor){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", rentalInfor.getUsername());
        jsonObject.addProperty("numberPlate", rentalInfor.getNumberPlate());
        jsonObject.addProperty("rentalTime", rentalInfor.getRentalTime());
        jsonObject.add("bicycle", Bicycle.convertToJsonObject(rentalInfor.getBicycle()));
        return jsonObject;
    }

    public static RentalInfor convertToObject(JsonObject jsonObject){
        RentalInfor rentalInfor = new RentalInfor(new Bicycle());
        rentalInfor.setUsername(jsonObject.get("username").getAsString());
        rentalInfor.setNumberPlate(jsonObject.get("numberPlate").getAsString());
        if(rentalInfor.getNumberPlate().equals("0000") == false){
            rentalInfor.setRentalTime(jsonObject.get("rentalTime").getAsLong());
        }
        rentalInfor.setBicycle(Bicycle.convertToObject(jsonObject.get("bicycle").getAsJsonObject()));
        return rentalInfor;
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

    public Long getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(Long rentalTime) {
        this.rentalTime = rentalTime;
    }

    

    

    
}
