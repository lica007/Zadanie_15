import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.AviaSouls;
import ru.netology.statistic.Ticket;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Сочи", "Москва", 15_000, 15, 17);
    Ticket ticket2 = new Ticket("Сочи", "Санкт-Петербург", 20_000, 11, 13);
    Ticket ticket3 = new Ticket("Сочи", "Красноярск", 25_000, 13, 17);
    Ticket ticket4 = new Ticket("Сочи", "Казань", 15_000, 8, 11);
    Ticket ticket5 = new Ticket("Сочи", "Иркутск", 19_000, 10, 16);

    Ticket ticket6 = new Ticket("Сочи", "Москва", 40_000, 18, 20);
    Ticket ticket7 = new Ticket("Сочи", "Москва", 20_000, 1, 4);
    Ticket ticket8 = new Ticket("Сочи", "Москва", 5_000, 6, 11);

    @Test
    public void compareTo_PriceTicket1LessTicket2() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void compareTo_PriceTicket3MoreTicket2() {
        int expected = 1;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void compareTo_PriceTicket1EqualTicket4() {
        int expected = 0;
        int actual = ticket1.compareTo(ticket4);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void sort_ShouldSortPrice(){
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket6);
        avia.add(ticket7);
        avia.add(ticket8);

        Ticket[] expected = {ticket8, ticket1, ticket7, ticket6};
        Ticket[] result = avia.search("Сочи", "Москва");

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void sort_ShouldSortPrice_OneElement(){
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket5);
        avia.add(ticket3);
        avia.add(ticket8);

        Ticket[] expected = {ticket3};
        Ticket[] result = avia.search("Сочи", "Красноярск");

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void sort_ShouldSortPrice_NotElement(){
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket5);
        avia.add(ticket3);
        avia.add(ticket8);

        Ticket[] expected = {};
        Ticket[] result = avia.search("Сочи", "Калининград");

        Assertions.assertArrayEquals(expected,result);
    }

    @Test
    public void compare_TimeFlightFirstLessSecond(){
        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = -1;
        int actual = comparator.compare(ticket1, ticket5);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void compare_TimeFlightFirstMoreSecond(){
        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 1;
        int actual = comparator.compare(ticket5, ticket1);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void compare_TimeFlightFirstEqualSecond(){
        TicketTimeComparator comparator = new TicketTimeComparator();

        int expected = 0;
        int actual = comparator.compare(ticket6, ticket1);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void searchAndSortBy_shoulsSortTimeFlight(){
        AviaSouls avia = new AviaSouls();
        avia.add(ticket8);
        avia.add(ticket7);
        avia.add(ticket6);

        Ticket[] expected = {ticket6, ticket7, ticket8};
        Ticket[] result = avia.searchAndSortBy("Сочи", "Москва", new TicketTimeComparator());
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void searchAndSortBy_shoulsSortTimeFlight_OneElement(){
        AviaSouls avia = new AviaSouls();
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] result = avia.searchAndSortBy("Сочи", "Москва", new TicketTimeComparator());
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void searchAndSortBy_shoulsSortTimeFlight_NotElement(){
        AviaSouls avia = new AviaSouls();
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket1);
        avia.add(ticket7);

        Ticket[] expected = {};
        Ticket[] result = avia.searchAndSortBy("Сочи", "Калининград", new TicketTimeComparator());
        Assertions.assertArrayEquals(expected, result);
    }
}


