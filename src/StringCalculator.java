import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 쉼표 또는 콜론을 구분자로 가지는 문자열을 전달하는 경우 구분자로 분리한 각 숫자의 합을 반환한다.
// 앞서 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
// 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리해야한다.

public class StringCalculator {

    public int add(String text) {
        if(isBlank(text)) return 0;
        return sum(toInts(split(text)));
    }

    private String[] split(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(",|:");
    }

    private boolean isBlank(String text){
        return text == null | text.isEmpty();
    }

    private int[] toInts(String[] values){
        int[] numbers = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if(number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers){
        int sum = 0;
        for(int value : numbers) {
            sum += value;
        }
        return sum;
    }
}
