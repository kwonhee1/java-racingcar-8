package racingcar.service.vo;

import java.util.ArrayList;
import java.util.List;

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

    public List<CarCapture> getCarCaptureList() {
        return carCaptureList;
    }
}
