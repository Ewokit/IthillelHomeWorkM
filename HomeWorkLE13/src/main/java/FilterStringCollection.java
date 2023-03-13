import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class FilterStringCollection {
    public static List<String> filterCollection(List<String> strings){
        List<String> stringList = new ArrayList<>();
        strings.stream().filter(s -> s.length() == 4);
        strings.stream().filter(s -> s.equals(s.toLowerCase()));
        strings.stream().forEach(stringList :: add);
        return stringList;
    }
}
