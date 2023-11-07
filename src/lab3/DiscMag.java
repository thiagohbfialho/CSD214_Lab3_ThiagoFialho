package lab3;

import java.util.Date;

/**
 * @author tfialho
 */
public class DiscMag extends Magazine{
    public DiscMag(String title, double price, int orderQty, Date currIssue, int copies) {
        super(title, price, orderQty, currIssue, copies);
    }

    @Override
    public void receiveNewIssue(Date newIssue) {
        super.receiveNewIssue(newIssue);
    }
}
