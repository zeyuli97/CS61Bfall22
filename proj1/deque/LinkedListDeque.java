package deque;

import java.util.Iterator;

/**
 * This approach I am using double linked list method.
 * So each node, we have three items in following order: stored value, previous node address, next node address.
 * By this design, we will have constant time for add and remove function.
 *  !!! The get function can be optimized, but have not done so. !!!
 *  Idea: depend on the index number and size//2, we will navigate using next node or previous node.
 *
 *  A easier way to think is: sentinel.next --> first item. if we change sentinel.next, we only change the direction
 *  from sentinel to somewhere else, first item is untouched. We can still access first item use sentinel.first.
 * */
public class LinkedListDeque <Item> implements Iterable<Item>, Deque<Item>{

    public class IntNode{
        public Item item;
        public IntNode next;

        public IntNode prev;

        public IntNode(Item x, IntNode prevnode, IntNode nextnode){
            item = x;
            next = nextnode;
            prev = prevnode;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListDequeIterator();
    }
    private class LinkedListDequeIterator implements Iterator<Item>{
        int tracker;
        IntNode current;

        public LinkedListDequeIterator(){
            tracker = size;
            current = sentinel.next;
        }
        @Override
        public boolean hasNext() {
            return tracker != 0;
        }

        @Override
        public Item next() {
            Item x = current.item;
            current = current.next;
            tracker --;
            return x;
        }
    }
    /**
     * Modified IntNode to communicate prev and next
     * */
    // The technique used before to handle empty double linked list
    private IntNode sentinel;
    private int size; // Constant size function will call

    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    public LinkedListDeque(Item x){
        sentinel = new IntNode(null, null, null);
        IntNode p = new IntNode(x, sentinel, sentinel);
        sentinel.next = p;
        sentinel.prev = p;
        size = 1;
    }

    @Override
    public void addFirst(Item x){
        IntNode p = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = p;
        /**
         * Here is the tricky part, because not only we need to modify the sentinel we also need to change the original
         * first item, because it can no longer point to sentinel. The original first item need to point to the new
         * first item, and the new item also need to point to the old first.
         * */

        sentinel.next = p;

        size += 1;
    }

    public Item getFirst(){
        if (size == 0){
            return null;
        }
        return sentinel.next.item;
    }
    @Override
    public void addLast(Item x){
        IntNode p = new IntNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public Item getLast(){
        if (size == 0){
            return null;
        }
        return sentinel.prev.item;
    }
    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        IntNode p = sentinel;
        while (p.next.item != null){
            System.out.print(p.next.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public Item removeFirst(){
        if (size == 0){
            return null;
        }
        Item x = getFirst();
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return x;
    }

    @Override
    public Item removeLast(){
        if (size == 0){
            return null;
        }
        Item x = getLast();
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return x;
    }

    @Override
    public Item get(int index){
        if (size == 0){
            return null;
        }
        if (index == 0){
            return getFirst();
        }
        if (index == size-1){
            return getLast();
        }
        if (index >= size){
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i <= index; i++){
            p = p.next;
        }
        return p.item;
    }

    public Item getRecursive(int index){
        if (size == 0){
            return null;
        }
        if (index == size - 1){
            return getLast();
        }
        if (index >= size){
            return null;
        }
        IntNode p = sentinel.next;
        return get_recursion_helper(index, p);
    }

    private Item get_recursion_helper(int index, IntNode p){
        if (index == 0){
            return p.item;
        }else{
            return  get_recursion_helper(index-1, p.next);
        }

    }

    public boolean equals(Deque<Item> target){
        if (size != target.size()){
            return false;
        }
        for (int i = 0; i < size; i ++){
            if (this.get(i) != target.get(i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        System.out.println(l.isEmpty());
        l.addFirst(1);
        System.out.println(l.getLast());
        l.addLast(2);
        l.addLast(3);
        l.addFirst(0);
        l.printDeque();
        System.out.println(l.get(3));
        l.addLast(4);
        l.addLast(5);
        System.out.println(l.isEmpty());
        l.isEmpty();
        l.printDeque();
        ArrayDeque<Integer> l2 = new ArrayDeque<>(0);
        l2.addLast(1);
        l2.addLast(2);
        l2.addLast(3);
        l2.addLast(4);
        l2.addLast(5);
        l2.printDeque();
        System.out.println(l2.get(0));



    }

}
