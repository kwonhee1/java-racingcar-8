package racingcar.view;

public class SimpleOutputView implements OutputView {

    @Override
    public void printRacingResult(String racingResult) {
        System.out.print(racingResult);
    }

    @Override
    public void printWinningCarNames(String winningStr) {
        System.out.print(winningStr);
    }

    @Override
    public void printError(String errorMessage) {
        System.out.println(OutputMessage.ERROR.getMessage(errorMessage));
    }
}
