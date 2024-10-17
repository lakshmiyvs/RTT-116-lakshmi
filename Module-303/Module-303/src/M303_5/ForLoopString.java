package M303_5;

public class ForLoopString {
    public static void main(String[] args) {

        // looping over the characters in a string
        String characters = "abcdefg";

        // not that string.length() does use the ()
        for ( int pos = 0 ; pos < characters.length() ; pos++ ) {
            // in the string we are using the method charAt to get the character at a position
            char value = characters.charAt(pos);
            System.out.println( "characters at position" + pos + " = " + characters.charAt(pos));
        }

        // converstion of a string or character into an integer
        // character with the value 1
        char one = '1';
        Character c = Character.valueOf(one);
        int x = Integer.parseInt(c.toString());
    }
}
