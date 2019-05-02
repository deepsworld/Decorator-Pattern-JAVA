public class HolidayGreeting implements SecondaryHeading {

    public boolean applies(PurchasedItems items) {
        return true; // SecondaryHeading decorators always applied
    }

    public String getLines() {
        return "\n----------------------------" +
                "\n* Happy Holidays from Best Buy *";
    }
}
