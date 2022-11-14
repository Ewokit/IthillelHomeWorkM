package les3hw3;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MassN {
    public static void main(String[] args) {
        int[] N = new int[] {10, 1, 4, 8, 91, 731, -10};
        Arrays.stream(N).filter(n -> n == Arrays.stream(N).min().getAsInt()).forEach(System.out::println);
        System.out.println(Arrays.toString(N));
    }
}
