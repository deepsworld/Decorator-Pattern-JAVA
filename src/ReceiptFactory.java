import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class ReceiptFactory {

    // contains street_addr, zip_code, state_code, phone num, store num
    private StoreHeader store_header;
    // secondary heading, rebate and coupon add-ons (hardcoded here) like said in skeleton code
    private AddOn[] addOns = new AddOn[]{new Coupon100Get10Percent(), new Rebate1406(), new HolidayGreeting()};
    // stores tax computation objects
    private TaxComputationMethod taxComputationObj;

    // constructor
    public ReceiptFactory() {
        // 2. Reads config file to create and save StoreHeader object (store_num, street_addr, etc.)
        // to be used on all receipts.
        setStoreHeader();

        // 3. Based on the state code (e.g., “MD”) creates and stores appropriate StateComputation
        // object to be used on all receipts.
        String state = store_header.getStateCode();
        createStateComputation(state); //state
    }

    /*
    Based on the state code (e.g., “MD”) creates and stores appropriate
    StateComputation object to be used on all receipts.
     */
    private void createStateComputation(String state){
        if(state.equals("MD")){
            taxComputationObj = new MDTaxComputation();;
        }
        else if (state.equals("CA")){
            taxComputationObj = new CATaxComputation();
        }
        // if any other state, add more else ifs.
    }

    /*
     Reads config file to create and save StoreHeader object (store_num, street_addr, etc.)
     to be used on all receipts.
     */
    private void setStoreHeader(){
        // File path might be different.
        File file = new File("C:\\Users\\deepp\\IdeaProjects\\Assignment5- COSC436\\src\\config.txt");
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                this.store_header = new StoreHeader(
                        scan.nextLine(),
                        scan.nextLine(),
                        scan.nextLine(),
                        scan.nextLine(),
                        scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    Returns decorated BasicReceipt object with store header and tax computations as type Receipt
     */
    public Receipt getReceipt(PurchasedItems items, Date date) {

        BasicReceipt basicReceipt = new BasicReceipt(items, date);
        basicReceipt.setStoreHeader(store_header);
        basicReceipt.setTaxComputationMethod(taxComputationObj);
        Receipt receipt = basicReceipt;

        for(AddOn addOn: addOns){
            if(addOn.applies(items)){
                if (addOn instanceof SecondaryHeading){
                    receipt = new PreDecorator(receipt,addOns[2]);
                }
                if(addOn instanceof Coupon){
                    receipt = new PostDecorator(receipt,addOns[0]);
                }
                if(addOn instanceof Rebate){
                    receipt = new PostDecorator(receipt,addOns[1]);
                }
            }
        }
        return receipt;
    }
}
