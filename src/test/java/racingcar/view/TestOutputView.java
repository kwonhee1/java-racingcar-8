package racingcar.view;

import java.util.List;

public class TestOutputView implements OutputView {

    private StringBuilder builder;
    public TestOutputView(StringBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void printResultStart() {
         builder.append(OutputMessage.RESULT_START.getMessage() + "\n");
    }

    @Override
    public void printCarResult(String carName, int carPosition) {
        StringBuilder carResult = new StringBuilder(OutputMessage.RESULT_CAR_NAME_PART.getMessage(carName));

        for(int i = 0; i < carPosition; i++)
            carResult.append(OutputMessage.RESULT_CAR_POSITION_PART.getMessage());

        builder.append(carResult.toString()+"\n");
    }

    @Override
    public void printNextLine() {
        builder.append("\n");
    }

    @Override
    public void printResultEnd(List<String> winnerNameList) {
        String winnerName = String.join(OutputMessage.RESULT_END_JOIN_REGEX.getMessage(), winnerNameList);
        builder.append(OutputMessage.RESULT_END.getMessage(winnerName) + "\n");
    }
}
