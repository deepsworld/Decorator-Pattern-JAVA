public abstract class Decorator implements Receipt {

    private Receipt trailer;
    protected AddOn addon;

    public Decorator(Receipt r, AddOn a) {
        trailer = r;
        addon = a;
    }

    protected void callTrailer() {
        trailer.prtReceipt();
    }

    public abstract void prtReceipt();
}