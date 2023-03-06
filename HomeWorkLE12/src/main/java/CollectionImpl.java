import java.util.Arrays;
import java.util.Objects;

public class CollectionImpl extends ArrayS implements Collection {
    public CollectionImpl(int capacity) {
        super(capacity);
    }

    public CollectionImpl() {
        super(0);
    }

    @Override
    public boolean add(String str) {
        switch ((getElements().length > getSize()) ? 0 : 1) {
            case 0:
                getElements()[getSize()] = str;
            case 1:
                String[] Array = new String[(getElements().length * 3) / 2 + 1];
                System.arraycopy(getElements(), 0, Array, 0, getElements().length);
                Array[getSize()] = str;
                setSize(getSize() + 1);
                setElements(Arrays.copyOf(Array, getSize()));
        }
        return true;
    }

    @Override
    public boolean add(int index, String str) {
        String[] elements = new String[getElements().length];
        if (getElements().length == getSize()){
            elements = Arrays.copyOf(getElements(), getElements().length * 2);
        }
        System.arraycopy(getElements(), index, elements, index+1, getElements().length - index);
        elements[index] = str;
        setSize(getSize() + 1);
        setElements(Arrays.copyOf(elements, getSize()));
        return true;
    }

    @Override
    public boolean delete(String str) {
        boolean result = false;
        for (int i = 0; i < getSize(); i++) {
            if (getElements()[i].equals(str)) {
                System.arraycopy(getElements(), i + 1, getElements(), i, getSize() - i - 1);
                result = true;
            }
        }
        if (!result)
            return false;
        setSize(getSize() - 1);
        setElements(Arrays.copyOf(getElements(), getSize()));
        return true;
    }

    @Override
    public String get(int index) {
        if (index >= getSize() || index < 0) return "Exception";
        return getElements()[index];
    }

    @Override
    public boolean contain(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getSize(); i++){
            stringBuilder.append(getElements()[i]).append(" ");
        }
        String[] strings = stringBuilder.toString().split(" ");
        for (String s : strings){
            if (s.equals(str)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(String[] array) {
        if (getElements().length != array.length) return false;
        for (int i = 0; i < getSize(); i++){
            if (!Objects.equals(getElements()[i], array[i])) return false;
        }
        return true;
    }

    @Override
    public boolean clear() {
        setSize(0);
        setElements(new String[getSize()]);
        return true;
    }

    @Override
    public int size() {
        return getSize();
    }
}
