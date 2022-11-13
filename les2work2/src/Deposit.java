import java.util.Scanner;

public class Deposit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Сумма в гривнах");
        int sum = sc.nextInt();
        System.out.println("Введите процент");
        double prcent = sc.nextDouble();
        System.out.print("На сколько лет");
        int years = sc.nextInt();

        System.out.printf("\nЗа 100 лет вы получили %d гривен\n", sum);

        System.out.println("Депозит в размере " + sum + " под " + prcent + "% годовых на " + years + " лет:\n");

        for (int i = 1; i < years + 1; i++) {
            sum += (sum * prcent) / 100;
            System.out.printf("Год - " + i + "Сумма: " + "%d\n", sum);
        }
    }
}
