package racingcar.domain;

import racingcar.constant.RacingCarConstant;
import racingcar.domain.exception.TooLongCarNameException;

public class RacingCar {

    private static ForwardCondition forwardCondition = RandomForwardCondition.of();
    private int position;
    private String name;

    public RacingCar(String carName) {
        validateCarName(carName);
        this.name = carName;
        this.position = 0;
    }

    private void validateCarName(String carName) {
        if(carName.length() > RacingCarConstant.CAR_NAME_INCLUSIVE_LENGTH_FIVE)
            throw new TooLongCarNameException();
    }

    public void forward() {
        if(forwardCondition.canForward())
            position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public static void setForwardCondition(ForwardCondition newForwardCondition) {
        forwardCondition = newForwardCondition;
    }
}
