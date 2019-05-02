public class PostDecorator extends Decorator {

    public PostDecorator(Receipt r, AddOn a){
        super(r, a);
    }
    @Override
    public void prtReceipt() {
        callTrailer();
        System.out.println(addon.getLines());
    }
}
