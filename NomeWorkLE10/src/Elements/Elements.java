package Elements;

import java.util.*;

public class Elements {
    public static void main(String[] args) {
        createCollection(20);
        List<Object> objects = createCollection(20);
        System.out.println("Колекція: ");
        objects.stream().forEach(System.out::println);
        uniqueList(objects);
        System.out.println("Унікальна колекція: ");
        objects.stream().forEach(System.out::println);
    }

    private static void uniqueList(List<Object> objects) {
        Collections.sort(objects, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.getLetter().compareTo(o2.getLetter());
            }
        });
    }

    private static List<Object> createCollection(int ex) {
        List<Object> objects = new ArrayList<>();
        for (int i = 0; i < ex; i++){
            objects.add(new Object(generateaValue()));
        }
        return objects;
    }

    private static String generateaValue() {
        String[] letters = {"N","I","K","I","T","A"," "};
        int index = new Random().nextInt(7);
        return letters[index];
    }
}
