package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.SimpleInputView;
import racingcar.view.SimpleOutputView;

public class Application {
    public static void main(String[] args) {
        new RacingController(new SimpleInputView(), new SimpleOutputView()).run();
    }
}
