package les3hw3;

import java.util.Arrays;

public class MassNX {
    public static void main(String[] args) {
        int[] N = new int[] {731, 1, 4, 8, 91, 731, -10,};
        Arrays.stream(N).filter(n -> n == Arrays.stream(N).max().getAsInt()).forEach(System.out::println);
        System.out.println(Arrays.toString(N));
    }
}
