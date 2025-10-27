package racingcar.controller.exception;

public class NoExceptionHandlerMethodException extends IllegalArgumentException {

    public NoExceptionHandlerMethodException(Exception e) {
        super(e);
    }

}
