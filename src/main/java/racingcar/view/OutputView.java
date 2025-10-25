package racingcar.view;

import java.util.List;

public interface OutputView {
    void printResultStart();
    void printCarResult(String carName, int carPosition);
    void printNextLine();
    void printResultEnd(List<String> winnerNameList);
}
