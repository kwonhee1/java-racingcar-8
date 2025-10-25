package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.constant.RacingCarConstant;

public class SimpleInputView implements InputView {

    @Override
    public List<String> inputCarNames() {
        String carNameStrs = Console.readLine();
        String[] names = carNameStrs.split(RacingCarConstant.CAR_NAME_REGEX);
        return List.of(names);
    }

    @Override
    public Integer inputRacingCount() {
        return Integer.parseInt(Console.readLine());
    }
}
