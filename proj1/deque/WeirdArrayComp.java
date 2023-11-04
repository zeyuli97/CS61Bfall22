package deque;

import java.util.Comparator;

public class WeirdArrayComp<Item> implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        int a = (int) o1;
        int b = (int) o2;
        return -a - -b;
    }
}
