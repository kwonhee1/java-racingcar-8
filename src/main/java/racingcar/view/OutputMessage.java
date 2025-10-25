package racingcar.view;

public enum OutputMessage {

    RESULT_START("실행 결과"),
    RESULT_CAR_NAME_PART("%s : "),
    RESULT_CAR_POSITION_PART("-"),

    RESULT_END("최종 우승자 : %s"),
    RESULT_END_JOIN_REGEX(", "),

    INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACING_COUNT("시도할 횟수는 몇 회인가요?"),

    ERROR("[ERROR] : %s"),

    ERROR_TOO_LONG_CAR_NAME("자동차 이름은 5글자 이하만 가능합니다"),
    ;

    private String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(String ...args) {
        return String.format(message, args);
    }

}
