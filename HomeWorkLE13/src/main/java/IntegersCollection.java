import java.util.List;

public abstract class IntegersCollection {
    public static double integerCollection(List<Integer> integersList){
        return integersList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }
}
