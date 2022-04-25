// Contains collection of Book Transaction Details as an object

import java.awt.print.Book;

public class OrderCollection {
    OrderAggregatorImpl orderAggregator;

    public OrderCollection(OrderAggregatorImpl orderAggregator) {
        this.orderAggregator = orderAggregator;
    }

    public void showBookTransaction()
    {
        OrderIterator iterator = orderAggregator.createIterator();
        while (iterator.hasNext())
        {
            BookTransactionDetails n = (BookTransactionDetails) iterator.getNext();
            System.out.println(n.toString());
        }
    }
}
