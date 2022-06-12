package boundary;

import control.RefundCard;

public class RefundUI {
    private RefundCard refundCard;

    public RefundUI(RefundCard refundCard) {
        this.refundCard = refundCard;
    }

    public void handleRefund() throws InterruptedException{
        System.out.println("Refund...");
        Thread.sleep(500);
        refundCard.Refund();
    }
}
