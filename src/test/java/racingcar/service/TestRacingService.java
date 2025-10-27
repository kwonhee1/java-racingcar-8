package racingcar.service;

import java.util.List;
import racingcar.domain.RacingCar;

public class TestRacingService extends RacingService {

    @Override
    public List<RacingCar> createRandomRacingCars(List<String> carNameList) {
        return carNameList.stream()
                .map(carName -> new RacingCar(carName))
                .toList();
    }

}
