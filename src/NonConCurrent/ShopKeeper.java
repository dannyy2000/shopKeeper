package NonConCurrent;

import java.util.Random;

public class ShopKeeper {

    public static int makePancakes(){
        Random random = new Random();
        int pancakesMade = random.nextInt(13);
        return pancakesMade;
    }
}
