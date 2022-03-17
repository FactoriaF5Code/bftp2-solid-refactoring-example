import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TicketGeneratorTest {

    @Test
    void returnsTheTicketForASinglePurchase() {

        var items = List.of(
                new Item("Pizza Margherita", 10)
        );

        var ticketGenerator = new TicketGenerator();

        var ticket = ticketGenerator.generateTicket(items);

        assertThat(ticket,
                equalTo("""
                        Products: Pizza Margherita
                        Total: 10 euro
                        """)
        );
    }

    @Test
    void returnsTheTicketForMultipleProducts() {

        var items = List.of(
                new Item("Pizza Margherita", 10),
                new Item("Patatas Fritas", 2)
        );

        var ticketGenerator = new TicketGenerator();

        var ticket = ticketGenerator.generateTicket(items);

        assertThat(ticket,
                equalTo("""
                        Products: Pizza Margherita + Patatas Fritas
                        Total: 12 euro
                        """)
        );
    }

    @Test
    void comboMenuHasAFixedPriceOf13Euro() {

        var items = List.of(
                new Item("Pizza Margherita", 10),
                new Item("Patatas Fritas", 2),
                new Item("Cocacola", 3)
        );

        var ticketGenerator = new TicketGenerator();

        var ticket = ticketGenerator.generateTicket(items);

        assertThat(ticket,
                equalTo("""
                        Products: combo menu
                        Total: 13 euro
                        """)
        );
    }
}
