package deque;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDeque<Item> implements Iterable<Item>, Deque<Item>{

    /**
     * Some thoughts
     * In order to have constant time to run addFirst, Arraycopy is not valid.
     * Therefore, we need to reserve some space for head, so we can insert it and update the head position.
     * The index User inputs into ArrayDeque is not the real index, we need to somehow transfer the user inputs.
     * ***
     * Current idea, create an odd length of array.
     * Suppose length is 101, now the index 50 is where we start to store the first item (index 0 for user).
     * If addFirst is called, we insert at position index 49 and lie to user this is the new index 0.
     * Key thing is to keep track of where the head is. The tail is relative easy head position plus size.
     *
     * I did some simple test case which are all passed.
     * The mean idea about resize() is that always relocate the head of all size to the middle of new array generated.
     * In this manner, the resize() factor need to be greater than 2. Smaller than 2 will yield out of bound error.
     * */

    private int len;

    private int size;
    private Item[] items;

    int head;

    int tail;



    public ArrayDeque(){
        size = 0;
        items = (Item[]) new Object[5];
        head = items.length/2;
        tail = head;
        len = (items.length)/2;
    }

    public  ArrayDeque(Item x){
        size = 1;
        items = (Item[]) new Object[5];
        head = items.length/2;
        tail = size + head - 1;
        items[head] = x;
        len = (items.length)/2;
    }

    @Override
    public void addFirst(Item x){
        if (head == 0){
            resize();
        }
        size += 1;
        head -= 1;
        items[head] = x;
    }

    public Item getFirst(){
        return items[head];
    }

    @Override
    public void addLast(Item x){
        tail = size + head;
        if (tail >= items.length){
            resize();
        }
        size += 1;
        items[tail] = x;
    }

    public Item getLast(){
        return items[head + size - 1];
    }

    public void resize(){
        int mul = 3;
        Item[] a = (Item[]) new Object[items.length * mul];
        int new_head = (a.length / 2);
        System.arraycopy(items, head, a, new_head, size);
        items = a;
        tail = (new_head + size);
        len = (a.length / 2);
        head = new_head;

    }

    @Override
    public Item removeFirst(){
        if (size == 0){
            return null;
        }
        Item x = getFirst();
        items[head] = null;
        head += 1;
        size = size -1;
        double ratio = (double) size/ items.length;
        if (ratio < 0.25){
            shrink();
        }
        return x;
    }

    @Override
    public Item removeLast(){
        if (size == 0){
            return null;
        }
        Item x = getLast();
        tail = size + head - 1;
        items[tail] = null;
        size = size -1;
        double ratio = (double) size/ items.length;
        if (ratio < 0.25){
            shrink();
        }
        return x;
    }

    public void shrink(){
        int factor = 2;
        Item[] a = (Item[]) new Object[(items.length/factor) + 2];
        int new_head = (a.length / 2);
        System.arraycopy(items, head, a, new_head, size);
        items = a;
        tail = (new_head + size) - 1;
        len = (a.length / 2);
        head = new_head;
    }


    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        for (int i = head; i < (head + size); i ++){
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public Item get(int index){
        return items[index + head];
    }

    public boolean equals(){
        return true;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayDequeIterator();
    }
    private class ArrayDequeIterator implements Iterator<Item>{
        private int position;

        public ArrayDequeIterator(){
            position = head;
        }
        @Override
        public boolean hasNext() {
            return position <= tail;
        }

        @Override
        public Item next() {
            Item x = items[position];
            position += 1;
            return x;
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> a = new ArrayDeque<>(0);
        a.addFirst(-1);
        a.addFirst(-2);
        a.addLast(1);
        a.addLast(2);
        System.out.println(a.getFirst());
        a.addFirst(-3);
        a.addLast(3);
        System.out.println(a.getLast());
        for (int i = -4; i >= -1000; i --){
            a.addFirst(i);
        }
        System.out.println(a.getLast());
        a.printDeque();
        System.out.println(a.get(0));
        System.out.println(a.getFirst());
        System.out.println(a.get(1));
        System.out.println(a.get(2));
        System.out.println(a.get(a.size() - 1));
        System.out.println(a.getLast());
        a.removeFirst();
        a.removeFirst();
        a.printDeque();
        a.removeLast();
        a.removeLast();
        a.printDeque();
        System.out.println(a.size());
        for (int i = 0; i < 996; i ++){
            a.removeFirst();
        }
        for (int x: a){
            System.out.println(x);
        }
        a.printDeque();
        System.out.println(a.isEmpty());
    }
}
