package Entity;

public abstract class Card {
    private Integer iD;
    private String name;
    private Integer phoneNumber;
    private Integer balance;

    public Card() {
    }

    public Card(Integer iD, String name, Integer phoneNumber, Integer balance) {
        this.iD = iD;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    



    
    
}
