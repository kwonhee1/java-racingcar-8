package racingcar;

import racingcar.conf.RacingConfig;

public class Application {
    public static void main(String[] args) {
        RacingConfig.of().getRacingController().run();
    }
}
