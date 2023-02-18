
public interface CustomCollection<String>{
    boolean add(String str);

    boolean addAll(String[] array);

    boolean delete (int index);

    boolean delete (String str);

    String get(int index);

    boolean contains(String str);

    boolean clear();

    int size();

    boolean trim();
}
