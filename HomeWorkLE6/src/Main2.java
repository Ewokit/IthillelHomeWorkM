import java.util.Scanner;

public class Main2 {
    public static final Scanner sc = new Scanner(System.in);
    public static final SubscriberServiceImpl SSI = new SubscriberServiceImpl();
    public static final Subscriber[] userBase = UserBase.createUserBase();

    public static void main(String[] args) {
        action();
    }

    private static void action() {
        System.out.println("(1) Показати користувачів, які перевищують міський дзвінок.");
        System.out.println("(2) Показати користувачів, які використовували міжміський дзвінок.");
        System.out.println("(3) Відображати користувачів за першою літерою прізвища.");
        System.out.println("(4) Показати споживання інтернет-трафіку в місті.");
        System.out.println("(5) Показати кількість користувачів з негативним балансом.");
        System.out.println("(E) Вийти з програми.");
        String user = sc.next();

        switch (user) {
            case "1":
                System.out.println();
                SSI.UserExceedCityCall(userBase, sc.nextInt());
                action();
                break;
            case "2" :
                System.out.println();
                SSI.UserUsedIntercityCall(userBase);
                action();
                break;
            case "3" :
                System.out.println();
                SSI.UsersFirstLetterOfSurname(userBase, sc.next());
                action();
                break;
            case "4" :
                System.out.println();
                int tr = SSI.InternetTrafficConsumptionCity(userBase,sc.next());
                if (tr>0){
                    System.out.println("\nІнтернет трафик:" + tr/10 + "Gb");
                }
                action();
                break;
            case "5" :
                System.out.println();
                int ct = SSI.NumberUsersWithNegativeBalance(userBase);
                System.out.println("Користувачі з негативним балансом:" + ct);
                action();
                break;
            case "E" :
                System.out.println("\nЗакінчення роботи:");
                System.exit(0);
                break;
            default:{
                System.out.println("Спробуй ще:");
                action();
                break;
            }
        }
    }
}
