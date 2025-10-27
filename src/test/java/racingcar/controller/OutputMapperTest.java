package racingcar.controller;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.mapper.OutputMapper;
import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.service.TestRacingService;
import racingcar.service.dto.RacingResult;

public class OutputMapperTest {

    private RacingService racingService = new TestRacingService();

    @Test
    @DisplayName("")
    public void racingCaptureListToStringTest() {
        List<String> carNameList = List.of("aaa", "bbb", "ccc");
        int racingCount = 3;

        List<RacingCar> racingCarList = racingService.createRandomRacingCars(carNameList);
        RacingResult racingResult = racingService.racing(racingCarList, racingCount);

        String str = OutputMapper.racingCaptureListToString(racingResult.getRacingCaptureList());

        Assertions.assertThat(str)
                .contains("aaa : ---")
                .contains("bbb : ---")
                .contains("ccc : ---");
    }

    @Test
    @DisplayName("")
    public void winningRacingCarToStringTest() {
        List<String> carNameList = List.of("aaa", "bbb", "ccc");
        int racingCount = 3;

        List<RacingCar> racingCarList = racingService.createRandomRacingCars(carNameList);
        RacingResult racingResult = racingService.racing(racingCarList, racingCount);

        String str = OutputMapper.winningRacingCarToString(racingResult.getWinningRacingCar());

        Assertions.assertThat(str)
                .contains("최종 우승자 : aaa, bbb, ccc");
    }
}
