package racingcar.service.dto;

import java.util.List;

public class WinningRacingCar {
    private int position;
    private List<CarCapture> winningCarCaptureList;

    public WinningRacingCar(List<CarCapture> winningCarCaptureList, int position) {
        this.winningCarCaptureList = winningCarCaptureList;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public List<String> getCarNameList() {
        return winningCarCaptureList.stream().map(CarCapture::getCarName).toList();
    }
}
