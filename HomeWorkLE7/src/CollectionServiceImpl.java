import java.util.Arrays;

public class CollectionServiceImpl extends Collection implements CollectionService {
    int c;

    public CollectionServiceImpl(int ex) {
        super(ex);
    }

    @Override
    public boolean add(int index, String value) {
        if (ChIndex(index)) {
            System.out.println("---");
            return false;
        }
        if (index < CLT.length - 1) {
            CLT[index] = value;
            return true;
        }
        String[] st = new String[index + 1];
        System.arraycopy(CLT, 0, st, 0, CLT.length);
        CLT[index] = value;
        return true;
    }

    @Override
    public boolean add(String value) {
        c = 0;
        for (int i = 0; i < CLT.length; i++) {
            if (CLT[i] == null)
                break;
            c++;
        }
        if (c < CLT.length) {
            CLT[c] = value;
            return true;
        }
        String[] st = new String[CLT.length + 1];
        System.arraycopy(CLT, 0, st, 0, CLT.length);
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (ChIndex(index)) {
            System.out.println("---");
            return false;
        }
        String[] st = new String[CLT.length - 1];
        System.arraycopy(CLT, 0, st, 0, index);
        for (int i = index; i < st.length; i++) {
            st[i] = CLT[i + 1];
        }
        CLT = Arrays.copyOf(st, st.length);
        return true;
    }


    @Override
    public boolean delete(String value) {
        String[] st = new String[CLT.length];
        c = 0;
        int exNewArray = 0;
        int chVal = 0;

        for (int i = 0; i < CLT.length; i++) {
            if (CLT[i] != value) exNewArray++;
            if (CLT[i] == value && CLT[i].equals(value)) chVal++;
        }

        if (chVal == 0)
            return false;

        for (int i = 0; i < CLT.length; i++) {
            if (CLT[i] == null || !CLT[i].equals(value)) {
                st[c] = CLT[i];
                c++;
            }
        }
        CLT = Arrays.copyOf(st, exNewArray);
        return false;
    }

    @Override
    public String get(int index) {
        if (index > CLT.length)
            return "---";
        return CLT[index];
    }

    private boolean ChIndex(int index) {
        return (index < 0 || index > CLT.length)
                ? false : true;
    }
}
