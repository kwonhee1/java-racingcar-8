package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomForwardCondition implements ForwardCondition {

    private static RandomForwardCondition instance = new RandomForwardCondition();

    public static RandomForwardCondition of(){
        return instance;
    }

    @Override
    public boolean canForward() {
        if(Randoms.pickNumberInRange(0, 9) > 4)
            return true;
        return false;
    }
}
