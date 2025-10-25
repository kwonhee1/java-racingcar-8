package racingcar.view;

public enum OutputMessage {

    RESULT_START("실행 결과"),
    RESULT_CAR_NAME_PART("%s : "),
    RESULT_CAR_POSITION_PART("-"),

    RESULT_END("최종 우승자 : %s"),
    RESULT_END_JOIN_REGEX(", ");

    private String message;
    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(String ...args) {
        return String.format(message, args);
    }

}
