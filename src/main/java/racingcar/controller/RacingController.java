package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;
import racingcar.service.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private InputView inputView;
    private OutputView outputView;
    private RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        racingService = RacingService.of();
    }

    public void run() {
        InputDto input = inputCarNamesAndRacingCount();
        RacingResult result = racing(input);
        printResult(result);
    }

    private InputDto inputCarNamesAndRacingCount() {
        List<String> carNames = inputView.inputCarNames();
        Integer racingCount = inputView.inputRacingCount();

        return new InputDto(carNames, racingCount);
    }

    private RacingResult racing(InputDto input) {
        List<RacingCar> carList = racingService.createRacingCars(input.getCarNameList());
        return racingService.racingManyTimes(carList, input.getRacingCount());
    }

    private void printResult(RacingResult racingResult) {
        outputView.printResultStart();
        for (RacingCapture racingCapture: racingResult.getRacingCaptureList())
            printRacingCapture(racingCapture);

        outputView.printResultEnd(racingResult.winningCarNameList());
    }

    private void printRacingCapture(RacingCapture racingCapture) {
        for (CarCapture carCapture : racingCapture.getCarCaptureList()){
            outputView.printCarResult(carCapture.getCarName(), carCapture.getCarPosition());
        }
        outputView.printNextLine();
    }

}
