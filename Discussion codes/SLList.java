public class SLList<Z> {
    private class Node{
        public Z item;
        public Node next;

        public Node(Z i, Node n){
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    // caching the size for later calls
    private int size;

    /** Update the method to sentinel to deal with empty Sllist*/

    public SLList(){
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(Z x){
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public Z getFirst(){
        return sentinel.next.item;
    }

    public void addFirst(Z x){
        size = size + 1;
        sentinel.next = new Node(x, sentinel.next);
    }

    public void addLast(Z x){
        Node p = sentinel;
        size += 1;

        while (p.next != null){
            p = p.next;
        }

        p.next = new Node(x, null);
    }


    public static void main(String[] args) {
        SLList<Integer> L = new SLList<>(15);
        System.out.println(L.getFirst());
        L.addFirst(9);
        System.out.println(L.getFirst());
        L.addLast(77);
        System.out.println(L.size);

    }
}