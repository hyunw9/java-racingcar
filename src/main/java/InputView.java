import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public String getNames() throws IOException {
        return input.readLine();
    }

    public int getTryTimes() throws IOException {
        String tryTimesStr = input.readLine();
        return Integer.parseInt(tryTimesStr);
    }
}
