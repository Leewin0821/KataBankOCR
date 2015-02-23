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
    public void should_Return_Correct_Single_Digit_Given_Single_Digit_Text_File() throws Exception {
        //Given
        final String SINGLE_DIGIT_TEXT_FILE_PATH = "SingleDigitTextFile.txt";
        String expectedResult = "9";

        //When
        String actualResult = digitsParser.parse(SINGLE_DIGIT_TEXT_FILE_PATH);

        //Then
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_Return_Correct_Digits_Given_Multiple_Digits_With_Same_Number_Text_File() throws Exception {
        //Given
        final String MULTIPLE_DIGITS_WITH_SAME_NUMBER_TEXT_FILE_PATH = "MultipleDigitsTextFileWIthSameNumber.txt";
        String expectedResult = "888888888";

        //When
        String actualResult = digitsParser.parse(MULTIPLE_DIGITS_WITH_SAME_NUMBER_TEXT_FILE_PATH);

        //Then
        assertThat(actualResult, is(expectedResult));
    }
}