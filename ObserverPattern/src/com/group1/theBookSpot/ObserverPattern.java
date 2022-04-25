package com.group1.theBookSpot;

import java.io.File;
import java.util.EventListener;

public class ObserverPattern {

    public static void main (String[] args)
    {
        Customer Customer1 = new Customer();
        Customer1.setCustomerName("John");
        Customer1.setEmail("John123@thebookspot.com");


        Customer Customer2 = new Customer();
        Customer2.setCustomerName("Rob");
        Customer2.setEmail("Rob456@thebookspot.com");


        Book novels = new Book();
        novels.setBookName("The Kite Runner");
        novels.setAvailable(false);

        novels.registerObserver(Customer1);
        novels.registerObserver(Customer2);

        // Once the novels are in stock customer gets a notification
        novels.setAvailable(true);

        // Customer2 wants to unregister from notification list for availability of books - Can use below code to unregister

        // novels.removeObserver(Customer2);

        // novels.setAvailable(true);


    }
}
