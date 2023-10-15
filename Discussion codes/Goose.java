public class Goose implements Honker{
    public void pester(Vehicle victim){
        System.out.println("Bep!");
    }

    // Method overloading example
    public  void pester(Plane p){
        System.out.println("Squawk!");
    }
}
