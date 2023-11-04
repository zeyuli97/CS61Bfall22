package deque;

import java.util.ArrayDeque;
import java.util.Comparator;

public class ArrayCompare<Item> implements Comparator<Item> {
    /**
     * Negative l1 < l2, Positive l1 > l2
     * */
    @Override
    public int compare(Item o1, Item o2) {
        return (int) o1 - (int) o2;
    }
}
