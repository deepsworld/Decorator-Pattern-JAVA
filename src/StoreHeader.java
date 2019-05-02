public class StoreHeader {
    private String street_addr;
    private String zip_code;
    private String state_code;
    private String phone_num;
    private String store_num; // e.g., #1004

    public StoreHeader(String street_addr, String state_code, String zip_code, String store_num,  String phone_num){
        this.street_addr = street_addr;
        this.zip_code = zip_code;
        this.state_code = state_code;
        this.phone_num = phone_num;
        this.store_num = store_num;
    }

    public String getStateCode() {
        return state_code;
    }

    public String toString() {
        return ("\nBEST BUY\n" + street_addr + "., " + state_code + ", "
                + zip_code + "\n" + "Store # " + store_num
                + "\n" + phone_num) ;
    }

}