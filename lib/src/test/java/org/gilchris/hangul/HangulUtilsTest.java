package org.gilchris.hangul;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HangulUtilsTest {
    
    @Test
    public void testGetFirstJaum_한글조합() {
        assertEquals("ㄱ", HangulUtils.getFirstJaum("가격"));
        assertEquals("ㄲ", HangulUtils.getFirstJaum("까마귀"));
        assertEquals("ㄴ", HangulUtils.getFirstJaum("노을"));
        assertEquals("ㄷ", HangulUtils.getFirstJaum("동네"));
        assertEquals("ㄸ", HangulUtils.getFirstJaum("뚜벅뚜벅"));
        assertEquals("ㄹ", HangulUtils.getFirstJaum("루비"));
        assertEquals("ㅂ", HangulUtils.getFirstJaum("배"));
        assertEquals("ㅃ", HangulUtils.getFirstJaum("빨강색"));
        assertEquals("ㅅ", HangulUtils.getFirstJaum("소세지"));
        assertEquals("ㅆ", HangulUtils.getFirstJaum("쑥떡"));
        assertEquals("ㅇ", HangulUtils.getFirstJaum("우리나라"));
        assertEquals("ㅈ", HangulUtils.getFirstJaum("주먹밥"));
        assertEquals("ㅉ", HangulUtils.getFirstJaum("짜장면"));
        assertEquals("ㅊ", HangulUtils.getFirstJaum("추적추적"));
        assertEquals("ㅋ", HangulUtils.getFirstJaum("카페"));
        assertEquals("ㅌ", HangulUtils.getFirstJaum("토마토"));
        assertEquals("ㅍ", HangulUtils.getFirstJaum("포도"));
        assertEquals("ㅎ", HangulUtils.getFirstJaum("하늘"));
    }

    @Test
    public void testGetFirstJaum_한글자음() {
        assertEquals("ㄱ", HangulUtils.getFirstJaum("ㄱ"));
        assertEquals("ㄲ", HangulUtils.getFirstJaum("ㄲ"));
        assertEquals("ㄴ", HangulUtils.getFirstJaum("ㄴ"));
        assertEquals("ㄷ", HangulUtils.getFirstJaum("ㄷ"));
        assertEquals("ㄸ", HangulUtils.getFirstJaum("ㄸ"));
        assertEquals("ㄹ", HangulUtils.getFirstJaum("ㄹ"));
        assertEquals("ㅁ", HangulUtils.getFirstJaum("ㅁ"));
        assertEquals("ㅂ", HangulUtils.getFirstJaum("ㅂ"));
        assertEquals("ㅃ", HangulUtils.getFirstJaum("ㅃ"));
        assertEquals("ㅅ", HangulUtils.getFirstJaum("ㅅ"));
        assertEquals("ㅆ", HangulUtils.getFirstJaum("ㅆ"));
        assertEquals("ㅇ", HangulUtils.getFirstJaum("ㅇ"));
        assertEquals("ㅈ", HangulUtils.getFirstJaum("ㅈ"));
        assertEquals("ㅉ", HangulUtils.getFirstJaum("ㅉ"));
        assertEquals("ㅊ", HangulUtils.getFirstJaum("ㅊ"));
        assertEquals("ㅋ", HangulUtils.getFirstJaum("ㅋ"));
        assertEquals("ㅌ", HangulUtils.getFirstJaum("ㅌ"));
        assertEquals("ㅍ", HangulUtils.getFirstJaum("ㅍ"));
        assertEquals("ㅎ", HangulUtils.getFirstJaum("ㅎ"));
    }

    @Test
    public void testGetFirstJaum_English() {
        assertEquals("A", HangulUtils.getFirstJaum("apple"));
        assertEquals("C", HangulUtils.getFirstJaum("Cyber"));
        assertEquals("P", HangulUtils.getFirstJaum("Peace"));
        assertEquals("Z", HangulUtils.getFirstJaum("zoo"));
    }

    @Test
    public void testGetFirstJaum_Number() {
        assertEquals("1", HangulUtils.getFirstJaum("123Count"));
        assertEquals("0", HangulUtils.getFirstJaum("0 Cost"));
        
    }
}
