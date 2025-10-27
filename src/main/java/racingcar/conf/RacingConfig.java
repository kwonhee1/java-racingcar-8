package racingcar.conf;

import racingcar.controller.RacingController;
import racingcar.controller.exception.ExceptionMapper;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.SimpleInputView;
import racingcar.view.SimpleOutputView;

public class RacingConfig {

    private static final RacingConfig instance = new RacingConfig();

    private final InputView inputView = new SimpleInputView();
    private final OutputView outputView = new SimpleOutputView();

    private final RacingService racingService = new RacingService();
    private final ExceptionMapper exceptionMapper = new ExceptionMapper();

    private final RacingController racingController = new RacingController(inputView, outputView, racingService, exceptionMapper);

    public static RacingConfig of() {
        return instance;
    }

    public RacingController getRacingController() {
        return racingController;
    }
    public RacingService getRacingService() {
        return racingService;
    }
    public ExceptionMapper getExceptionMapper() {
        return exceptionMapper;
    }
    public InputView getInputView() {
        return inputView;
    }
    public OutputView getOutputView() {
        return outputView;
    }
}
