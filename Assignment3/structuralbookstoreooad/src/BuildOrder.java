public class BuildOrder {
    public static Component getOrder()
    {
        Component order = new Composite( "Order" ) ;
        order.addChild(
                new Leaf("Guide to Algorithms", 25.50 ));
        order.addChild(
                new Leaf("Math 101", 21.00 ));
        Composite customOrder = new
                Composite( "Build Your Own Bookstore Order Set:" ) ;
        customOrder.addChild(new Leaf("The Economic Times Newsletter", 2.50));
        customOrder.addChild(new Leaf("PSY-102 Psychology, 1st edition", 19.00));
        customOrder.addChild(new Leaf("DC Magazine", 7.00));
        customOrder.addChild(new Leaf("Social Science", 18.00));


        order.addChild(customOrder);

        return order ;
    }
}
