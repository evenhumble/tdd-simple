package io.qkits.todoandroid.utils;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void dateToStamp() throws ParseException {
        long result =DateUtil.dateToStamp("1980-01-01 10:00:00");
        assertNotNull(result);
    }

    @Test
    public void stampToDate() {
    }
}