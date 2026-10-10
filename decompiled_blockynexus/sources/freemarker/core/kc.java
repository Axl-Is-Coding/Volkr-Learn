package freemarker.core;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import freemarker.template.Template;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: _ErrorDescriptionBuilder.java */
/* JADX INFO: loaded from: classes5.dex */
public class kc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21523a = d.b.b.d("freemarker.runtime");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f21525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Hb f21526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f21527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f21528f;
    private Object[] g;
    private Template h;

    /* JADX INFO: compiled from: _ErrorDescriptionBuilder.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Yb f21529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Qb f21530b;

        private a() {
        }
    }

    public kc(String str) {
        this.f21524b = str;
        this.f21525c = null;
    }

    public static String b(Object obj) {
        return a(obj, true);
    }

    private kc c(Object obj) {
        if (this.f21528f == null) {
            this.f21528f = obj;
        } else {
            Object[] objArr = this.g;
            if (objArr == null) {
                this.g = new Object[]{obj};
            } else {
                int length = objArr.length;
                Object[] objArr2 = new Object[length + 1];
                for (int i = 0; i < length; i++) {
                    objArr2[i] = this.g[i];
                }
                objArr2[length] = obj;
                this.g = objArr2;
            }
        }
        return this;
    }

    public String a(Xb xb, boolean z) {
        Hb hb;
        if (this.f21526d == null && this.g == null && this.f21528f == null && this.f21525c == null) {
            return this.f21524b;
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        if (xb != null && (hb = this.f21526d) != null && this.f21527e) {
            try {
                a aVarA = a(xb, hb, 0);
                if (aVarA != null) {
                    stringBuffer.append("For ");
                    String strH = aVarA.f21529a.h();
                    char c2 = '\"';
                    if (strH.indexOf(34) != -1) {
                        c2 = '`';
                    }
                    stringBuffer.append(c2);
                    stringBuffer.append(strH);
                    stringBuffer.append(c2);
                    stringBuffer.append(" ");
                    stringBuffer.append(aVarA.f21530b);
                    stringBuffer.append(": ");
                }
            } catch (Throwable th) {
                f21523a.a("Error when searching blamer for better error message.", th);
            }
        }
        String str = this.f21524b;
        if (str != null) {
            stringBuffer.append(str);
        } else {
            a(stringBuffer, this.f21525c);
        }
        String str2 = null;
        int i = 1;
        if (this.f21526d != null) {
            for (int length = stringBuffer.length() - 1; length >= 0 && Character.isWhitespace(stringBuffer.charAt(length)); length--) {
                stringBuffer.deleteCharAt(length);
            }
            char cCharAt = stringBuffer.length() > 0 ? stringBuffer.charAt(stringBuffer.length() - 1) : (char) 0;
            if (cCharAt != 0) {
                stringBuffer.append('\n');
            }
            if (cCharAt != ':') {
                stringBuffer.append("The blamed expression:\n");
            }
            String[] strArrB = b(this.f21526d.toString());
            int i2 = 0;
            while (i2 < strArrB.length) {
                stringBuffer.append(i2 == 0 ? "==> " : "\n    ");
                stringBuffer.append(strArrB[i2]);
                i2++;
            }
            stringBuffer.append("  [");
            stringBuffer.append(this.f21526d.k());
            stringBuffer.append(']');
            if (a(this.f21526d, 0)) {
                str2 = "It has been noticed that you are using ${...} as the sole content of a quoted string. That does nothing but forcably converts the value inside ${...} to string (as it inserts it into the enclosing string). If that's not what you meant, just remove the quotation marks, ${ and }; you don't need them. If you indeed wanted to convert to string, use myExpression?string instead.";
            }
        }
        if (z) {
            Object[] objArr = this.g;
            int length2 = (objArr != null ? objArr.length : 0) + (this.f21528f != null ? 1 : 0) + (str2 != null ? 1 : 0);
            Object[] objArr2 = this.g;
            if (objArr2 == null || length2 != objArr2.length) {
                objArr2 = new Object[length2];
                Object obj = this.f21528f;
                if (obj != null) {
                    objArr2[0] = obj;
                } else {
                    i = 0;
                }
                if (this.g != null) {
                    int i3 = 0;
                    while (true) {
                        Object[] objArr3 = this.g;
                        if (i3 >= objArr3.length) {
                            break;
                        }
                        objArr2[i] = objArr3[i3];
                        i3++;
                        i++;
                    }
                }
                if (str2 != null) {
                    objArr2[i] = str2;
                }
            }
            if (objArr2 != null && objArr2.length > 0) {
                stringBuffer.append("\n\n");
                for (int i4 = 0; i4 < objArr2.length; i4++) {
                    if (i4 != 0) {
                        stringBuffer.append('\n');
                    }
                    stringBuffer.append("----");
                    stringBuffer.append('\n');
                    stringBuffer.append("Tip: ");
                    Object obj2 = objArr2[i4];
                    if (obj2 instanceof Object[]) {
                        a(stringBuffer, (Object[]) obj2);
                    } else {
                        stringBuffer.append(objArr2[i4]);
                    }
                }
                stringBuffer.append('\n');
                stringBuffer.append("----");
            }
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return a((Xb) null, true);
    }

    private String[] b(String str) {
        return freemarker.template.utility.h.b(freemarker.template.utility.h.a(freemarker.template.utility.h.a(str, "\r\n", UMCustomLogInfoBuilder.LINE_SEP), "\r", UMCustomLogInfoBuilder.LINE_SEP), '\n');
    }

    public kc(Object[] objArr) {
        this.f21525c = objArr;
        this.f21524b = null;
    }

    public kc b(Object[] objArr) {
        Object[] objArr2 = this.g;
        if (objArr2 == null) {
            this.g = objArr;
        } else {
            int length = objArr2.length;
            int length2 = objArr.length;
            Object[] objArr3 = new Object[length + length2];
            for (int i = 0; i < length; i++) {
                objArr3[i] = this.g[i];
            }
            for (int i2 = 0; i2 < length2; i2++) {
                objArr3[length + i2] = objArr[i2];
            }
            this.g = objArr3;
        }
        return this;
    }

    private boolean a(Hb hb, int i) {
        if (hb == null || i > 20) {
            return false;
        }
        if ((hb instanceof Sb) && ((Sb) hb).m()) {
            return true;
        }
        int i2 = hb.i();
        for (int i3 = 0; i3 < i2; i3++) {
            Object objB = hb.b(i3);
            if ((objB instanceof Hb) && a((Hb) objB, i + 1)) {
                return true;
            }
        }
        return false;
    }

    private a a(Yb yb, Hb hb, int i) {
        a aVarA;
        if (i > 50) {
            return null;
        }
        int i2 = yb.i();
        for (int i3 = 0; i3 < i2; i3++) {
            Object objB = yb.b(i3);
            if (objB == hb) {
                a aVar = new a();
                aVar.f21529a = yb;
                aVar.f21530b = yb.a(i3);
                return aVar;
            }
            if ((objB instanceof Yb) && (aVarA = a((Yb) objB, hb, i + 1)) != null) {
                return aVarA;
            }
        }
        return null;
    }

    private void a(StringBuffer stringBuffer, Object[] objArr) {
        Template templateL = this.h;
        if (templateL == null) {
            Hb hb = this.f21526d;
            templateL = hb != null ? hb.l() : null;
        }
        for (Object obj : objArr) {
            if (obj instanceof Object[]) {
                a(stringBuffer, (Object[]) obj);
            } else {
                String strB = b(obj);
                if (strB == null) {
                    strB = "null";
                }
                if (templateL != null) {
                    if (strB.length() > 4 && strB.charAt(0) == '<' && ((strB.charAt(1) == '#' || strB.charAt(1) == '@' || (strB.charAt(1) == '/' && (strB.charAt(2) == '#' || strB.charAt(2) == '@'))) && strB.charAt(strB.length() - 1) == '>')) {
                        if (templateL.d() == 2) {
                            stringBuffer.append('[');
                            stringBuffer.append(strB.substring(1, strB.length() - 1));
                            stringBuffer.append(']');
                        } else {
                            stringBuffer.append(strB);
                        }
                    } else {
                        stringBuffer.append(strB);
                    }
                } else {
                    stringBuffer.append(strB);
                }
            }
        }
    }

    public static String a(Object obj) {
        return a(obj, false);
    }

    private static String a(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Class) {
            return freemarker.template.utility.a.a((Class) obj);
        }
        if ((obj instanceof Method) || (obj instanceof Constructor)) {
            return freemarker.ext.beans.xa.d((Member) obj);
        }
        return z ? freemarker.template.utility.h.b(obj) : obj.toString();
    }

    public kc a(Hb hb) {
        this.f21526d = hb;
        return this;
    }

    public kc a(boolean z) {
        this.f21527e = z;
        return this;
    }

    public kc a(String str) {
        c(str);
        return this;
    }

    public kc a(Object[] objArr) {
        c(objArr);
        return this;
    }
}
