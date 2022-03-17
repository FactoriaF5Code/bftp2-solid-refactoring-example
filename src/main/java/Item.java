public class Item {
    private final String name;
    private final int priceInEuros;

    public Item(String name, int priceInEuros) {
        this.name = name;
        this.priceInEuros = priceInEuros;
    }

    public String getName() {
        return name;
    }

    public int getPriceInEuros() {
        return priceInEuros;
    }
}
