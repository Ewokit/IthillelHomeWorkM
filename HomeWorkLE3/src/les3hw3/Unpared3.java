package les3hw3;

public class Unpared3 {
    public static void main (String args[]){
        un(100);
    }
    public static void un(int n) {
        int i = 0;
        do {
            if (n % 2 != 0); n+=i;
            n--;
            System.out.println(i);

        }
        while (i < n);
    }
}