package Entity;

public class BankCard extends Card{
    private Integer pin;
    private String bankName;

    public BankCard() {
    }

    public BankCard(Integer iD, String name, Integer phoneNumber, Integer balance, Integer pin, String bankName) {
        super(iD, name, phoneNumber, balance);
        this.pin = pin;
        this.bankName = bankName;
    }

    public Integer getPin() {
        return pin;
    }


    public String getBankName() {
        return bankName;
    }



    

    

}
