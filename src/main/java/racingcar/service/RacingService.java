package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;
import racingcar.service.dto.RacingResult;
import racingcar.service.dto.WinningRacingCar;

public class RacingService {

    private static final RacingService instance = new RacingService();

    public static RacingService of() {
        return instance;
    }

    public List<RacingCar> createRacingCars(List<String> carNameList) {
        return carNameList.stream()
                .map(RacingCar::new)
                .toList();
    }

    public RacingResult racing(List<RacingCar> racingCarList, int racingCount) {
        validateRacingCount(racingCount);

        List<RacingCapture> racingCaptureList = racingManyTimesWithCapture(racingCarList, racingCount);
        WinningRacingCar winningRacingCar = getWinningRacingCar(racingCaptureList.getLast());

        return new RacingResult(racingCaptureList, winningRacingCar);
    }

    private void validateRacingCount(int racingCount) {
        if (racingCount < 1)
            throw new RacingCountMustPositiveException();
    }

    private List<RacingCapture> racingManyTimesWithCapture(List<RacingCar> racingCarList, int totalRacingCount) {
        List<RacingCapture> racingCaptureList = new ArrayList<>();

        for(int nowRacingCount = 1; nowRacingCount <= totalRacingCount; nowRacingCount++) {
            List<RacingCar> racingCarListAfterRacing = racingOnce(racingCarList);
            RacingCapture racingCapture = RacingCapture.captureRacingResult(racingCarListAfterRacing, nowRacingCount);
            racingCaptureList.add(racingCapture);
        }

        return racingCaptureList;
    }

    private List<RacingCar> racingOnce(List<RacingCar> racingCarList) {
        for(RacingCar racingCar : racingCarList)
            racingCar.forward();
        return racingCarList;
    }

    private WinningRacingCar getWinningRacingCar(RacingCapture lastRacingCapture) {
        List<CarCapture> lastRacingCarCaptureList = lastRacingCapture.getCarCaptureList();

        int maxPosition = findMaxPosition(lastRacingCarCaptureList);
        List<CarCapture> winningCarCaptureList = lastRacingCarCaptureList.stream()
                .filter(carCapture -> carCapture.getCarPosition() == maxPosition)
                .toList();

        return new WinningRacingCar(winningCarCaptureList, maxPosition);
    }

    private int findMaxPosition(List<CarCapture> carCaptureList) {
        int maxPosition = 0;
        for(CarCapture carCapture : carCaptureList)
            if(maxPosition < carCapture.getCarPosition())
                maxPosition = carCapture.getCarPosition();
        return maxPosition;
    }
}
