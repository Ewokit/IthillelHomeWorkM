package Service.log.Impl;

import Service.log.ErrorService;
import exception.NumberException;

import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class ErrorServiceImpl  implements ErrorService {
    private final Logger ERROR = Logger.getLogger("error.Log");
    private final ResourceBundle RESOURCE_BUNDLE;

    public ErrorServiceImpl(ResourceBundle resourceBundle) {
        this.RESOURCE_BUNDLE = resourceBundle;
    }

    @Override
    public void StateExceptionLog(String string) {
        ERROR.warning(String.valueOf(new IllegalStateException("value" + string)));
    }

    @Override
    public void numberRoundsException(NumberException exception) {
        ERROR.warning(exception.getMessage());
    }

    @Override
    public void numberFormatException(NumberFormatException exception) {
        ERROR.warning(exception.getClass().getName().concat(":").concat(exception.getMessage()));
    }

    @Override
    public void ioException(IOException exception) {
        ERROR.warning(exception.getClass().getName().concat(":").concat(exception.getMessage()));
    }
}
