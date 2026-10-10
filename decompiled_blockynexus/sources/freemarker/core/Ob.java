package freemarker.core;

import com.alibaba.android.arouter.utils.Consts;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.umeng.analytics.pro.au;
import freemarker.template.Template;

/* JADX INFO: compiled from: MessageUtil.java */
/* JADX INFO: loaded from: classes5.dex */
class Ob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f21487a = {"Use ?date, ?time, or ?datetime to tell FreeMarker the exact type.", "If you need a particular format only once, use ?string(pattern), like ?string('dd.MM.yyyy HH:mm:ss'), to specify which fields to display. "};

    static String a(String str, int i, int i2) {
        return a("in", str, i, i2);
    }

    static String a(Template template, int i, int i2) {
        return a("at", template, i, i2);
    }

    static String a(Nb nb, int i, int i2) {
        Template templateL = nb.l();
        return a("at", templateL != null ? templateL.g() : null, nb.s(), nb.t(), i, i2);
    }

    private static String a(String str, Template template, int i, int i2) {
        return a(str, template != null ? template.g() : null, i, i2);
    }

    private static String a(String str, String str2, int i, int i2) {
        return a(str, str2, null, false, i, i2);
    }

    private static String a(String str, String str2, String str3, boolean z, int i, int i2) {
        String string;
        String string2;
        if (i < 0) {
            str3 = null;
            string = "?eval-ed string";
        } else if (str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("template ");
            stringBuffer.append(freemarker.template.utility.h.f(str2));
            string = stringBuffer.toString();
        } else {
            string = "nameless template";
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("in ");
        stringBuffer2.append(string);
        if (str3 != null) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(" in ");
            stringBuffer3.append(z ? "function " : "macro ");
            stringBuffer3.append(freemarker.template.utility.h.e(str3));
            string2 = stringBuffer3.toString();
        } else {
            string2 = "";
        }
        stringBuffer2.append(string2);
        stringBuffer2.append(" ");
        stringBuffer2.append(str);
        stringBuffer2.append(" ");
        stringBuffer2.append(a(i, i2));
        return stringBuffer2.toString();
    }

    static String a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("line ");
        if (i < 0) {
            i -= -1000000001;
        }
        stringBuffer.append(i);
        stringBuffer.append(", column ");
        stringBuffer.append(i2);
        return stringBuffer.toString();
    }

    static String a(String str, int i) {
        boolean z;
        if (i < 5) {
            i = 5;
        }
        int iIndexOf = str.indexOf(10);
        if (iIndexOf != -1) {
            str = str.substring(0, iIndexOf);
            z = true;
        } else {
            z = false;
        }
        int iIndexOf2 = str.indexOf(13);
        if (iIndexOf2 != -1) {
            str = str.substring(0, iIndexOf2);
            z = true;
        }
        if (str.length() > i) {
            str = str.substring(0, i - 3);
            z = true;
        }
        if (!z) {
            return str;
        }
        if (str.endsWith(Consts.DOT)) {
            if (str.endsWith("..")) {
                if (str.endsWith(TextEllipsizeUtil.SignLib.END_POINT)) {
                    return str;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(Consts.DOT);
                return stringBuffer.toString();
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append("..");
            return stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(str);
        stringBuffer3.append(TextEllipsizeUtil.SignLib.END_POINT);
        return stringBuffer3.toString();
    }

    static StringBuffer a(StringBuffer stringBuffer, Hb hb) {
        boolean z = ((hb instanceof Sb) || (hb instanceof Kb) || (hb instanceof C2851yb) || (hb instanceof AbstractC2781b)) ? false : true;
        if (z) {
            stringBuffer.append('(');
        }
        stringBuffer.append(hb.e());
        if (z) {
            stringBuffer.append(')');
        }
        return stringBuffer;
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        char lowerCase = Character.toLowerCase(str.charAt(0));
        if (lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i') {
            return "an";
        }
        if (lowerCase == 'h') {
            String lowerCase2 = str.toLowerCase();
            return (lowerCase2.startsWith("has") || lowerCase2.startsWith("hi")) ? au.at : lowerCase2.startsWith("ht") ? "an" : "a(n)";
        }
        if (lowerCase == 'u' || lowerCase == 'o') {
            return "a(n)";
        }
        char cCharAt = str.length() > 1 ? str.charAt(1) : (char) 0;
        return (lowerCase != 'x' || cCharAt == 'a' || cCharAt == 'e' || cCharAt == 'i' || cCharAt == 'a' || cCharAt == 'o' || cCharAt == 'u') ? au.at : "an";
    }
}
