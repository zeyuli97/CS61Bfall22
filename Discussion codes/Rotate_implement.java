import java.util.Arrays;

public class Rotate_implement {
    public static int[] rotate(int[] A, int k){
        int [] B = new int[A.length];
        int movement = k % B.length;
        if (movement < 0){ movement = movement + B.length;}
        movement = B.length - movement;
        for (int i = 0; i < B.length; i++){
            B[i] = A[(i + movement) % B.length];
        }
        return B;
    }


    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3,4,5,6,7};
        int[] b = rotate(a, -9);
        System.out.println(Arrays.toString(b));
    }

}

