import java.util.List;
import java.util.stream.Collectors;

public class TicketGenerator {
    public String generateTicket(List<Item> items) {
        String productList = items.stream().map(Item::getName).collect(Collectors.joining(" + "));
        int totalPrice = items.stream().map(Item::getPriceInEuros).reduce(0, Integer::sum);
        return """
                Products: %s
                Total: %d euro
                """.formatted(productList, totalPrice);
    }
}
