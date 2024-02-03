package ConCurrent;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class ShopKeeper {

    public static CompletableFuture<Integer> makePancakesAsync() {
        return CompletableFuture.supplyAsync(() -> {
            Random random = new Random();
            int pancakesMade = random.nextInt(13);
            return pancakesMade;

        });
    }
}

