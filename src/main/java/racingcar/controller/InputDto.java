package racingcar.controller;

import java.util.List;

public class InputDto {

    private List<String> carNameList;
    private int racingCount;

    public InputDto(List<String> carNameList, int racingCount) {
        this.carNameList = carNameList;
        this.racingCount = racingCount;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public int getRacingCount() {
        return racingCount;
    }

}
