package racingcar;

import racingcar.controller.RacingController;
import racingcar.service.RacingService;
import racingcar.view.SimpleInputView;
import racingcar.view.SimpleOutputView;

public class Application {
    public static void main(String[] args) {
        new RacingController(new SimpleInputView(), new SimpleOutputView(), RacingService.of()).run();
    }
}
