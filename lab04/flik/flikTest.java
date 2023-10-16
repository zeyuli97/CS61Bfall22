package flik;
import java.util.Random;
public class flikTest {

    public static void main(String[] args) {
        Random rand = new Random();
        int n1 = rand.nextInt(1000);
        int n2 = n1;
        int counter = 0;
        while (Flik.isSameNumber(n1,n2) || counter < 100){
            n1 = rand.nextInt(1000);
            n2 = n1;
            counter ++;
            System.out.println(n1);
            System.out.println(n2);
            System.out.println(Flik.isSameNumber(n1,n2));
        }
    }
}
