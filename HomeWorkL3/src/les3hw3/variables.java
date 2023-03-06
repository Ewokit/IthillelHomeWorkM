package les3hw3;

import java.util.Scanner;

public class variables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("variables1");
        int x = sc.nextInt();
        System.out.println("variables2");
        int n = sc.nextInt();

        int j = 1;
        for (int i = 0; i<n; i++) j *= x;
        System.out.println(j);
    }
}
