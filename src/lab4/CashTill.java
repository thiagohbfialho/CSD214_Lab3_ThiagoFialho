package lab4;

public class CashTill {

    private double runningTotal;

    CashTill(){
        runningTotal = 0;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(double runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void sellItem(SaleableItem pPub){
        runningTotal = runningTotal + pPub.getPrice();
        pPub.sellCopy();
        System.out.println("Sold " + pPub + " @ " +
                pPub.getPrice() + "\nSubtotal = " +
                runningTotal);
    }

    public void showTotal(){
        System.out.println("GRAND TOTAL: " + runningTotal);
    }

}
