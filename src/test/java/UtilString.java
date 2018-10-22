
/**
 *
 * @author Inderjit Singh Sanhotra
 */
public class UtilString {

    /**
     * Usage UtilString.reverseSring("SampleString);
     *
     * @param strToReverse
     * @return
     */
    public static String reverseString(String strToReverse) {
        char ch[] = strToReverse.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        return rev;
    }
}
