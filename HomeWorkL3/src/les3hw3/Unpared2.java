package les3hw3;

public class Unpared2 {
        public static void un(int n) {
            int i = 0;
            while (i < n) {
                if (n % 2 != 0) {
                    System.out.println(n);
                }
                --n;
            }
        }
    public static void main(String args[]) {
        un(100);
    }
}
