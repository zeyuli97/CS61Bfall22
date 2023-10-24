import java.util.Iterator;

public class ArraySet<T> implements Iterable<T>{
    private int size;
    private T[] items;

    private boolean tracknull;

    public ArraySet(){
        size = 0;
        items = (T[]) new Object[100];
        tracknull = false;
    }

    public boolean contains(T input){
        if (input == null){
            return tracknull;
            }
        for (int i = 0; i < size; i ++){
            if (items[i].equals(input)){
                return true;
            }
        }
        return false;
    }

    public void add(T input){
        if (contains(input)){
            System.out.println("ArraySet already contains this element.");
            return;
        }
        if (input == null){
            tracknull = true;
            size += 1;
            return;
        }
        items[size] = input;
        size += 1;
    }

    public void addMulti(T[] input){
        for (int i = 0; i < input.length; i ++){
            if (contains(input[i])){
                System.out.println("ArraySet already contains this element.");
                return;
            }
            if (input[i] == null){
                tracknull = true;
                size += 1;
                return;
            }
            items[size] = input[i];
            size += 1;
        }
    }

    public int getSize(){
        return size;
    }

    @Override
    public boolean equals(Object input){
        if (input instanceof ArraySet other){
            if (size != other.size){
                return false;
            }
            if (this.tracknull != other.tracknull){
                return false;
            }
            for (T item : this){
                if (!other.contains(item)){
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T>{
        private int position;

        public ArraySetIterator(){
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return (size > position);
        }

        @Override
        public T next() {
            T nextitem = items[position];
            position ++;
            return nextitem;
        }
    }

    @Override
    public String toString(){
        StringBuilder return_string = new StringBuilder("{");
        for (int i = 0; i < size - 1; i ++){
            // The below item[i].toString() is calling toString() function of type T (i.e. Integer)
            return_string.append(items[i].toString());
            return_string.append(", ");
        }
        return_string.append(items[size - 1]);
        return_string.append("}");
        return return_string.toString();
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(1);
        aset.add(2);
        aset.add(3);
        aset.add(null);
        System.out.println(aset.getSize());
        aset.add(null);
        System.out.println(aset.getSize());
        System.out.println(aset);

        ArraySet<Integer> bset = new ArraySet<>();
        Integer[] b = new Integer[]{1,2,3};
        bset.addMulti(b);
        System.out.println(bset);
        bset.add(null);
        bset.add(null);
        System.out.println(aset.equals(bset));
    }

}
