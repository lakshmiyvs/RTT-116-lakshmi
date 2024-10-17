package M303_11;

import java.util.*;

public class ListSetExample {
    public static void main(String[] args) {

        // this is used 95% of the time - vast majority of what we do as engineers uses a list
        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(3);
        intList.add(3);
        intList.add(1);

        for (Integer i : intList) {
            System.out.println(i);

            if (i == 3) {
                // important to know
                // you can not remove an element from the list inside a regular 4 loop
                // it is always wrong and will cause an exception
            }
        }

        // ----------- iterator

        // first we need to get the iterator from the list
        Iterator<Integer> iterator = intList.iterator();

        // loop over the list using an iterator, we check to make sure the iterator (list) has a next element
        while (iterator.hasNext()) {
            // the .next function is actually 2 operations, first is to return the element at the pointer and second to move the pointer over 1 element
            Integer i = iterator.next();

            // primary use for an iterator is when you want to remove something from the list while you are iterating the list
            if (i == 3) {
                // this is the correct way of removing an item from the list while looping over the list
                iterator.remove();
            }
        }

        System.out.println("=============================");

        // important to understand what a set is - basically it can be used to deduplicate data
        // it may appear to be maintaining some kind of order when its printed but I assure you that it is not
        Set<String> intSet = new HashSet<>();
        intSet.add("three");
        intSet.add("one");
        intSet.add("three");
        intSet.add("two");


        // not only did it not maintain the order in which I added the elements
        // it removed the duplicate 3 that I added
        for (String i : intSet) {
            System.out.println(i);
        }
    }

}