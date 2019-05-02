import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicReceipt implements Receipt {

    private StoreHeader store_header; // street address, state code, phone number, store number
    private TaxComputationMethod tc;
    private Date date; // may also be a String type
    private PurchasedItems items;


    public BasicReceipt(PurchasedItems items, Date date) {
        this.items = items;
        this.date = date;
    }

    public void setStoreHeader(StoreHeader h) {
        store_header = h;
    }

    public void setTaxComputationMethod(TaxComputationMethod tc) {
        this.tc = tc;
    }

    /*
    Collects the basic contents of the receipt and prints them.
     */
    public void prtReceipt() {
        double total = items.getTotalCost();
        double taxAmount = tc.computeTax(items,date);
        String d = date.toString();
        System.out.println("\n----------------------------" +
                            store_header.toString() + "\n" +
                            d + "\n" +
                            "----------------------------" +
                            items.printItems() + "\n\n" +
                            "Total Sale" + "\t\t " + String.format("$ %.2f",total) + "\n\n" +
                            store_header.getStateCode() + " Sales Tax(" +String.format("%.3f",taxAmount/total) + ")" + "\t\t " + String.format("$ %.2f", taxAmount) + "\n\n" +
                            "CUSTOMER OWES" + "\t\t" + String.format("$ %.2f", (total + taxAmount)) + "\n" +
                            "\n----------------------------");
    }
}