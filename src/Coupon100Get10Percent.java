/**
 *
 */
public class Coupon100Get10Percent implements Coupon {

    @Override
    public boolean applies(PurchasedItems items) {
        return (items.getTotalCost() >= 100);
    }

    @Override
    public String getLines() {
        return "BEST BUY COUPON (Spent more than 100)" +
                "\n\tYou get 10% off next purchase" +
                "\n----------------------------";
    }
}
