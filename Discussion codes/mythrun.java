import java.util.Arrays;

public class mythrun {
    public static void main(String[] args) {
        int[] inputa = new int[]{3,0,4,6,3,88,66, 100, 99};
        System.out.println(Mystery.myth(inputa, 2));
        System.out.println(Mystery.recursiveMyth(inputa, 2));
        System.out.println(Arrays.toString(Mystery.sortArray(inputa)));
    }
}
