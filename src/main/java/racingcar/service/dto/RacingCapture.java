package racingcar.service.dto;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCapture {

    private int racingCount;
    private List<CarCapture> carCaptureList;

    public RacingCapture(int racingCount) {
        this.racingCount = racingCount;
        carCaptureList = new ArrayList<>();
    }

    public void addCapture(CarCapture carCapture) {
        carCaptureList.add(carCapture);
    }

    public static RacingCapture captureRacingResult(List<RacingCar> racingCarList, int racingCount) {
        RacingCapture racingCapture = new RacingCapture(racingCount);
        for (RacingCar racingCar : racingCarList) {
            CarCapture carCapture = CarCapture.capture(racingCar);
            racingCapture.addCapture(carCapture);
        }
        return racingCapture;
    }

    public List<CarCapture> getCarCaptureList() {
        return carCaptureList;
    }

}
