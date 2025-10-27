package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;
import racingcar.service.dto.RacingResult;

public class RacingServiceTest {

    @Test
    @DisplayName("racing service는 racing car들을 생성함")
    public void createRandomRacingCars() {
        List<String> carNameList = List.of("aaa", "bbb", "ccc");
        RacingService racingService = new RacingService();

        List<RacingCar> carList = racingService.createRandomRacingCars(carNameList);
        List<String> createdCarNames = carList.stream().map(RacingCar::getName).toList();

        Assertions.assertThat(createdCarNames).containsAll(carNameList);
    }

    @Test
    @DisplayName("racing service는 car를 capture함")
    public void captureTest() {
        String carName = "name";
        RacingCar car = new RacingCar(carName);
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
        RacingCar car1 = new RacingCar(carName1);
        RacingCar car2 = new RacingCar(carName2);

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
        RacingService racingService = new TestRacingService();

        List<RacingCar> carList = racingService.createRandomRacingCars(List.of("aaa", "bbb"));

        RacingResult racingResult = racingService.racing(carList, 3);
        List<RacingCapture> resultRacingCaptureList = racingResult.getRacingCaptureList();

        RacingCapture firstRacingCapture = resultRacingCaptureList.get(0);
        RacingCapture secondRacingCapture = resultRacingCaptureList.get(1);
        RacingCapture thirdRacingCapture = resultRacingCaptureList.get(2);

        CarCapture firstRacingFirstCarCapture = firstRacingCapture.getCarCaptureList().get(0);
        CarCapture secondRacingFirstCarcapture = secondRacingCapture.getCarCaptureList().get(0);
        CarCapture thirdRacingFirstCarCapture = thirdRacingCapture.getCarCaptureList().get(0);

        Assertions.assertThat(firstRacingFirstCarCapture.getCarPosition()).isEqualTo(1);
        Assertions.assertThat(secondRacingFirstCarcapture.getCarPosition()).isEqualTo(2);
        Assertions.assertThat(thirdRacingFirstCarCapture.getCarPosition()).isEqualTo(3);
    }
}
