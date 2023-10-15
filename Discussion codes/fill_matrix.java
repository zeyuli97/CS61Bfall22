import java.util.Arrays;

public class fill_matrix {
    public static void fill_matrix(int[] ll, int[] ur, int[][] s) {
        int n = s.length;
        int kl, kr;
        kl = kr = 0;
        for (int i = 0; i < n; i += 1){
            for (int j = 0; j < n; j ++){
                if (i == j){} else if (i < j){
                    s[i][j] = ur[kr];
                    kr += 1;
                } else {
                    s[i][j] = ll[kl];
                    kl += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ll = {1,2,3,4,5,6,7,8,9,10,11,12};
        int[] ur = {11,12,13,14,15,16,17,18,19,20};
        int[][] s = {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
        };
        fill_matrix(ll, ur, s);
        System.out.println(Arrays.deepToString(s));
    }
}
