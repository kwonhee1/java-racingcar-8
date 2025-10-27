package racingcar.mapper;

import java.nio.file.InvalidPathException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.exception.ExceptionHandler;
import racingcar.controller.exception.ExceptionMapper;
import racingcar.controller.exception.NoExceptionHandlerMethodException;
import racingcar.service.RacingCountMustPositiveException;

public class ExceptionMapperTest {

    private ExceptionMapper exceptionMapper = new ExceptionMapper();

    @Test
    @DisplayName("알맞은 Exception Mapper를 고르는지 test")
    public void toMessageTest() {
        IllegalArgumentException e = new RacingCountMustPositiveException();
        String message = exceptionMapper.toMessage(e);
        String expectedMessage = new ExceptionHandler().handelRacingCountMustPositiveException(e);

        Assertions.assertThat(message).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("잘못된 Exception이 발생했을 때")
    public void noHandlerExceptionTest() {
        Assertions.assertThatExceptionOfType(NoExceptionHandlerMethodException.class).isThrownBy(() -> {
            exceptionMapper.toMessage(new InvalidPathException("",""));
        });
    }
}
