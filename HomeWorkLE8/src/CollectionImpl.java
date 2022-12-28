import java.lang.reflect.Array;
import java.util.Arrays;

public class CollectionImpl extends Numb implements Collection{
    public CollectionImpl(){
        super(10);
    }
    @Override
    public boolean add(String o) {
        switch ((getElement().length > getEx()) ? 0: 1) {
            case 1 :
                getElement()[getEx()] = o;
                setEx(getEx() + 1);
                break;
            case 2 :
                String[] stNumb = new String[(getElement().length*3)/2+1];
                System.arraycopy(getElement(), 0, stNumb, 0, getElement().length);
                stNumb[getEx()] = o;
                setEx(getEx() + 1);
                setElement(Arrays.copyOf(stNumb, getEx()));
                break;
        }
        return true;
    }

    @Override
    public boolean add(int index, String o) {
        if (index < 0 || index >= getEx())
        return false;
        String[] stElement = new String[(getElement().length*3)/2+1];
        System.arraycopy(getElement(), 0, stElement, 0, getElement().length);
        System.arraycopy(stElement, index, stElement, index+1, getElement().length - index);
        stElement[index] = o;
        setElement(Arrays.copyOf(stElement, getEx()));
        setEx(getEx()+1);
        return true;
    }

    @Override
    public boolean delete(String o) {
        boolean result = false;
        for (int i = 0; i < getEx(); i++){
            if (getElement()[i].equals(o)){
                System.arraycopy(getElement(), i + 1, getElement(), i, getEx() - i - 1);
                result = true;
            }
        }
        if (!result) return false;
        setEx(getEx()-1);
        setElement(Arrays.copyOf(getElement(), getEx()));
        return true;
    }

    @Override
    public String get(int index) {
        if (index >=getEx() || index < 0) return "Виняток";
        return getElement()[index];
    }

    @Override
    public boolean contain(String o) {
        String st = "";
        for (int i = 0; i < getEx(); i++){
            st += getElement()[i] + "";
        }
        String[] st1 = st.split(" ");
        for (int i = 0; i < st1.length; i++) {
            if(st1[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(String[] str) {
        if (getElement().length != str.length) return false;
        for (int i = 0; i < getEx(); i++) {
            if (getElement()[i] != str[i]) return false;
        }
        return true;
    }

    @Override
    public boolean clear() {
        setEx(0);
        setElement(new String[getEx()]);
        return true;
    }

    @Override
    public int size() {
        return getEx();
    }
}
