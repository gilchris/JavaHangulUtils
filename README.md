# JavaHangulUtils
Java Hangul(한글) Utils

# Features
* detecting hangul in string
* destract jaum in string
* changing NFD(for MacOS Hangul) to NFC(for Windows or Linux Hangul) format

## Detecting hangul in string

```
HangulUtils.isContainsHangul("This string includes 한글."); // true
```

## Extracting jaum in string

```
HangulUtils.getFirstJaum("첫 자음 추출"); // ㅊ
HangulUtils.getFirstJaum("the first character is English"); // T
HangulUtils.getFirstJaum("1. Best practise"); // 1
HangulUtils.getFirstJaum(" first character is not English, 한글 or number"); // #
```

```
HangulUtils.getAllJaum("모든 자음 추출"); // ㅁㄷ#ㅈㅇ#ㅊㅊ
HangulUtils.getAllJaum("2. 한글과 English"); // 2##ㅎㄱㄱ#ENGLISH
```

## NFD to NFC
Converting MacOS Hangul to Windows(or Linux) Hangul

```
HangulUtils.convertNFDToNFC("ㄱㅣㅁ"); // 김
```
