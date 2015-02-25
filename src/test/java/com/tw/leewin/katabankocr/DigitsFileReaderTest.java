package com.tw.leewin.katabankocr;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DigitsFileReaderTest {

    @Test
    public void should_return_correct_string_given_multiple_same_number_test_file() throws Exception {

        //Given
        DigitsFileReader reader = DigitsFileReader.getInstance();
        String filePath = getClass().getClassLoader().getResource("reader_test_file.txt").getPath();
        ImmutableList<String> expectedList = ImmutableList.of(" _ ", "|_|", "|_|");

        //When
        List<String> actualList = reader.readDigitFile(filePath);

        //Then
        assertThat(actualList.size(), is(expectedList.size()));
        assertTrue(actualList.containsAll(expectedList));
        assertTrue(expectedList.containsAll(actualList));
    }
}