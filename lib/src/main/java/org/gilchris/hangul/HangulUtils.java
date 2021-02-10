package org.gilchris.hangul;

class HangulUtils {

    private static final String[] JAUM_SYLLABEL = new String[] { "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };
    private static final String[] JAUM_COMPATIVILITY = new String[] { "ㄱ", "ㄲ", "", "ㄴ", "", "", "ㄷ", "ㄸ", "ㄹ", "", "", "", "", "", "", "", "ㅁ", "ㅂ", "ㅃ", "", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };

    public static final String getFirstJaum(String in) {
        int intCodePoint = in.codePointAt(0);

        // 조합 한글
        int c = 44032; // 0xAC00 가
        for (short i = 0; i < 19; i++) {
            if (c <= intCodePoint && intCodePoint < (c + 588)) {
                return JAUM_SYLLABEL[i];
            }
            c += 588;
        }

        // 한글 자모 (맥에서 쓰는 방식)
        c = 4352;
        for (short i = 0; i < 19; i++) {
            if (c == intCodePoint) {
                return JAUM_SYLLABEL[i];
            }
            c += 1;
        }

        // 한글 자모
        c = 12593;
        for (short i = 0; i < 30; i++) {
            if (c == intCodePoint) {
                return JAUM_COMPATIVILITY[i];
            }
            c += 1;
        }

        // 영어
        c = 65;
        for (short i = 0; i < 26; i++) {
            if (c == intCodePoint || (c + 32) == intCodePoint) {
                return Character.toString(c);
            }
            c++;
        }

        // 숫자
        c = 48;
        for (short i = 0; i < 10; i++) {
            if (c == intCodePoint) {
                return Character.toString(intCodePoint);
            }
            c++;
        }

        // 그 외
        return "#";
    }
}