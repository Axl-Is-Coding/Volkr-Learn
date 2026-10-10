package com.sandboxol.imchat.utils;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class EmojiUtils {
    public static final String unicodeReg = "[一-龿䷀-䷿\u0000-\u007f\u0080-ÿĀ-ſƀ-ɏɐ-ʯʰ-˿̀-ͯͰ-ϿЀ-ӿԀ-ԯ\u0530-֏\u0590-\u05ff\u0600-ۿ܀-ݏݐ-ݿހ-\u07bfࠀ-\u085fࡠ-ࡿࢀ-ࢯऀ-ॿঀ-\u09ff\u0a00-\u0a7f\u0a80-૿\u0b00-\u0b7f\u0b80-\u0bffఀ-౿ಀ-\u0cffഀ-ൿ\u0d80-\u0dff\u0e00-\u0e7f\u0e80-\u0effༀ-\u0fffက-႟Ⴀ-ჿᄀ-ᇿሀ-\u137fᎀ-\u139fᎠ-\u13ff᐀-ᙿ\u1680-\u169fᚠ-\u16ffᜀ-ᜟᜠ-\u173fᝀ-\u175fᝠ-\u177fក-\u17ff᠀-\u18afᢰ-\u18ffᤀ-᥏ᥐ-\u197fᦀ-᧟᧠-᧿ᨀ-᨟ᨠ-\u1a5f᪀-\u1aefᬀ-\u1b7fᮀ-᮰ᯀ-᯿ᰀ-ᱏ᱐-᱿ᲀ-᳟ᴀ-ᵿᶀ-ᶿ᷀-᷿Ḁ-ỿἀ-\u1fff\u2000-\u206f⁰-\u209f₠-\u20cf⃐-\u20ff℀-⅏⅐-\u218f←-⇿∀-⋿⌀-⏿␀-\u243f⑀-\u245f①-⓿─-╿▀-▟■-◿☀-⛿✀-➿⟀-⟯⟰-⟿⠀-⣿⤀-⥿⦀-⧿⨀-⫿⬀-⯿Ⰰ-ⱟⱠ-ⱿⲀ-⳿ⴀ-\u2d2fⴰ-⵿ⶀ-\u2ddf⸀-\u2e7f⺀-\u2eff⼀-\u2fdf⿰-\u2fff\u3000-〿\u3040-ゟ゠-ヿ\u3100-ㄯ\u3130-\u318f㆐-㆟ㆠ-ㆿ㇀-\u31efㇰ-ㇿ㈀-㋿㌀-㏿㐀-䶿䷀-䷿一-龿ꀀ-\ua48f꒐-\ua4cfꔀ-ꘟꙠ-\ua6ff꜀-ꜟ꜠-ꟿꠀ-\ua82fꡀ-\ua87fꢀ-\ua8df꤀-\ua97fꦀ-꧟ꨀ-\uaa3fꩀ-ꩯꪀ-꫟\uab00-ꭟꮀ-ꮠ가-\ud7af\ue000-\uf8ff豈-\ufaffﬀ-ﭏﭐ-﷿︀-️︐-\ufe1f︠-︯︰-﹏﹐-\ufe6fﹰ-\ufeff\uff00-\uffef\ufff0-\uffff]";

    public static String convert(String str) {
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            stringBuffer.append("\\u");
            String hexString = Integer.toHexString(cCharAt >>> '\b');
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
            String hexString2 = Integer.toHexString(cCharAt & 255);
            if (hexString2.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString2);
        }
        return new String(stringBuffer).toUpperCase();
    }

    public static String emojiChange(String str, String str2) {
        try {
            Pattern patternCompile = Pattern.compile(unicodeReg);
            StringBuffer stringBuffer = new StringBuffer();
            boolean z = false;
            for (int i = 0; i < str.length(); i++) {
                String strValueOf = String.valueOf(str.charAt(i));
                if (patternCompile.matcher(strValueOf).find()) {
                    stringBuffer.append(strValueOf);
                } else if (!z) {
                    stringBuffer.append(str2);
                    z = true;
                }
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String revert(String str) {
        int i;
        if (str == null) {
            str = "";
        }
        if (str.indexOf("\\u") == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(1000);
        int i2 = 0;
        while (i2 < str.length() - 6) {
            int i3 = i2 + 6;
            String strSubstring = str.substring(i2, i3).substring(2);
            int iPow = 0;
            for (int i4 = 0; i4 < strSubstring.length(); i4++) {
                char cCharAt = strSubstring.charAt(i4);
                switch (cCharAt) {
                    case 'a':
                        i = 10;
                        break;
                    case 'b':
                        i = 11;
                        break;
                    case 'c':
                        i = 12;
                        break;
                    case 'd':
                        i = 13;
                        break;
                    case 'e':
                        i = 14;
                        break;
                    case 'f':
                        i = 15;
                        break;
                    default:
                        i = cCharAt - '0';
                        break;
                }
                iPow += i * ((int) Math.pow(16.0d, (strSubstring.length() - i4) - 1));
            }
            stringBuffer.append((char) iPow);
            i2 = i3;
        }
        return stringBuffer.toString();
    }
}
