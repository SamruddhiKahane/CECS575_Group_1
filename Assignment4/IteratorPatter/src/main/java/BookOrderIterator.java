import java.util.ArrayList;

public class BookOrderIterator implements OrderIterator{
    int pos = 0;
    ArrayList<BookTransactionDetails> transactionDetailsList;

    public  BookOrderIterator (ArrayList<BookTransactionDetails> transactionDetailsList)
    {
        this.transactionDetailsList = transactionDetailsList;
    }

    @Override
    public boolean hasNext() {
        return pos <= transactionDetailsList.size()-1;
    }

    @Override
    public BookTransactionDetails getNext() {
        if (!hasNext()) {
            return null;
        }
        pos++;
        if(pos < transactionDetailsList.size()) {
            return transactionDetailsList.get(pos);
        }
        return transactionDetailsList.get(pos-1);
    }
}
