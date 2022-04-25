public class BookTransactionDetails {
    private String bookId;
    private String orderId;
    private int price;
    private int in_stock;
    private int no_Purchased;
    private String isbn;

    public BookTransactionDetails(String bookId, String orderId, int price, int in_stock, int no_Purchased, String isbn) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.price = price;
        this.in_stock = in_stock;
        this.no_Purchased = no_Purchased;
        this.isbn = isbn;
    }
}
