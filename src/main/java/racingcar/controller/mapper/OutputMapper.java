package racingcar.controller.mapper;

import java.util.List;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;
import racingcar.service.dto.WinningRacingCar;
import racingcar.view.OutputMessage;

public class OutputMapper {

    public static String racingCaptureListToString(List<RacingCapture> racingCaptureList) {
        StringBuilder result = new StringBuilder(OutputMessage.RESULT_START.getMessage());
        result.append("\n");

        for(RacingCapture racingCapture : racingCaptureList) {
            List<CarCapture> carCaptureList = racingCapture.getCarCaptureList();
            result.append(carCaptureListToString(carCaptureList));
        }

        return result.toString();
    }

    private static String carCaptureListToString(List<CarCapture> carCaptureList) {
        StringBuilder result = new StringBuilder();
        carCaptureList.forEach(carCapture -> {
            result.append(carCaptureToString(carCapture));
            result.append("\n");
        });
        result.append("\n");
        return result.toString();
    }

    private static String carCaptureToString(CarCapture carCapture) {
        StringBuilder result = new StringBuilder(OutputMessage.RESULT_CAR_NAME_PART.getMessage(carCapture.getCarName()));

        for(int i = 0; i < carCapture.getCarPosition(); i++)
            result.append(OutputMessage.RESULT_CAR_POSITION_PART.getMessage());

        return result.toString();
    }

    public static String winningRacingCarToString(WinningRacingCar winningRacingCar) {
        List<String> winningCarNameList = winningRacingCar.getCarNameList();
        String winnerNames = String.join(OutputMessage.RESULT_END_JOIN_REGEX.getMessage(), winningCarNameList);
        return OutputMessage.RESULT_END.getMessage(winnerNames);
    }
}
