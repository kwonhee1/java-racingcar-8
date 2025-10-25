package racingcar.view;

import java.util.List;

public class SimpleOutputView implements OutputView {
    @Override
    public void printResultStart() {
        System.out.println(OutputMessage.RESULT_START.getMessage());
    }

    @Override
    public void printCarResult(String carName, int carPosition) {
        StringBuilder carResult = new StringBuilder(OutputMessage.RESULT_CAR_NAME_PART.getMessage(carName));

        for(int i = 0; i < carPosition; i++)
            carResult.append(OutputMessage.RESULT_CAR_POSITION_PART.getMessage());

        System.out.println(carResult.toString());
    }

    @Override
    public void printNextLine() {
        System.out.println();
    }

    @Override
    public void printResultEnd(List<String> winnerNameList) {
        String winnerName = String.join(OutputMessage.RESULT_END_JOIN_REGEX.getMessage(), winnerNameList);
        System.out.println(OutputMessage.RESULT_END.getMessage(winnerName));
    }
}
