package com.group1.theBookSpot;

public class Customer implements Observer {

    private String CustomerName;
    private Subject subject;

    private String email;

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void EmailNotification(String email) {
        this.email = email;

    }

    //@Override
   // @Override
  //  public void update(String email) {
   //     System.out.println("Email to " + email + ": Book is available");
   // }

    @Override
    public void update(String bookName) {
        System.out.println("Email to " + email + ": Book is available");
        System.out.println("Hello " + CustomerName + ", " + bookName + " is available at theBookSpot");
        System.out.print(System.lineSeparator());

    }
}
