

public class CustomCollectionImpl extends LList implements CustomCollection {

    @Override
    public boolean add(Object str) {
        return false;
    }

    @Override
    public boolean addAll(Object[] array) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public boolean delete(Object str) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object str) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean trim() {
        return false;
    }
}