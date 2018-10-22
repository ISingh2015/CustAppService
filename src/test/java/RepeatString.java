import java.util.Scanner;

/**
 *
 * @author Inderjit Singh Sanhotra
 */
public class RepeatString {

    public static void main(String... args) {
        int num = 2, p = 0, result = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter star power : ");
        p = sc.nextInt();
        if (p < 0) {
            System.out.println("Cold not evaluate");
            return;
        }
        for (int i = 0; i < p; i++) {
            result = result * num;
        }
        System.out.println(starString(result)); // print the * string to console.
    }

    /**
     * StarString method with repeat parameter
     *
     * @param times
     */
    public static String starString(int times) {
        String rtnStr = new String(new char[times]).replace("\0", "*"); // build * string. 
        return rtnStr;
    }

}
