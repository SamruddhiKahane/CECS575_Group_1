import java.util.ArrayList;

public class OrderAggregatorImpl implements Aggregator{

    ArrayList<BookTransactionDetails> details =new ArrayList<>() ;

    public OrderAggregatorImpl() {
        details.add(0,new BookTransactionDetails("B001","T301",230,5,2,"ID000123"));
        details.add(1,new BookTransactionDetails("B023","T717",20,9,1,"ID000863"));
        details.add(2,new BookTransactionDetails("B056","T056",75,20,1,"ID004523"));
        details.add(3,new BookTransactionDetails("B065","T098",43,5,3,"ID076543"));
        details.add(4,new BookTransactionDetails("B012","T0765",124,8,4,"ID8970123"));
        details.add(5,new BookTransactionDetails("B0054","T0343",180,15,5,"ID324123"));
    }

    @Override
    public BookOrderIterator createIterator() {
        return new BookOrderIterator(details);
    }
}
