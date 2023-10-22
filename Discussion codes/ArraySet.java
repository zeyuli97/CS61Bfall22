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
        for (int i = 0; i < items.length; i ++){
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
        }
        items[size] = input;
        size += 1;
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


}
