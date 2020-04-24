import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {
        // 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자로 분리한 각 숫자의 합을 반환한다.
        // 앞서 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
        // 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리해야한다.
        int answer = 0;
        String[] tokens;
        String delimeter = ",|:";
        if(text == null) return 0;
        if(text.isEmpty()) return 0;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            delimeter = m.group(1);
            text = m.group(2);
        }
        tokens = text.split(delimeter);
        for (String token : tokens) {
            answer += Integer.parseInt(token);
        }
        return answer;
    }
}
