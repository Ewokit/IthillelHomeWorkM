import java.util.Arrays;

public class Converter {
    private final StringBuilder[] stringBuilders = new StringBuilder[5];

    Converter(){
        Arrays.setAll(stringBuilders, value -> new StringBuilder());
    }
    public void converterValue(String[] strings){
        Arrays.stream(strings).forEach(this::addString);
    }
    private void addString(String str){
        String[] strings = Symbol.string(str).split("\\.");
        for (int i = 0; i < stringBuilders.length; i++){
            stringBuilders[i].append(strings[i]).append("  ");
        }
    }
    public void print(){
        Arrays.stream(stringBuilders).forEach(System.out::println);
    }
}
