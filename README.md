# java-racingcar-precourse

# domain 분리
- 자동차
    - 이름을 입력 받는다
        - 5글자 이하만 가능하다
    - 1회 전진한다 
        - 0 ~ 9 사이에 무작위 값을 구한 후 4이상인 경우 전진한다
    - 현재 위치를 저장한다

# 기능 요구 사항
- [X] 자동차 이름들을 입력 받고 자동차들을 생성한다
- [X] 입력 받은 횟수를 입력 받는다 자동차 경주를 진행한다
- [X] 실행 결과를 출력한다

# 이번 주 도전
- TDD 도입 : test 코드 작성 후 코드 구현
    - 기능 구현전에 test 코드 작성하기
    - 모든 public method에 test 코드 작성하기
    - static함수에도 test 코드 작성하기
- git commit 일관성 : 일관성있는 git commit message 작성
- Exception 활용 : 알맞는 Exception 생성, 처리
    - 여러 Exception 정의하기
    - ExceptionMapper 구현하기

# 리뷰 받고 싶은 부분
- racing결과를 capture해 두고 모든 racing이 끝난 후 반환하도록 설계하였습니다
    - capture에 필요한 많은 dto가 필요해졌습니다 
    - RacingService가 capture에 대한 책임을 가져가면서 코드가 복잡해졌습니다
    - 위 두가지 부분에서 처음 코드를 읽을 때 이해하기 어려운지 궁금합니다
- git commit message를 일관성있게 작성하기 위해 노력했습니다
    - 더 보기 좋은 git commit message예시가 궁금합니다
- TestRacingService : test를 위해 RacingService를 상속해야 수정했습니다 (mocking용 class)
    - 처음 test코드를 읽을 때 RacingService를 TestRacingService로 두고 필요한 함수들을 Override한 부분을 눈치챘는지 궁금합니다.

# 프로그래밍 요구 사항
- indent depth가 3이 넘지 않도록 한다
- test 코드를 작성한다