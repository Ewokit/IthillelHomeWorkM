public class ArrayS {
    private String[] elements;
    private int size = 0;

    public ArrayS(int capacity){
        elements = new String[capacity];
    }

    public ArrayS(){
        elements = new String[10];
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
