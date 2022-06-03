package entity;

public class Bicycle {
    private String numberPlate;
    private String type;
    private String color;
    private String manufacturer;
    private String status; //   Sẵn sàng/Đang cho thuê

    public Bicycle(){
        this.numberPlate = null;
        this.type = null;
        this.color = null;
        this.manufacturer = null;
        this.status = null;
    }


    public Bicycle(String numberPlate, String type, String color, String manufacturer, String status) {
        this.numberPlate = numberPlate;
        this.type = type;
        this.color = color;
        this.manufacturer = manufacturer;
        this.status = status;
    }







    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String checkStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    

    
}
