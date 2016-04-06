
import org.junit.Test;

public class NumberDisplayTest {
    @Test
    public void shouldBeAbleToCreateNumberDisplay() throws Exception {
        new NumberDisplay(1,7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfMinLargerMax() throws Exception {
        new NumberDisplay(10,5);
    }





}