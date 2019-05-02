import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MDTaxComputation extends TaxComputationMethod {
    private final double TAX = 0.06;

    // Change tax holiday here.
    private final Date holidayStart = StringToDate("08-16");
    private final Date holidayEnd = StringToDate("08-21");

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
        String pattern = "MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date_string = simpleDateFormat.format(date);
        Date cdate = StringToDate(date_string);
        return holidayStart.compareTo(cdate) * cdate.compareTo(holidayEnd) >= 0;
    }

    // Method to convert string to Date object.
    private Date StringToDate(String sdate){
        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
            result  = dateFormat.parse(sdate);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        return result ;
    }
}

