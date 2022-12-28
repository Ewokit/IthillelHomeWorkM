import java.util.Arrays;

public class MainCol {
    public static void main(String[] args) {
        CollectionImpl coll = new CollectionImpl();
        for (int i = 0; i < coll.getElement().length; i++){
            coll.add(String.valueOf(i));
        }
        boolean add = coll.add("i1");
        System.out.println("додати 'i1': " + add);
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        boolean addByIndex = coll.add(5, "string i15");
        System.out.println("додати в [15]: " + addByIndex);

        addByIndex = coll.add(-10, "add");
        System.out.println("додати в [-10]: " + addByIndex);

        addByIndex = coll.add(5, "add");
        System.out.println("додати в [5]: " + addByIndex);
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        boolean delete = coll.delete("9");
        System.out.println("видалити '9': " + delete);

        delete = coll.delete("значення");
        System.out.println("видалити 'значення': " + delete);
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        String get = coll.get(3);
        System.out.println("отримати від [3]: " + get);

        get = coll.get(coll.size() - 8);
        System.out.println("отримати від [розмір - 8]: " + get);

        get = coll.get(coll.size());
        System.out.println("отримати від [розмір]: " + get);
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        boolean contain = coll.contain("i10");
        System.out.println("містять 'i10': " + contain);

        contain = coll.contain("значення");
        System.out.println("містять 'значення': " + contain);
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        boolean equals = coll.equals(coll.getElement());
        System.out.println("рівні: " + equals);

        String[] tmpTestArray = Arrays.copyOf(coll.getElement(), coll.getEx() - 1);

        equals = coll.equals(tmpTestArray);
        System.out.println("рівні: " + equals);
        System.out.println("- - - - - - - - - - - - - - - - - - -");

        int size = coll.size();
        System.out.println("розмір: " + size);

        boolean clear = coll.clear();
        System.out.println("очистити: " + clear);

        size = coll.size();
        System.out.println("розмір: " + size);
        System.out.println("- - - - - - - - - - - - - - - - - - -");
    }
}
