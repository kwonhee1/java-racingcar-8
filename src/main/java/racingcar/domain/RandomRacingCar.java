package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingCarConstant;

public class RandomRacingCar extends RacingCar {

    public RandomRacingCar(String carName) {
        super(carName);
    }

    @Override
    public void forward() {
        if (Randoms.pickNumberInRange(0, 9) >= RacingCarConstant.RANDOM_FORWARD_CONDITION_INCLUSIVE_VALUE_FOUR)
            super.forward();
    }

}
