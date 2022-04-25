package com.group1.theBookSpot;

import java.util.List;
import java.util.ArrayList;


public class Book implements Subject {

    private String bookName;

    private boolean available;

    private List<Observer> listOfObservers = new ArrayList<Observer>();

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;

        if(true == available){
            notifyObservers();
        }
    }

    public String getBookName() {
        return bookName;
    }

    public List<Observer> getListOfObservers() {
        return listOfObservers;
    }

    public void setListOfObservers(List<Observer> listOfObservers) {
        this.listOfObservers = listOfObservers;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void registerObserver(Observer observer) {

        listOfObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {

        listOfObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println ("Notifies all the registered customers when books are in stock");
        for (Observer observer : listOfObservers) {

            observer.update(bookName);
        }
        //listOfObservers.notify(observer);

    }
}
