package ConCurrent;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ConCurrentPancakeOrder {

    private int totalPancakesMade = 0;
    private int totalPancakesEaten = 0;
    private int totalOrdersNotMet = 0;
    private int totalPancakesWasted = 0;

    public void processOrders() throws InterruptedException, ExecutionException {
        for (int j = 0; j < 2; j++) {
            Thread.sleep(30000);
            processTimeSlot();
        }
    }

    private void processTimeSlot() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> pancakesMadeFuture = ShopKeeper.makePancakesAsync();

        CompletableFuture<Integer> user1Pancakes = User.eatPancakesAsync(5);
        CompletableFuture<Integer> user2Pancakes = User.eatPancakesAsync(5);
        CompletableFuture<Integer> user3Pancakes = User.eatPancakesAsync(5);

        CompletableFuture<Void> allUsers = CompletableFuture.allOf(user1Pancakes, user2Pancakes, user3Pancakes);
        allUsers.join();

        int pancakesMade = pancakesMadeFuture.get();
        totalPancakesMade += pancakesMade;

        int user1PancakesToEat = user1Pancakes.get();
        int user2PancakesToEat = user2Pancakes.get();
        int user3PancakesToEat = user3Pancakes.get();

        totalPancakesEaten += user1PancakesToEat + user2PancakesToEat + user3PancakesToEat;

        printResults(pancakesMade);
    }

    private void printResults(int pancakesMade) {
        System.out.println("Ending time: " + LocalTime.now());
        System.out.println("Pancakes made by the chef: " + pancakesMade);
        System.out.println("Pancakes eaten by user: " + totalPancakesEaten);

        if (totalPancakesEaten > totalPancakesMade) {
            int ordersNotMet = totalPancakesEaten - totalPancakesMade;
            totalOrdersNotMet += ordersNotMet;
            totalPancakesWasted += totalPancakesMade;
            System.out.println("Orders not met: " + ordersNotMet);
        } else {
            totalPancakesWasted += totalPancakesMade - totalPancakesEaten;
        }

        System.out.println("Pancakes wasted: " + totalPancakesWasted);
    }
}

