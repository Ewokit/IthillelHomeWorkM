package Elements;

class Object {
    private String letter;

    Object(String letter){
        this.letter = letter;
    }
    public String getLetter(){
        return letter;
    }
    public String toString(){
        return "(" + letter + ")";
    }
}
