package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class RandomRacingCarTest extends NsTest {

    @Test
    @DisplayName("random 함수 test")
    public void randomFunctionTest() {
        for(int i = 0; i < 100; i++) {
            randomFunction(i);
        }
    }

    private void randomFunction(int i) {
        int random = Randoms.pickNumberInRange(i, i+1);

        Assertions.assertThat(random).isBetween(i, i+1);
    }

    @Test
    @DisplayName("주어진 값에 전진하는지 test")
    public void randomCarForwardTest() {
        RandomRacingCar randomCar = new RandomRacingCar("car");
        assertRandomNumberInRangeTest(
                ()->{
                    randomCar.forward(); // 1
                    Assertions.assertThat(randomCar.getPosition()).isEqualTo(0);
                    randomCar.forward(); // 2
                    Assertions.assertThat(randomCar.getPosition()).isEqualTo(0);
                    randomCar.forward(); // 8
                    Assertions.assertThat(randomCar.getPosition()).isEqualTo(1);
                    randomCar.forward(); // 9
                    Assertions.assertThat(randomCar.getPosition()).isEqualTo(2);
                },
                1,2,8,9
        );
    }

    @Override
    protected void runMain() {

    }
}
