public class Rebate1406 implements Rebate {

    private PurchasedItems items;
    public boolean applies(PurchasedItems items) {
        this.items = items;
        return items.containsItem("1406");
    }

    public String getLines() {
        return "Mail-in Rebate\t" + "Item# 1406\t" + items.getItemDes("1406")+ "\n"  +
                "Mail ORIGINAL receipt and Proof of Purchase from package to: \n" +
                "BEST BUY / SAMSUNG REBATES\n" +
                "1000 Industry Way Owings Mills,\n" +
                "MD 21117\n" +
                "Please allow 3-4 weeks for processing" +
                "\n----------------------------";
    }

}