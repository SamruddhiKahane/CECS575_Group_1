public class IteratorPattern {
    public static void main(String args[])
    {
        OrderAggregatorImpl orderAggregator = new OrderAggregatorImpl();
        OrderCollection orderCollection = new OrderCollection(orderAggregator);
        orderCollection.showBookTransaction();
    }
}
