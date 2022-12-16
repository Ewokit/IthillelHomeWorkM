import java.util.Scanner;

public class Main1 {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentProc studentProc = new StudentProc();

    public static void main(String[] args) {
        action();
    }

    private static void action() {
        System.out.println("(1) - Показати список студентів факультету.");
        System.out.println("(2) - Показати список студентів для факультету та курсу.");
        System.out.println("(3) - показати список студентів, які народилися після цього року.");
        System.out.println("(4) - показати список студентів даної групи.");
        switch (sc.next().toUpperCase()) {
            case "1":
                System.out.print("Режисура | Хорове\nEnter faculty: ");
                studentProc.showListFaculty(sc.next().toUpperCase());
                action();
                break;
            case "2":
                System.out.print("Режисура | Хорове\nEnter faculty: ");
                String faculty = sc.next().toUpperCase();
                System.out.print("1 | 2 | 3 | 4\nEnter course: ");
                int course = sc.nextInt();

                studentProc.showListFandC(faculty, course);
                action();
                break;
            case "3":
                System.out.println("\nEnter year:");
                studentProc.showListStYear(sc.nextInt());
                action();
                break;
            case "4":
                System.out.println("\nEnter group:");
                studentProc.showListStGroup(sc.next());
                break;
            default:
                System.out.println("Спробуй ще");
        }
    }
}
