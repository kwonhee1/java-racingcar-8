package racingcar.service.dto;

import java.util.List;

public class WinningRacingCar {
    private int position;
    private List<String> carNameList;

    public WinningRacingCar(List<String> carNameList, int position) {
        this.carNameList = carNameList;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }
    public List<String> getCarNameList() {
        return carNameList;
    }
}
