package manager;

import java.util.Random;

public class RandomData {

    public static String breedOfCats(){
        String[] array = {"Abyssinian","Birman","Egyptian Mau","Korat",
                "Norwegian Forest Cat","Russian Blue","Persian Traditional"};
        return array[new Random().nextInt(array.length)];
    }
    public static String randomString(int lengthStr){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lengthStr; i++) {
            stringBuilder.append(randomChar());
        }
        return stringBuilder.toString();
    }

    private static char randomChar(){
        return (char) ('a' + Math.random()*('z'-'a')+1);
    }

}
