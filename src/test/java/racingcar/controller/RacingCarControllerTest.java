package racingcar.controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.TestForwardCondition;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputMessage;
import racingcar.view.OutputView;
import racingcar.view.TestInputView;
import racingcar.view.TestOutputView;

public class RacingCarControllerTest {

    @Test
    public void controllerTest() {
        StringBuilder result = new StringBuilder();
        List<String> carList = List.of("aaa", "bbb");

        InputView inputView = new TestInputView(carList, 3);
        OutputView outputView = new TestOutputView(result);
        RacingController racingController = new RacingController(inputView, outputView, RacingService.of());
        RacingCar.setForwardCondition(new TestForwardCondition());

        racingController.run();
        String winnerCars = String.join(OutputMessage.RESULT_END_JOIN_REGEX.getMessage(), carList);

        Assertions.assertThat(result.toString())
                .contains(OutputMessage.RESULT_CAR_NAME_PART.getMessage("aaa"))
                .contains(OutputMessage.RESULT_END.getMessage(winnerCars));
    }
}
