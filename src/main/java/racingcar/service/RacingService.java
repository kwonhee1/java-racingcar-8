package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;

public class RacingService {

    private static final RacingService instance = new RacingService();

    public static RacingService of() {
        return instance;
    }

    public List<RacingCar> createRacingCars(List<String> carNameList) {
        return carNameList.stream()
                .map(RacingCar::of)
                .toList();
    }

    public List<RacingCapture> racingManyTimes(List<RacingCar> racingCarList, int racingCount) {
        List<RacingCapture> racingCaptureList = new ArrayList<>();

        for(int nowRacingCount = 1; nowRacingCount <= racingCount; nowRacingCount++) {
            RacingCapture racingCapture = racingOnce(racingCarList, nowRacingCount);
            racingCaptureList.add(racingCapture);
        }

        return racingCaptureList;
    }

    private RacingCapture racingOnce(List<RacingCar> racingCarList, int racingCount) {
        RacingCapture racingCapture = new RacingCapture(racingCount);
        for(RacingCar racingCar : racingCarList) {
            racingCar.forward();
            racingCapture.addCapture(CarCapture.capture(racingCar));
        }
        return racingCapture;
    }
}
