import java.util.List;

public class GameView {

    public void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).");
    }

    public void askTryCounts() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void showRacingStart() {
        System.out.println("실행 결과");
    }

    public void showProgress(String progress) {
        System.out.println(progress);
    }

    public void showWinner(List<String> winner) {
        String message = String.join(",", winner);
        message += "가 최종 우승했습니다.";
        System.out.println(message);
    }
}
