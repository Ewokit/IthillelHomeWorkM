package les3hw3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[10];
        for (int i = 0; i < 10; i++)
            A[i] = 2 * i + 1;
        System.out.print(Arrays.toString(A));
    }
}
