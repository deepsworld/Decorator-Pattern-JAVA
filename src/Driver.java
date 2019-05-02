import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Driver{

    public static void main(String[] args){
        Receipt receipt;
        ReceiptFactory factory = new ReceiptFactory();

        // Default date.
        String pattern = "MM-dd-yyyy HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date_string = simpleDateFormat.format(new Date());
        Date date = null;
        try{
            date = simpleDateFormat.parse(date_string);//set "08-21-2019 12:00" for tax holiday.
        } catch (ParseException e){
            e.printStackTrace();
        }

        // Getting the user input.
        Scanner scan = new Scanner(System.in);
        int user_choice;
        PurchasedItems purchasedItems = new PurchasedItems();
        do {
            showInstructions();
            System.out.print("Your Choice: ");
            user_choice = scan.nextInt();

            switch (user_choice){

                case 0:{
                    user_choice = 0;
                    System.out.println("Exiting...");
                    break;
                }

                case 1: {
                    factory = new ReceiptFactory();
                    purchasedItems = new PurchasedItems();
                    System.out.println("New receipt initialized");
                    System.out.println("Purchased items list cleared..");
                    break;
                }

                case 2: {
                    int choice = 0;
                    do{
                        showItems();
                        System.out.print("Your Choice: ");
                        choice = scan.nextInt();
                        switch (choice){
                            case 0:{
                                displayPurchasedItems(purchasedItems);
                                break;
                            }
                            case 1:{
                                purchasedItems.addItem(
                                        new StoreItem("4028", "Samsung S9 Black 64 GB", "719.99"));
                                System.out.println("Item added to cart -- Select 0 to buy or add more items");
                                break;
                            }

                            case 2:{
                                purchasedItems.addItem(
                                        new StoreItem("1406", "Samsung S9 Case", "39.99"));
                                System.out.println("Item added to cart -- Select 0 to buy or add more items");
                                break;
                            }
                            case 3:{
                                purchasedItems.addItem(
                                        new StoreItem("2428", "Anker External Battery", "49.99"));
                                System.out.println("Item added to cart -- Select 0 to buy or add more items");
                                break;
                            }
                            case 4:{
                                purchasedItems.addItem(
                                        new StoreItem("3095", "Power Adapter", "9.99"));
                                System.out.println("Item added to cart -- Select 0 to buy or add more items");
                                break;
                            }
                            default:System.out.println("Input choice does not exist");
                        }

                    }while(choice != 0);
                    break;
                }

                case 3: {
                    receipt = factory.getReceipt(purchasedItems, date);
                    receipt.prtReceipt();
                    break;
                }

                case 4: {
                    String option;
                    boolean value = true;
                    while(value){
                        System.out.print("Enter custom date(e.g. 08-21-2019 12:00)(0 for default): ");
                        scan.nextLine();
                        option = scan.nextLine();
                        if(option.equals("0")){
                            value = false;
                            System.out.println("Continuing with system date");
                        }
                        else{
                            value = false;
                            try {
                                // "08-21-2019 12:00" to check for tax holiday.
                                date = simpleDateFormat.parse(option);
                                System.out.println("Your custom date is set");
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }

                default:{
                    System.out.println("\nInput choice does not exist");
                }
            }
        } while(user_choice != 0);
    }

    /*
    Display purchased items.
     */
    private static void displayPurchasedItems(PurchasedItems purchasedItems) {
       purchasedItems.printItems();
    }

    /*
    Display instructions.
     */
    private static void showInstructions() {
        String instructions = "---- Make a Choice ---- \n" +
                "1 – Start New Receipt \n" +
                "2 – Add Items \n" +
                "3 – Display Receipt \n" +
                "4 – Custom Date \n" +
                "0 - Quit\n";
        System.out.print(instructions);
    }

    /*
    Display available items.
     */
    private static void showItems(){
        String instructions = "---- Add items to buy ---- \n" +
                "Item \t\tPrice\n" +
                "1 – Samsung S9 Black 64 GB\t\t$ 719.99 \n" +
                "2 – Samsung S9 Case \t\t$39.99 \n" +
                "3 – Anker External Battery \t\t$49.99 \n" +
                "4 - Power Adapter\t\t9.99 \n" +
                "0 - Buy\n";
        System.out.print(instructions);
    }
}

