package NonConCurrent;

import java.util.Random;

public class User {

    public static int eatPancakes(int limit){
        Random random = new Random();
        int pancakesToEat = random.nextInt(Math.min(5,limit) + 1);

        return pancakesToEat;
    }
}
