public class CatBus implements Vehicle, Honker{

    @Override
    public void revEngine() {
        System.out.println("Purrr");
    }

    @Override
    public void honk() {
        System.out.println("CatBus says HONK!");
    }

    public void conversation(Honker target){
        honk();
        target.honk();
    }

    public static void main(String[] args) {
        CatBus cat = new CatBus();
        Goose g = new Goose();
        cat.conversation(g);
    }
}
