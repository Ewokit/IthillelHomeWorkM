package les3hw3;

import java.util.Scanner;

public class Factorial3 {
    public static void main(String[] args) {
        int n;
        int result;
        int i;
        do {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            result = 1;
            i = 1;
            result = result*i;
            i++;
            System.out.println(result);
        }
        while (i <=n);{
            System.out.println(result);
        }
    }
}
