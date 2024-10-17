package M303_11;

import java.util.ArrayList;
import java.util.List;

public class GenericExample {
    public static void main(String[] args) {

        // basically the type between <> is the only type allowed into the list
        // in older version of Java it was required on both sides of the = but new versions only require left side
        List<String> strings = new ArrayList<String>();
        strings.add("String1");
        //strings.add(1);

        // this one will only allow integers to be in the list
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        //ints.add("Strings2");
    }
}
