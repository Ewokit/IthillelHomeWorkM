import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ConvertStringCollection {
    public static List<Bi> convertCollection(String[] strings){
        List<Bi> bi1 = new ArrayList<>(strings.length);
        Arrays.stream(strings).forEach(n -> bi1.add(new Bi(n)));
        return bi1;
    }

    public static class Bi {
        final String[] strings = new String[2];
        Bi(String str){
            strings[0] = str;
            strings[1] = str.toUpperCase();
        }
        public String toString(){
            return "(" + strings[0] + ":" + strings[1] + ")";
        }
    }
}
