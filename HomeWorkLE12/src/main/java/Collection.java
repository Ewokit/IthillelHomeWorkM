public interface Collection {
    boolean add(String str);

    boolean add(int index, String str);

    boolean delete(String str);

    String get(int index);

    boolean contain(String str);

    boolean equals(String[] array);

    boolean clear();

    int size();
}
