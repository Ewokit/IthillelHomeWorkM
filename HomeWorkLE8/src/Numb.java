public class Numb {
    private String[] element;
    private int ex = 0;

    public Numb(int i){
        element = new String[10];
    }
    public String[] getElement(){
        return element;
    }
    public void setElement(String[] element){
        this.element = element;
    }
    public int getEx(){
        return ex;
    }
    public void setEx(int ex){
        this.ex = ex;
    }
}
