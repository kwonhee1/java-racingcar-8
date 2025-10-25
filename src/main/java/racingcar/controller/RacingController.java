package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.exception.TooLongCarNameException;
import racingcar.service.RacingCountMustPositiveException;
import racingcar.service.RacingService;
import racingcar.service.dto.CarCapture;
import racingcar.service.dto.RacingCapture;
import racingcar.service.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputMessage;
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
        List<RacingCar> carList = createRacingCars();
        RacingResult result = racing(carList);
        printResult(result);
    }

    private List<RacingCar> createRacingCars() {
        try{
            List<String> carNames = inputView.inputCarNames();
            return racingService.createRacingCars(carNames);
        } catch (TooLongCarNameException e) {
            outputView.printError(OutputMessage.ERROR_TOO_LONG_CAR_NAME.getMessage());
            throw e;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;
        }
    }

    private RacingResult racing(List<RacingCar> carList) {
        try {
            int racingCount = inputView.inputRacingCount();
            return racingService.racing(carList, racingCount);
        } catch (RacingCountMustPositiveException e){
            outputView.printError(OutputMessage.ERROR_RACING_COUNT_MUST_POSITIVE.getMessage());
            throw e;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            throw e;
        }
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
