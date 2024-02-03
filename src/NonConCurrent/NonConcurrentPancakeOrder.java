package NonConCurrent;

import java.time.LocalTime;

public class NonConcurrentPancakeOrder {


        private int totalPancakesMade = 0;
        private int totalPancakesEaten = 0;
        private int totalOrdersNotMet = 0;
        private int totalPancakesWasted = 0;

        public  void processOrders() throws InterruptedException {
            for (int j = 0; j < 2; j++) {
                Thread.sleep(30000);
                processTimeSlot();
            }
        }

        private  void processTimeSlot() {
            int pancakesMade = ShopKeeper.makePancakes();
            totalPancakesMade += pancakesMade;

            for (int k = 0; k < 3; k++) {
                int userLimit = 5;
                int pancakesToEat = User.eatPancakes(userLimit);
                totalPancakesEaten += pancakesToEat;
                userLimit -= pancakesToEat;
            }

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
                System.out.println(" Orders not met: " + ordersNotMet);
            } else {
                totalPancakesWasted += totalPancakesMade - totalPancakesEaten;
            }

            System.out.println("Pancakes wasted: " + totalPancakesWasted);
        }
    }


