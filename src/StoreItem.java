public class StoreItem {

    private String itemCode; // e.g., 3010
    private String itemDescription; // e.g., Dell Laptop
    private String itemPrice;

    public StoreItem(String code, String descript, String price) {
        this.itemCode = code;
        this.itemDescription = descript;
        this.itemPrice = price;

    }

    // -- Setters
    public void setItemCode(String code) {
        itemCode = code;
    }
    public void setItemDescription(String descript) {
        itemDescription = descript;
    }
    public void setItemPrice(String price) {
        itemPrice = price;
    }

    // -- Getters
    public String getItemCode() {
        return itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemPrice() {
        return itemPrice;
    }
    // appropriate getters and setters
}
