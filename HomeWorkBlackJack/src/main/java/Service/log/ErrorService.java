package Service.log;

import exception.NumberException;

import java.io.IOException;

public interface  ErrorService {
    void StateExceptionLog(String string);

    void numberRoundsException(NumberException exception);

    void numberFormatException(NumberFormatException exception);

    void ioException(IOException exception);
}
