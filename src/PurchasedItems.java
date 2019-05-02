import java.util.ArrayList;

public class PurchasedItems {

    private ArrayList<StoreItem> items;

    public PurchasedItems() {
        items = new ArrayList<>();
    }

    public void addItem(StoreItem item) {
        items.add(item);
    }

    public double getTotalCost() {
        double total = 0;
        for(StoreItem item: items){
            total += Double.parseDouble(item.getItemPrice());
        }
        return total;
    }

    public boolean containsItem(String itemCode) {
        boolean value = false;
        for(StoreItem item: items){
            if(item.getItemCode().equals(itemCode)){
                value = true;
            }
        }
        return value;
    }

    public String getItemDes(String itemCode) {
        String value = " ";
        for(StoreItem item: items){
            if(item.getItemCode().equals(itemCode)){
                value = item.getItemDescription();
            }
        }
        return value;
    }

    public String printItems(){
        StringBuilder stringBuilder = new StringBuilder();
        for(StoreItem item: items){
            stringBuilder.append("\n" + item.getItemCode() + " " + item.getItemDescription() + "\t\t$ " + item.getItemPrice() + "\n");
        }
        return stringBuilder.toString();
    }
}