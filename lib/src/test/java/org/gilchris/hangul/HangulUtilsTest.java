package org.gilchris.hangul;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void testGetAllJaum_한글조합() {
        assertEquals("ㄱㄱ", HangulUtils.getAllJaum("가격"));
        assertEquals("ㄲㅁㄱ", HangulUtils.getAllJaum("까마귀"));
        assertEquals("ㄴㅇ", HangulUtils.getAllJaum("노을"));
        assertEquals("ㄷㄴ", HangulUtils.getAllJaum("동네"));
        assertEquals("ㄸㅂㄸㅂ", HangulUtils.getAllJaum("뚜벅뚜벅"));
        assertEquals("ㄹㅂ", HangulUtils.getAllJaum("루비"));
        assertEquals("ㅂ", HangulUtils.getAllJaum("배"));
        assertEquals("ㅃㄱㅅ", HangulUtils.getAllJaum("빨강색"));
        assertEquals("ㅅㅅㅈ", HangulUtils.getAllJaum("소세지"));
        assertEquals("ㅆㄸ", HangulUtils.getAllJaum("쑥떡"));
        assertEquals("ㅇㄹㄴㄹ", HangulUtils.getAllJaum("우리나라"));
        assertEquals("ㅈㅁㅂ", HangulUtils.getAllJaum("주먹밥"));
        assertEquals("ㅉㅈㅁ", HangulUtils.getAllJaum("짜장면"));
        assertEquals("ㅊㅈㅊㅈ", HangulUtils.getAllJaum("추적추적"));
        assertEquals("ㅋㅍ", HangulUtils.getAllJaum("카페"));
        assertEquals("ㅌㅁㅌ", HangulUtils.getAllJaum("토마토"));
        assertEquals("ㅍㄷ", HangulUtils.getAllJaum("포도"));
        assertEquals("ㅎㄴ", HangulUtils.getAllJaum("하늘"));
    }

    @Test
    public void testGetAllJaum_섞어서() {
        assertEquals("ㄱㄱㅇ#400ㅇㅇㄴㄷ#", HangulUtils.getAllJaum("가격은 400원입니다."));
        assertEquals("ENGLISHㄴ#ㅆ#DEFFICULTㅎ#", HangulUtils.getAllJaum("English는 쏘 defficult해!"));
    }

    @Test
    public void testConvertNFDToNFC() {
        String a = new StringBuilder()
            .append(Character.toString(4352)) // ㄱ
            .append(Character.toString(4449)) // ㅏ
            .append(Character.toString(4540)) // ㅇ
            .toString();
        assertEquals("강", HangulUtils.convertNFDToNFC(a));

        String b = new StringBuilder()
            .append(Character.toString(4355)) // ㄷ
            .append(Character.toString(4449)) // ㅏ
            .append(Character.toString(4528)) // ㄹㄱ
            .toString();
        assertEquals("닭", HangulUtils.convertNFDToNFC(b));

        String c = "Normal String!!";
        assertEquals(c, HangulUtils.convertNFDToNFC(c));
    }

    @Test
    public void testIsHangulCodePoint() {
        assertTrue(HangulUtils.isHangulCodePoint("가".codePointAt(0)));
        assertTrue(HangulUtils.isHangulCodePoint("힣".codePointAt(0)));
        assertTrue(HangulUtils.isHangulCodePoint("ㄱ".codePointAt(0)));
        assertTrue(HangulUtils.isHangulCodePoint("ㅣ".codePointAt(0)));
        assertTrue(HangulUtils.isHangulCodePoint(4352)); // ㄱ (NFD)
        assertTrue(HangulUtils.isHangulCodePoint(4546)); // ㅎ (NFD) 받침
    }

    @Test
    public void testIsContainsHangul() {
        assertTrue(HangulUtils.isContainsHangul("안녕하세요"));
        assertFalse(HangulUtils.isContainsHangul(".... !!!!"));
        assertTrue(HangulUtils.isContainsHangul("Hello 반가워요."));
    }
}
