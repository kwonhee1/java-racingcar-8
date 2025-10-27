package racingcar.controller;

import java.util.List;
import java.util.function.Supplier;
import racingcar.controller.exception.ExceptionMapper;
import racingcar.controller.mapper.OutputMapper;
import racingcar.domain.RacingCar;
import racingcar.service.RacingService;
import racingcar.service.dto.RacingResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private InputView inputView;
    private OutputView outputView;
    private RacingService racingService;
    private ExceptionMapper exceptionMapper;

    public RacingController(
            InputView inputView,
            OutputView outputView,
            RacingService racingService,
            ExceptionMapper exceptionMapper
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
        this.exceptionMapper = exceptionMapper;
    }

    public void run() {
        List<RacingCar> carList = supply(()->createRacingCars());
        RacingResult result = supply(()->racing(carList));
        printResult(result);
    }

    private List<RacingCar> createRacingCars() {
        List<String> carNames = inputView.inputCarNames();
        return racingService.createRandomRacingCars(carNames);
    }

    private RacingResult racing(List<RacingCar> carList) {
        int racingCount = inputView.inputRacingCount();
        return racingService.racing(carList, racingCount);
    }

    private void printResult(RacingResult racingResult) {
        String racingResultStr = OutputMapper.racingCaptureListToString(racingResult.getRacingCaptureList());
        String winnerResultStr = OutputMapper.winningRacingCarToString(racingResult.getWinningRacingCar());

        outputView.printRacingResult(racingResultStr);
        outputView.printWinningCarNames(winnerResultStr);
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
