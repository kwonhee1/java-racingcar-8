package racingcar.controller.exception;

import racingcar.domain.exception.TooLongCarNameException;
import racingcar.service.RacingCountMustPositiveException;
import racingcar.view.OutputMessage;

public class ExceptionHandler {

    @TargetException(TooLongCarNameException.class)
    public <T extends IllegalArgumentException> String handelTooLongCarNameException(T exception) {
        return OutputMessage.ERROR_TOO_LONG_CAR_NAME.getMessage();
    }

    @TargetException(RacingCountMustPositiveException.class)
    public <T extends IllegalArgumentException> String handelRacingCountMustPositiveException(T exception) {
        return OutputMessage.ERROR_RACING_COUNT_MUST_POSITIVE.getMessage();
    }

    @TargetException(NumberFormatException.class)
    public <T extends IllegalArgumentException> String handelNumberFormatException(T exception) {
        return OutputMessage.ERROR_NUMBER_FORMAT.getMessage();
    }

}
