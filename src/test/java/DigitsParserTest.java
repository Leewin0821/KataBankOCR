import com.tw.leewin.katabankocr.DigitsParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DigitsParserTest {
    private DigitsParser digitsParser;
    
    @Before
    public void setUp() throws Exception {
        digitsParser = new DigitsParser();
    }

    @After
    public void tearDown() throws Exception {
        digitsParser = null;
    }

    @Test
    public void shouldReturnCorrectSingleDigitWhenGivenSingleDigitTextFile() throws Exception {
        //Given
        final String SINGLE_DIGIT_TEXT_FILE_PATH = "SingleDigitTextFile.txt";
        String expectedResult = "|_|  |";

        //When
        String actualResult = digitsParser.parse(SINGLE_DIGIT_TEXT_FILE_PATH);

        //Then
        for (int index = 0; index < actualResult.length(); index++) {
            System.out.println(actualResult.charAt(index));
        }
        byte[] bytes = actualResult.getBytes("UTF-8");
        for (int index = 0; index < bytes.length; index++) {
            System.out.println(bytes[index]);
        }
        assertThat(actualResult, is(expectedResult));
    }
}