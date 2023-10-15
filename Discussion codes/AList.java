public class AList<Item>{
    private Item[] items;
    private int size;

    public AList(){
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(){
        Item[] a = (Item[]) new Object[size * 2];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addlast(Item x){
        if (size == items.length){
            resize();
        }
        items[size] = x;
        size = size += 1;
    }
    
    public Item getlast(){
        return items[size - 1];
    }

    public void addfirst(Item x){
        if ((size+1) >= items.length){
            resize();
        }
        Item[] a = (Item[]) new Object[size * 2];
        System.arraycopy(items, 0, a, 1, size);
        a[0] = x;
        items = a;
    }

    public Item getfirst(){
        return items[0];
    }

    public Item removelast(){
        Item x = getlast();
        size = size -1;
        return x;
    }

    public Item getitem(int i){
        return items[i-1];
    }

    public static void main(String[] args){
        AList<Integer> a = new AList<Integer>();
        int i = 0;
        while (i < 1000){
            a.addlast(i);
            i++;
        }
        System.out.println(a.getlast());
        System.out.println(a.getfirst());
        a.addfirst(-1);
        System.out.println(a.getitem(667));

    }

}