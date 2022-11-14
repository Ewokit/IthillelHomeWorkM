package les3hw3;

import java.util.Scanner;

public class Table {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numb = 0;
        System.out.println("Число от 1 до 10:");
        numb = sc.nextInt();
        for(int i = 1; i <=10; i++){
            System.out.println(numb + " * " + i + " = " + numb * i);
        }
    }
}
