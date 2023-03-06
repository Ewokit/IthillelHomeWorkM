package les3hw3;

public class MidMass {
    public static void main(String[] args) {
        int[] N = new int[]{731, 1, 4, 8, 91, 731, -10,};
        double sum = 0;
        for (int i : N){
            sum += i;
        }
        System.out.println(sum/N.length);
    }
}
