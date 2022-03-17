import java.util.List;
import java.util.stream.Collectors;

public class TicketGenerator {
    public String generateTicket(List<Item> items) {
        int totalPrice;
        String productList;

        if (items.size() == 3 && items.stream().anyMatch(item -> item.getName().startsWith("Pizza")) &&
                    items.stream().anyMatch(item -> item.getName().startsWith("Patatas Fritas")) &&
                    items.stream().anyMatch(item -> item.getName().startsWith("Cocacola"))) {
                totalPrice = 13;
                productList = "combo menu";

        } else {
            productList = items.stream().map(Item::getName).collect(Collectors.joining(" + "));
            totalPrice = items.stream().map(Item::getPriceInEuros).reduce(0, Integer::sum);
        }
        return """
                Products: %s
                Total: %d euro
                """.formatted(productList, totalPrice);
    }
}
