package racingcar.service.dto;

import racingcar.domain.RacingCar;

public class CarCapture {

    private String carName;
    private int carPosition;

    public CarCapture(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public static CarCapture capture(RacingCar racingCar) {
        return new CarCapture(racingCar.getName(), racingCar.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

}
