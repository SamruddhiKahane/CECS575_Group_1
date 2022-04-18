public class Client {
    public static void main(String[] args) {
//        public static void runTest(){
            Component theOrder = BuildOrder.getOrder();
            theOrder.printDescription();
//        }
    }
}
