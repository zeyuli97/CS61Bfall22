public class dogrun {
    public static void main(String[] args) {
        int size = 27;
        String name = "Fido";
        Dog mydog = new Dog(name,size);
        Dog yourdog = new Dog("Scruffy", 1000);
        Dog[] doglist = new Dog[3];
        doglist[0] = mydog;
        doglist[1] = yourdog;
        doglist[2] = new Dog("pipi",5);
        doglist[3] = new Dog("yaya", 4);
        doglist[4] = new Dog("yoyo", 24);
    }
}
