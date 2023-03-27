package Treatment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import Exception.UserNotFoundException;

import java.util.Collections;

public class ControllerException {
    private static final String exception = "Oops... Error";
    private static final String userNotFound = "User not found";

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> invalidException(Exception exception1) {
        return new ResponseEntity<>(Collections.singleton(exception), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<?> handleException(Exception exception){
        return new ResponseEntity<>(Collections.singleton(userNotFound), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<?> userNotFoundExc(Exception exception1) {
        return new ResponseEntity<>(Collections.singleton(String.format(userNotFound, exception1.getMessage()))
        , HttpStatus.BAD_REQUEST);
    }
}
