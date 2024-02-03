package NonConCurrent;

public class NonConCurrentMain {


    public static void main(String[] args) throws InterruptedException {
        NonConcurrentPancakeOrder nonConcurrentPancakeOrder = new NonConcurrentPancakeOrder();
        nonConcurrentPancakeOrder.processOrders();
    }
}
