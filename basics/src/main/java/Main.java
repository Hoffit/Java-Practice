import java.time.LocalDateTime;
import java.util.Random;

/**
 * This is the main program for CF lab 01.
 * The main method will exercise several new methods which represent the thrust of this lab.
 * It's a hard coded test of several method concepts for the intro to Java syntax.
 */
public class Main {

    /**
     * Main.
     * @param args Input args.
     */
    public static void main(String[] args) {

        // 'pluralize Method Tests'
        // These pluralize tests are from the lab - my understanding is that they were provided as test
        // cases so that we could verify our method behaves as expected.
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        System.out.println();

        // 'flipNHeads' Method Tests
        flipNHeads(1);
        System.out.println();
        flipNHeads(2);
        System.out.println();
        flipNHeads(3);

        System.out.println();

        // 'clock' Method Test
        clock();
    }

    /**
     * Return a string that pluralizes the input noun.
     * @param aWordToPluralize Any noun.
     * @param count The number of noun (any positive integer)
     * @return The pluralized String.
     */
    private static String pluralize(String aWordToPluralize, int count) {

        if(count==1) {
            return aWordToPluralize;
        }
        else if(count==0 || count>1) {
            return aWordToPluralize+'s';
        }
        else return null;
    }

    /**
     * Keep flipping until heads shows up numberOfFlips times.
     * @param numberOfFlips The number of times caller wants to flip heads consecutively. Must be >=1.
     */
    private static void flipNHeads(int numberOfFlips) {

        Random r = new Random();
        int headCount = 0;
        double nextRandomNumber = r.nextDouble();
        int totalFlips = 0;
        while (headCount<numberOfFlips) {
            if(nextRandomNumber<0.5) {
                System.out.println("tails");
                headCount = 0;
            }
            else {
                System.out.println("heads");
                headCount++;

            }
            nextRandomNumber = r.nextDouble();
            totalFlips++;
        }

        System.out.println("It took "+totalFlips+' '+pluralize("flip", totalFlips)+" to flip "+numberOfFlips+" in a row.");
    }

    /**
     * This method will continuously print out the time to the console, until the process is killed.
     */
    private static void clock() {

        LocalDateTime startTime = LocalDateTime.now();
        int startHour = startTime.getHour();
        int startMinute = startTime.getMinute();
        int startSecond = startTime.getSecond();
        LocalDateTime now;
        System.out.println(padTime(startHour)+':'+padTime(startMinute)+':'+padTime(startSecond));
        while(true) {
            now = LocalDateTime.now();
            int currentHour = now.getHour();
            int currentMinute = now.getMinute();
            int currentSecond = now.getSecond();
            if(currentHour!=startHour || currentMinute!=startMinute || currentSecond!=startSecond) {
                System.out.println(padTime(currentHour)+':'+padTime(currentMinute)+':'+padTime(currentSecond));
            }
            startHour = currentHour;
            startMinute = currentMinute;
            startSecond = currentSecond;
        }
    }

    /**
     * Utility method to print time elements consistently as two digits.
     * @param time The int hour, minute, or second to pad.
     * @return The possibly padded time.
     */
    private static String padTime(int time) {
        if(time<10) return '0'+Integer.toString(time);
        else return Integer.toString(time);
    }
}
