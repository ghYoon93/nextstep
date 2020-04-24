import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator cal;
    @Before
    public void setup(){
         cal = new StringCalculator();
    }

    @Test
    public void 공백은_0을_리턴(){
        //given
        String text ="";
        //when
        int ans = cal.add(text);
        //then
        assertEquals(0, ans);
    }
    @Test
    public void 쉼표_구분자_전달(){
        String text="1,2,3";
        int ans = cal.add(text);
        assertEquals(6,ans);
    }
    @Test
    public void 콜론_구분자_전달(){
        String text="1:2:3:";
        int ans = cal.add(text);
        assertEquals(6,ans);
    }
    @Test
    public void 쉼표_콜론_구분자_전달(){
        String text= "1,2:3";
        int ans = cal.add(text);
        assertEquals(6,ans);
    }
    @Test
    public void 커스텀_구분자_전달(){
        String text="//;\n1;2;3";
        int ans = cal.add(text);
        assertEquals(6,ans);
    }
    @Test(expected = RuntimeException.class)
    public void 음수일_때_Exception(){
        cal.add("-1,2,3");
    }
}