public class Foo{

    public int x, y;

    public Foo(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static void switcher(Foo a, Foo b){
        Foo temp = a;
        a = b;
        b = temp;
    }

    public static void flipper(Foo a, Foo b){
        Foo temp = new Foo(a.x, a.y);
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void swapper(Foo a, Foo b){
        Foo temp = a;
        a.x = b.x;
        a.y = b.y;
        b.x = temp.x;
        b.y = temp.y;
    }

    public static void main(String[] args) {
        Foo foobar = new Foo(10, 20);
        Foo baz = new Foo(30, 40);
        switcher(foobar, baz);
        flipper(foobar, baz);
        swapper(foobar, baz);
    }
}