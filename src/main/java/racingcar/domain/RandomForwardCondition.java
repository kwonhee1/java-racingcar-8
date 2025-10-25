package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RacingCarConstant;

public class RandomForwardCondition implements ForwardCondition {

    private static RandomForwardCondition instance = new RandomForwardCondition();

    public static RandomForwardCondition of(){
        return instance;
    }

    @Override
    public boolean canForward() {
        if(Randoms.pickNumberInRange(0, 9) >= RacingCarConstant.RANDOM_FORWARD_CONDITION_INCLUSIVE_VALUE_FOUR)
            return true;
        return false;
    }
}
