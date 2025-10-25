package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.RacingCarConstant;

public class SimpleInputView implements InputView {

    @Override
    public List<String> inputCarNames() {
        System.out.println(OutputMessage.INPUT_CAR_NAMES.getMessage());
        String carNameStrs = Console.readLine();
        String[] names = carNameStrs.split(RacingCarConstant.CAR_NAME_REGEX);
        return List.of(names);
    }

    @Override
    public Integer inputRacingCount() {
        System.out.println(OutputMessage.INPUT_RACING_COUNT.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
