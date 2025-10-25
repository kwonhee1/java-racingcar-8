package racingcar.view;

public class TestOutputView implements OutputView {

    private StringBuilder builder;
    public TestOutputView(StringBuilder builder) {
        this.builder = builder;
    }


    @Override
    public void printRacingResult(String racingResult) {
        builder.append(racingResult);
    }

    @Override
    public void printWinningCarNames(String winningStr) {
        builder.append(winningStr);
    }

    @Override
    public void printError(String errorMessage) {
        builder.append(OutputMessage.ERROR.getMessage(errorMessage));
    }
}
