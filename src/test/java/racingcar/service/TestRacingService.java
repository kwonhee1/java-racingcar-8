package racingcar.service;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.dto.RacingResult;

public class TestRacingService extends RacingService {

    private RacingResult racingResult;

    public TestRacingService(RacingResult racingResult) {
        this.racingResult = racingResult;
    }

    @Override
    public RacingResult racing(List<RacingCar> racingCarList, int racingCount) {
        return racingResult;
    }

    @Override
    public List<RacingCar> createRacingCars(List<String> carNameList) {
        return null;
    }

}
