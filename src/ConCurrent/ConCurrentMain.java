package ConCurrent;

import java.util.concurrent.ExecutionException;

public class ConCurrentMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ConCurrentPancakeOrder conCurrentPancakeOrder = new ConCurrentPancakeOrder();
        conCurrentPancakeOrder.processOrders();

    }
}
