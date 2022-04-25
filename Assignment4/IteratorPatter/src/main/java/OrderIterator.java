public interface OrderIterator {
    boolean hasNext();

    BookTransactionDetails getNext();
}
