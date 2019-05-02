import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CATaxComputation extends TaxComputationMethod {
    private final double TAX = 0.075;

    @Override
    public double computeTax(PurchasedItems items, Date date) {
        double totalTax = 0;
        if(!taxHoliday(date)){
            totalTax += items.getTotalCost() * TAX;
        }
        return totalTax;
    }

    @Override
    protected boolean taxHoliday(Date date) {
        return false;
    }

}
