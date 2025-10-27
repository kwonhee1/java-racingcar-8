package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    @DisplayName("Racing Car 생성 test")
    public void makeRacingCarTest() {
        String carName = "Red";
        String tooLongCarName = "Yellow";

        Assertions.assertThatNoException()
                .isThrownBy(() -> new RacingCar(carName));
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCar(tooLongCarName));
    }

    @Test
    @DisplayName("자동차는 전진한다")
    public void carForwardTest() {
        RacingCar car = new RacingCar("name");

        car.forward();

        Assertions.assertThat(car.getPosition()).isEqualTo(1L);
    }

}
