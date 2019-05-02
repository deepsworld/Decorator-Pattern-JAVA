public class PreDecorator extends Decorator {

    public PreDecorator(Receipt r, AddOn a){
        super(r, a);
    }

    @Override
    public void prtReceipt() {
        System.out.println(addon.getLines());
        callTrailer();
    }
}
