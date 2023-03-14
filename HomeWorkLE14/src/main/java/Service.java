import java.util.Scanner;

public class Service {
    protected static final Converter convert = new Converter();
    protected static final Scanner scanner = new Scanner(System.in);
    static void operate(){
        System.out.print("numbs: ");
        String str = scanner.next();

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException exception){
            System.err.println(exception.getMessage() + "\nOnly numbers");
            System.exit(0);
        }
        convert.converterValue(str.split(" "));
        convert.print();
    }
}
