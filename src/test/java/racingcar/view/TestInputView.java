package racingcar.view;

import java.util.List;

public class TestInputView implements InputView {

    private List<String> carNames;
    private int racingCount;

    public TestInputView(List<String> carNames, int racingCount) {
        this.carNames = carNames;
        this.racingCount = racingCount;
    }

    @Override
    public List<String> inputCarNames() {
        return carNames;
    }

    @Override
    public Integer inputRacingCount() {
        return racingCount;
    }
}
