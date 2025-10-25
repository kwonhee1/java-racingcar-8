package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.controller.mapper.ExceptionMapper;
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
    private ExceptionMapper exceptionMapper;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        racingService = RacingService.of();
        exceptionMapper = ExceptionMapper.of();
    }

    public void run() {
        List<RacingCar> carList = supply(()->createRacingCars());
        RacingResult result = supply(()->racing(carList));
        printResult(result);
    }

    private List<RacingCar> createRacingCars() {
        List<String> carNames = inputView.inputCarNames();
        return racingService.createRacingCars(carNames);
    }

    private RacingResult racing(List<RacingCar> carList) {
        int racingCount = inputView.inputRacingCount();
        return racingService.racing(carList, racingCount);
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

    private <T> T supply(Supplier<T> supplier) {
        try{
            return supplier.get();
        } catch (IllegalArgumentException e){
            outputView.printError(exceptionMapper.toMessage(e));
            throw e;
        }
    }

}
