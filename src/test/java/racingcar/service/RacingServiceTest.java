package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.TestForwardCondition;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;

public class RacingServiceTest {

    @Test
    @DisplayName("racing service는 racing car들을 생성함")
    public void createRacingCars() {
        List<String> carNameList = List.of("aaa", "bbb", "ccc");
        RacingService racingService = RacingService.of();

        List<RacingCar> carList = racingService.createRacingCars(carNameList);
        List<String> createdCarNames = carList.stream().map(RacingCar::getName).toList();

        Assertions.assertThat(createdCarNames).containsAll(carNameList);
    }

    @Test
    @DisplayName("racing service는 car를 capture함")
    public void captureTest() {
        String carName = "name";
        RacingCar car = RacingCar.of(carName);
        RacingCar.setForwardCondition(new TestForwardCondition());
        car.forward(); car.forward();

        CarCapture carCapture = CarCapture.capture(car);

        Assertions.assertThat(carCapture.getCarName()).isEqualTo(carName);
        Assertions.assertThat(carCapture.getCarPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("racing capture는 순서가 보장 되어야함")
    public void captureOrderTest() {
        String carName1 = "aaa";
        String carName2 = "bbb";
        RacingCar car1 = RacingCar.of(carName1);
        RacingCar car2 = RacingCar.of(carName2);

        RacingCapture racingCarCapture = new RacingCapture(1);
        racingCarCapture.addCapture(CarCapture.capture(car1));
        racingCarCapture.addCapture(CarCapture.capture(car2));

        List<CarCapture> carCaptureList = racingCarCapture.getCarCaptureList();

        Assertions.assertThat(carCaptureList.get(0).getCarName()).isEqualTo(carName1);
        Assertions.assertThat(carCaptureList.get(1).getCarName()).isEqualTo(carName2);
    }

    @Test
    @DisplayName("racing many times 결과 확인")
    public void racingTest() {
        RacingService racingService = RacingService.of();
        RacingCar.setForwardCondition(new TestForwardCondition());

        List<RacingCar> carList = racingService.createRacingCars(List.of("aaa", "bbb"));

        List<RacingCapture> racingResult = racingService.racingManyTimes(carList, 3);

        RacingCapture firstRacingCapture = racingResult.get(0);
        RacingCapture secondRacingCapture = racingResult.get(1);
        RacingCapture thirdRacingCapture = racingResult.get(2);

        CarCapture firstRacingFirstCarCapture = firstRacingCapture.getCarCaptureList().get(0);
        CarCapture secondRacingFirstCarcapture = secondRacingCapture.getCarCaptureList().get(0);
        CarCapture thirdRacingFirstCarCapture = thirdRacingCapture.getCarCaptureList().get(0);

        Assertions.assertThat(firstRacingFirstCarCapture.getCarPosition()).isEqualTo(1);
        Assertions.assertThat(secondRacingFirstCarcapture.getCarPosition()).isEqualTo(2);
        Assertions.assertThat(thirdRacingFirstCarCapture.getCarPosition()).isEqualTo(3);
    }
}
