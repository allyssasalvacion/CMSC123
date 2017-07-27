package FirstLongExam;

/**
 * Created by Allyssa Albores on 18/07/2017.
 */
public class AmicablePair {

    private static boolean amicablePair(int a, int b) {
        int x = 1;
        int y = 1;

        for(int i = 2; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                x += i;
                x += (a/i);
            }
        }

        for(int i = 2; i <= Math.sqrt(b); i++) {
            if(b % i == 0) {
                y += i;
                y += (b/i);
            }
        }

        return (x == b && y == a);
    }

    public static void main(String[] args) {
        int a = 220;
        int b = 284;

        boolean tr = amicablePair(a, b);

        System.out.println(tr);
    }
}
