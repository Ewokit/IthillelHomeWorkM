public interface CollectionService {
     boolean add(int index, String value);
     boolean add(String value);
     boolean delete(int index);
     boolean delete(String value);
     String get(int index);
}
