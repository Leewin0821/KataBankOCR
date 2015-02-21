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
        int expectedResult = 4;

        //When
        int actualResult = digitsParser.parse(SINGLE_DIGIT_TEXT_FILE_PATH);

        //Then
        assertThat(actualResult, is(expectedResult));
    }
}