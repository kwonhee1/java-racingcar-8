package racingcar.service.dto;

import java.util.List;

public class RacingResult {

    private List<RacingCapture> racingCaptureList;
    private WinningRacingCar winningRacingCar;

    public RacingResult(List<RacingCapture> racingCaptureList, WinningRacingCar winningRacingCar) {
        this.racingCaptureList = racingCaptureList;
        this.winningRacingCar = winningRacingCar;
    }

    public List<RacingCapture> getRacingCaptureList() {
        return racingCaptureList;
    }

    public List<String> winningCarNameList() {
        return winningRacingCar.getCarNameList();
    }

}
