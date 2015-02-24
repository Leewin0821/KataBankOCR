import com.tw.leewin.katabankocr.DigitsParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public void should_return_correct_digits_given_multiple_digits_with_same_number() throws Exception {
        //Given
        String MULTIPLE_DIGITS_WITH_SAME_NUMBER_TEXT_FILE_PATH = getClass().getClassLoader().getResource("MultipleDigitsTextFileWithSameNumber.txt").getPath();
        String expectedResult = "888888888";

        //When
        String actualResult = digitsParser.parse(MULTIPLE_DIGITS_WITH_SAME_NUMBER_TEXT_FILE_PATH);

        //Then
        assertThat(actualResult, is(expectedResult));
    }

    @Test
    public void should_return_correct_digits_given_multiple_digits_with_different_number() throws Exception {
        //Given
        String MULTIPLE_DIGITS_WITH_DIFFERENT_NUMBER_TEXT_FILE_PATH = getClass().getClassLoader().getResource("MultipleDigitsTextFileWithDifferentNumber.txt").getPath();
        String expectedResult = "123456789";

        //When
        String actualResult = digitsParser.parse(MULTIPLE_DIGITS_WITH_DIFFERENT_NUMBER_TEXT_FILE_PATH);

        //Then
        assertThat(actualResult, is(expectedResult));
    }

//    @Test
//    public void should_return_correct_digits_given_multiple_digits_with_error_number() throws Exception {
//        //Given
//        String MULTIPLE_DIGITS_WITH_DIFFERENT_NUMBER_TEXT_FILE_PATH = getClass().getClassLoader().getResource("MultipleDigitsTextFileWithErrorNumber.txt").getPath();
//        String expectedResult = "12345678? ILL";
//
//        //When
//        String actualResult = digitsParser.parse(MULTIPLE_DIGITS_WITH_DIFFERENT_NUMBER_TEXT_FILE_PATH);
//
//        //Then
//        assertThat(actualResult, is(expectedResult));
//    }

}