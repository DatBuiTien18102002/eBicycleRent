package boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import control.DepositController;

public class DepositUI {
    private DepositController depositController;
    private static Scanner sc = new Scanner(System.in);

    public DepositUI(DepositController depositController) {
        this.depositController = depositController;
    }

    public void handleDeposit(){
        System.out.println("Enter the amount you want to deposit: ");
        depositController.addMoneyCard(depositInputs());
    }
    private int depositInputs() {
        List<Object> list = new ArrayList<>();
        System.out.print("MONEY: ");
        return sc.nextInt();
    }

}
