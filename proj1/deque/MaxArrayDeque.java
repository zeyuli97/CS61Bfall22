package deque;

import  java.util.Comparator;

public class MaxArrayDeque<Item> extends ArrayDeque<Item>{
    private Comparator<Item> ruler;

    public MaxArrayDeque(Comparator<Item> c){
        super();
        ruler = c;
    }

    public Item max(){
        if (this.isEmpty()){
            return null;
        }
        int maxindex = 0;
        for (int i = 0; i < (this.size()); i ++){
            if (ruler.compare(this.get(maxindex), this.get(i)) < 0){
                maxindex = i;
            }
        }
        return this.get(maxindex);

    }

    public Item max(Comparator<Item> c) {
        if (this.isEmpty()) {
            return null;
        }
        int maxindex = 0;
        for (int i = 0; i < (this.size()); i++) {
            if (c.compare(this.get(maxindex), this.get(i)) < 0) {
                maxindex = i;
            }
        }
        return this.get(maxindex);
    }

    public static void main(String[] args) {
        MaxArrayDeque<Integer> l = new MaxArrayDeque<>(new ArrayCompare<Integer>());
        l.addFirst(5);
        l.addLast(4);
        l.addFirst(3);
        l.addLast(10);
        l.addLast(7);
        l.addLast(4);
        l.addFirst(-1);
        l.addLast(-10);
        l.printDeque();
        System.out.println(l.max(new WeirdArrayComp<Integer>()));
    }

}
