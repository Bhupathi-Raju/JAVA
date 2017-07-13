/**
 * Created by zemoso on 13/7/17.
 */
public class AllLettersChecker {
    /**
     * This method takes the input string and creates a boolean array with value=true for the index of (ASCII value-97)
     * only for letters between a-z. Then we check the boolean array to know whether all letters are present or not..
     * @param input This takes the input string that needs to be checked.
     * @return returns the statement whether or not the string has all letters of the alphabet a-z case insensitive.
     */
    public String checkingAllLetters(String input) {
        int lengthOfString = input.length();
        if (lengthOfString < 26)
            return ("Doesn't Contain all letters");
        boolean checkerArray[] = new boolean[26];
        String lowerCaseString = input.toLowerCase();
        char characterArray[] = lowerCaseString.toCharArray();
        for (int i : characterArray) {
            if (i >= 97 && i <= 122) checkerArray[i - 97] = true;
        }
        for (boolean i : checkerArray) {
            if (!i)
                return "Doesn't Contain all letters";
        }
        return "Contain all letters";
    }
}
