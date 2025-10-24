package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.dto.RacingCarDto;

public class RacingCarTest {

    @Test
    @DisplayName("Racing Car 생성 test")
    public void makeRacingCarTest() {
        String carName = "Red";
        String tooLongCarName = "Yellow";

        Assertions.assertThatNoException()
                .isThrownBy(() -> RacingCar.of(carName));
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingCar.of(tooLongCarName));
    }

    @Test
    @DisplayName("자동차는 전진한다")
    public void carForwardTest() {
        RacingCar.setForwardCondition(TestForwardCondition);
        RacingCar car = RacingCar.of("name");

        car.forward();

        Assertions.assertThat(car.getPosition()).isEqualTo(1L);
    }

    @Test
    @DisplayName("자동차 dto 변환 내용 확인")
    public void carDtoTest() {
        String carName = "name";
        int position = 3;
        RacingCar.setForwardCondition(TestForwardCondition);
        RacingCar car = RacingCar.of(carName);

        for(int i = 0; i < position; i++)
            car.forward();

        RacingCarDto carDto = RacingCarDto.of(car);

        Assertions.assertThat(carDto.toCarStatus()).isEqualTo("name : ---");
    }

}
