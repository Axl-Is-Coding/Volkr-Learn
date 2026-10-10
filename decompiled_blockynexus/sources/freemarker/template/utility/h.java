package freemarker.template.utility;

import freemarker.core.BugException;
import freemarker.core.Environment;
import freemarker.template.Version;

/* JADX INFO: compiled from: StringUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f21753a = a();

    private static char a(int i) {
        return (char) (i < 10 ? i + 48 : (i - 10) + 65);
    }

    public static String a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '<' || ((cCharAt == '>' && i > 1 && str.charAt(i - 1) == ']' && str.charAt(i - 2) == ']') || cCharAt == '&')) {
                StringBuffer stringBuffer = new StringBuffer(str.substring(0, i));
                if (cCharAt == '&') {
                    stringBuffer.append("&amp;");
                } else if (cCharAt == '<') {
                    stringBuffer.append("&lt;");
                } else {
                    if (cCharAt != '>') {
                        throw new BugException();
                    }
                    stringBuffer.append("&gt;");
                }
                int i2 = i + 1;
                int i3 = i2;
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == '<' || ((cCharAt2 == '>' && i2 > 1 && str.charAt(i2 - 1) == ']' && str.charAt(i2 - 2) == ']') || cCharAt2 == '&')) {
                        stringBuffer.append(str.substring(i3, i2));
                        if (cCharAt2 == '&') {
                            stringBuffer.append("&amp;");
                        } else if (cCharAt2 == '<') {
                            stringBuffer.append("&lt;");
                        } else {
                            if (cCharAt2 != '>') {
                                throw new BugException();
                            }
                            stringBuffer.append("&gt;");
                        }
                        i3 = i2 + 1;
                    }
                    i2++;
                }
                if (i3 < length) {
                    stringBuffer.append(str.substring(i3));
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    public static String b(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '<' || cCharAt == '&' || cCharAt == '\"') {
                StringBuffer stringBuffer = new StringBuffer(str.substring(0, i));
                if (cCharAt == '\"') {
                    stringBuffer.append("&quot;");
                } else if (cCharAt == '&') {
                    stringBuffer.append("&amp;");
                } else if (cCharAt == '<') {
                    stringBuffer.append("&lt;");
                }
                int i2 = i + 1;
                int i3 = i2;
                while (i2 < length) {
                    char cCharAt2 = str.charAt(i2);
                    if (cCharAt2 == '<' || cCharAt2 == '&' || cCharAt2 == '\"') {
                        stringBuffer.append(str.substring(i3, i2));
                        if (cCharAt2 == '\"') {
                            stringBuffer.append("&quot;");
                        } else if (cCharAt2 == '&') {
                            stringBuffer.append("&amp;");
                        } else if (cCharAt2 == '<') {
                            stringBuffer.append("&lt;");
                        }
                        i3 = i2 + 1;
                    }
                    i2++;
                }
                if (i3 < length) {
                    stringBuffer.append(str.substring(i3));
                }
                return stringBuffer.toString();
            }
        }
        return str;
    }

    public static boolean b(char c2) {
        return c2 < 170 ? (c2 >= 'a' && c2 <= 'z') || (c2 >= '@' && c2 <= 'Z') || c2 == '$' || c2 == '_' : c2 < 43000 ? c2 < 11631 ? c2 < 8488 ? c2 < 8336 ? c2 < 216 ? c2 < 186 ? c2 == 170 || c2 == 181 : c2 == 186 || (c2 >= 192 && c2 <= 214) : c2 < 8305 ? (c2 >= 216 && c2 <= 246) || (c2 >= 248 && c2 <= 8191) : c2 == 8305 || c2 == 8319 : c2 < 8469 ? c2 < 8455 ? (c2 >= 8336 && c2 <= 8348) || c2 == 8450 : c2 == 8455 || (c2 >= 8458 && c2 <= 8467) : c2 < 8484 ? c2 == 8469 || (c2 >= 8473 && c2 <= 8477) : c2 == 8484 || c2 == 8486 : c2 < 11312 ? c2 < 8517 ? c2 < 8495 ? c2 == 8488 || (c2 >= 8490 && c2 <= 8493) : (c2 >= 8495 && c2 <= 8505) || (c2 >= 8508 && c2 <= 8511) : c2 < 8579 ? (c2 >= 8517 && c2 <= 8521) || c2 == 8526 : (c2 >= 8579 && c2 <= 8580) || (c2 >= 11264 && c2 <= 11310) : c2 < 11520 ? c2 < 11499 ? (c2 >= 11312 && c2 <= 11358) || (c2 >= 11360 && c2 <= 11492) : (c2 >= 11499 && c2 <= 11502) || (c2 >= 11506 && c2 <= 11507) : c2 < 11565 ? (c2 >= 11520 && c2 <= 11557) || c2 == 11559 : c2 == 11565 || (c2 >= 11568 && c2 <= 11623) : c2 < 12784 ? c2 < 11728 ? c2 < 11696 ? c2 < 11680 ? c2 == 11631 || (c2 >= 11648 && c2 <= 11670) : (c2 >= 11680 && c2 <= 11686) || (c2 >= 11688 && c2 <= 11694) : c2 < 11712 ? (c2 >= 11696 && c2 <= 11702) || (c2 >= 11704 && c2 <= 11710) : (c2 >= 11712 && c2 <= 11718) || (c2 >= 11720 && c2 <= 11726) : c2 < 12337 ? c2 < 11823 ? (c2 >= 11728 && c2 <= 11734) || (c2 >= 11736 && c2 <= 11742) : c2 == 11823 || (c2 >= 12293 && c2 <= 12294) : c2 < 12352 ? (c2 >= 12337 && c2 <= 12341) || (c2 >= 12347 && c2 <= 12348) : (c2 >= 12352 && c2 <= 12687) || (c2 >= 12704 && c2 <= 12730) : c2 < 42623 ? c2 < 42192 ? c2 < 13312 ? (c2 >= 12784 && c2 <= 12799) || (c2 >= 13056 && c2 <= 13183) : (c2 >= 13312 && c2 <= 19893) || (c2 >= 19968 && c2 <= 42124) : c2 < 42512 ? (c2 >= 42192 && c2 <= 42237) || (c2 >= 42240 && c2 <= 42508) : (c2 >= 42512 && c2 <= 42539) || (c2 >= 42560 && c2 <= 42606) : c2 < 42891 ? c2 < 42775 ? (c2 >= 42623 && c2 <= 42647) || (c2 >= 42656 && c2 <= 42725) : (c2 >= 42775 && c2 <= 42783) || (c2 >= 42786 && c2 <= 42888) : c2 < 42912 ? (c2 >= 42891 && c2 <= 42894) || (c2 >= 42896 && c2 <= 42899) : c2 >= 42912 && c2 <= 42922 : c2 < 43808 ? c2 < 43588 ? c2 < 43259 ? c2 < 43072 ? c2 < 43015 ? (c2 >= 43000 && c2 <= 43009) || (c2 >= 43011 && c2 <= 43013) : (c2 >= 43015 && c2 <= 43018) || (c2 >= 43020 && c2 <= 43042) : c2 < 43216 ? (c2 >= 43072 && c2 <= 43123) || (c2 >= 43138 && c2 <= 43187) : (c2 >= 43216 && c2 <= 43225) || (c2 >= 43250 && c2 <= 43255) : c2 < 43396 ? c2 < 43312 ? c2 == 43259 || (c2 >= 43264 && c2 <= 43301) : (c2 >= 43312 && c2 <= 43334) || (c2 >= 43360 && c2 <= 43388) : c2 < 43520 ? (c2 >= 43396 && c2 <= 43442) || (c2 >= 43471 && c2 <= 43481) : (c2 >= 43520 && c2 <= 43560) || (c2 >= 43584 && c2 <= 43586) : c2 < 43712 ? c2 < 43648 ? c2 < 43616 ? (c2 >= 43588 && c2 <= 43595) || (c2 >= 43600 && c2 <= 43609) : (c2 >= 43616 && c2 <= 43638) || c2 == 43642 : c2 < 43701 ? (c2 >= 43648 && c2 <= 43695) || c2 == 43697 : (c2 >= 43701 && c2 <= 43702) || (c2 >= 43705 && c2 <= 43709) : c2 < 43762 ? c2 < 43739 ? c2 == 43712 || c2 == 43714 : (c2 >= 43739 && c2 <= 43741) || (c2 >= 43744 && c2 <= 43754) : c2 < 43785 ? (c2 >= 43762 && c2 <= 43764) || (c2 >= 43777 && c2 <= 43782) : (c2 >= 43785 && c2 <= 43790) || (c2 >= 43793 && c2 <= 43798) : c2 < 64326 ? c2 < 64275 ? c2 < 44032 ? c2 < 43968 ? (c2 >= 43808 && c2 <= 43814) || (c2 >= 43816 && c2 <= 43822) : (c2 >= 43968 && c2 <= 44002) || (c2 >= 44016 && c2 <= 44025) : c2 < 55243 ? (c2 >= 44032 && c2 <= 55203) || (c2 >= 55216 && c2 <= 55238) : (c2 >= 55243 && c2 <= 55291) || (c2 >= 63744 && c2 <= 64262) : c2 < 64312 ? c2 < 64287 ? (c2 >= 64275 && c2 <= 64279) || c2 == 64285 : (c2 >= 64287 && c2 <= 64296) || (c2 >= 64298 && c2 <= 64310) : c2 < 64320 ? (c2 >= 64312 && c2 <= 64316) || c2 == 64318 : (c2 >= 64320 && c2 <= 64321) || (c2 >= 64323 && c2 <= 64324) : c2 < 65313 ? c2 < 65008 ? c2 < 64848 ? (c2 >= 64326 && c2 <= 64433) || (c2 >= 64467 && c2 <= 64829) : (c2 >= 64848 && c2 <= 64911) || (c2 >= 64914 && c2 <= 64967) : c2 < 65142 ? (c2 >= 65008 && c2 <= 65019) || (c2 >= 65136 && c2 <= 65140) : (c2 >= 65142 && c2 <= 65276) || (c2 >= 65296 && c2 <= 65305) : c2 < 65482 ? c2 < 65382 ? (c2 >= 65313 && c2 <= 65338) || (c2 >= 65345 && c2 <= 65370) : (c2 >= 65382 && c2 <= 65470) || (c2 >= 65474 && c2 <= 65479) : c2 < 65498 ? (c2 >= 65482 && c2 <= 65487) || (c2 >= 65490 && c2 <= 65495) : c2 >= 65498 && c2 <= 65500;
    }

    public static String c(String str) {
        char c2 = '\"';
        if (str.indexOf(34) != -1 && str.indexOf(39) == -1) {
            c2 = '\'';
        }
        return a(str, c2, true);
    }

    private static boolean c(char c2) {
        return c2 == '$' || c2 == '#';
    }

    public static boolean d(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (i == 0 && (cCharAt == '-' || cCharAt == '.' || Character.isDigit(cCharAt))) {
                return false;
            }
            if (!Character.isLetterOrDigit(cCharAt) && cCharAt != ':' && cCharAt != '_' && cCharAt != '-' && cCharAt != '.') {
                return false;
            }
        }
        return true;
    }

    public static String e(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                stringBuffer.append("\\\"");
            } else if (cCharAt == '\\') {
                stringBuffer.append("\\\\");
            } else if (cCharAt >= ' ') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '\n') {
                stringBuffer.append("\\n");
            } else if (cCharAt == '\r') {
                stringBuffer.append("\\r");
            } else if (cCharAt == '\f') {
                stringBuffer.append("\\f");
            } else if (cCharAt == '\b') {
                stringBuffer.append("\\b");
            } else if (cCharAt == '\t') {
                stringBuffer.append("\\t");
            } else {
                stringBuffer.append("\\u00");
                stringBuffer.append(a(cCharAt / 16));
                stringBuffer.append(a(cCharAt & 15));
            }
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public static String f(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                stringBuffer.append("\\\"");
            } else if (cCharAt == '\\') {
                stringBuffer.append("\\\\");
            } else if (cCharAt == '<') {
                stringBuffer.append("\\u003C");
            } else if (cCharAt >= ' ') {
                stringBuffer.append(cCharAt);
            } else if (cCharAt == '\n') {
                stringBuffer.append("\\n");
            } else if (cCharAt == '\r') {
                stringBuffer.append("\\r");
            } else if (cCharAt == '\f') {
                stringBuffer.append("\\f");
            } else if (cCharAt == '\b') {
                stringBuffer.append("\\b");
            } else if (cCharAt == '\t') {
                stringBuffer.append("\\t");
            } else {
                stringBuffer.append("\\u00");
                stringBuffer.append(a(cCharAt / 16));
                stringBuffer.append(a(cCharAt & 15));
            }
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    public static int g(String str) {
        return new Version(str).intValue();
    }

    public static String[] b(String str, char c2) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (true) {
            int iIndexOf = str.indexOf(c2, i2);
            if (iIndexOf == -1) {
                break;
            }
            i3++;
            i2 = iIndexOf + 1;
        }
        String[] strArr = new String[i3];
        int i4 = 0;
        while (i <= length) {
            int iIndexOf2 = str.indexOf(c2, i);
            if (iIndexOf2 == -1) {
                iIndexOf2 = length;
            }
            strArr[i4] = str.substring(i, iIndexOf2);
            i = iIndexOf2 + 1;
            i4++;
        }
        return strArr;
    }

    public static String b(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.toString();
        } catch (Throwable th) {
            return a(obj, th);
        }
    }

    private static char[] a() {
        char[] cArr = new char[93];
        for (int i = 0; i < 32; i++) {
            cArr[i] = 1;
        }
        cArr[92] = '\\';
        cArr[39] = '\'';
        cArr[34] = '\"';
        cArr[60] = 'l';
        cArr[62] = 'g';
        cArr[38] = 'a';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[12] = 'f';
        cArr[13] = 'r';
        return cArr;
    }

    public static String a(String str, char c2) {
        return a(str, c2, false);
    }

    private static String a(String str, char c2, boolean z) {
        int length = str.length();
        char c3 = '\'';
        if (c2 == 0) {
            c3 = 0;
        } else if (c2 != '\"') {
            if (c2 != '\'') {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unsupported quotation character: ");
                stringBuffer.append(c2);
                throw new IllegalArgumentException(stringBuffer.toString());
            }
            c3 = '\"';
        }
        int length2 = f21753a.length;
        StringBuffer stringBuffer2 = null;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            char c4 = '{';
            if (cCharAt < length2) {
                c4 = f21753a[cCharAt];
            } else if (cCharAt != '{' || i <= 0 || !c(str.charAt(i - 1))) {
                c4 = 0;
            }
            if (c4 != 0 && c4 != c3) {
                if (stringBuffer2 == null) {
                    stringBuffer2 = new StringBuffer(str.length() + 4 + (z ? 2 : 0));
                    if (z) {
                        stringBuffer2.append(c2);
                    }
                    stringBuffer2.append(str.substring(0, i));
                }
                if (c4 == 1) {
                    stringBuffer2.append("\\x00");
                    int i2 = (cCharAt >> 4) & 15;
                    char c5 = (char) (cCharAt & 15);
                    stringBuffer2.append((char) (i2 < 10 ? i2 + 48 : (i2 - 10) + 65));
                    stringBuffer2.append((char) (c5 < '\n' ? c5 + '0' : (c5 - '\n') + 65));
                } else {
                    stringBuffer2.append('\\');
                    stringBuffer2.append(c4);
                }
            } else if (stringBuffer2 != null) {
                stringBuffer2.append(cCharAt);
            }
        }
        if (stringBuffer2 != null) {
            if (z) {
                stringBuffer2.append(c2);
            }
            return stringBuffer2.toString();
        }
        if (!z) {
            return str;
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(c2);
        stringBuffer3.append(str);
        stringBuffer3.append(c2);
        return stringBuffer3.toString();
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, false, false);
    }

    public static String a(String str, String str2, String str3, boolean z, boolean z2) {
        int length = str2.length();
        int i = 0;
        if (length == 0) {
            int length2 = str3.length();
            if (length2 == 0) {
                return str;
            }
            if (z2) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str3);
                stringBuffer.append(str);
                return stringBuffer.toString();
            }
            int length3 = str.length();
            StringBuffer stringBuffer2 = new StringBuffer(((length3 + 1) * length2) + length3);
            stringBuffer2.append(str3);
            while (i < length3) {
                stringBuffer2.append(str.charAt(i));
                stringBuffer2.append(str3);
                i++;
            }
            return stringBuffer2.toString();
        }
        if (z) {
            str2 = str2.toLowerCase();
        }
        String lowerCase = z ? str.toLowerCase() : str;
        int iIndexOf = lowerCase.indexOf(str2);
        if (iIndexOf == -1) {
            return str;
        }
        StringBuffer stringBuffer3 = new StringBuffer(str.length() + (Math.max(str3.length() - length, 0) * 3));
        do {
            stringBuffer3.append(str.substring(i, iIndexOf));
            stringBuffer3.append(str3);
            i = iIndexOf + length;
            iIndexOf = lowerCase.indexOf(str2, i);
            if (iIndexOf == -1) {
                break;
            }
        } while (!z2);
        stringBuffer3.append(str.substring(i));
        return stringBuffer3.toString();
    }

    public static String a(Object obj) {
        return e(obj != null ? obj.toString() : null);
    }

    public static boolean a(char c2) {
        return b(c2) || (c2 >= '0' && c2 <= '9');
    }

    public static boolean a(String str, String str2, String str3, Environment environment) {
        String strE = environment.e();
        if (strE != null && strE.equals(str3)) {
            if (str.equals(str2)) {
                return true;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("D:");
            stringBuffer.append(str2);
            return str.equals(stringBuffer.toString());
        }
        if (!"".equals(str3)) {
            String strC = environment.c(str3);
            if (strC == null) {
                return false;
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strC);
            stringBuffer2.append(":");
            stringBuffer2.append(str2);
            return str.equals(stringBuffer2.toString());
        }
        if (strE != null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("N:");
            stringBuffer3.append(str2);
            return str.equals(stringBuffer3.toString());
        }
        if (str.equals(str2)) {
            return true;
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("N:");
        stringBuffer4.append(str2);
        return str.equals(stringBuffer4.toString());
    }

    private static String a(Object obj, Throwable th) {
        String strA;
        try {
            strA = th.toString();
        } catch (Throwable unused) {
            strA = a.a(th);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(a.a(obj));
        stringBuffer.append(".toString() failed: ");
        stringBuffer.append(strA);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
