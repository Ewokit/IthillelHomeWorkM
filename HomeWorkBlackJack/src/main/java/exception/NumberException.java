package exception;

public class NumberException extends RuntimeException {
    public NumberException(){
        System.err.println("Number rounds must be > 0");
    }
    public String getMessage(){
        return NumberFormatException.class.getName().concat(":").concat("Number rounds must be > 0");
    }
}
