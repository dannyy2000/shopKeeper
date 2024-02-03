package ConCurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class User {
    public static CompletableFuture<Integer> eatPancakesAsync(int limit) {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int pancakesToEat = random.nextInt(Math.min(5,limit) + 1);
            return pancakesToEat;
        });
    }
}
