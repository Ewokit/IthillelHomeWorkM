package les3hw3;

import java.util.Scanner;

public class Factorial2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 1;
        int i = 1;
        while (i <=n){
            result = result*i;
            i++;
        }
        System.out.println(result);
    }
}
