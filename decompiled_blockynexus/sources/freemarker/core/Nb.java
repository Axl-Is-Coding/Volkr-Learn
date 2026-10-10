package freemarker.core;

import com.sandboxol.common.utils.TextEllipsizeUtil;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Macro.java */
/* JADX INFO: loaded from: classes5.dex */
public final class Nb extends Xb implements freemarker.template.E {
    static final Nb k = new Nb(".pass", Collections.EMPTY_LIST, Collections.EMPTY_MAP, null, false, Zb.l);
    private final String l;
    private final String[] m;
    private final Map n;
    private final String o;
    private final boolean p;

    Nb(String str, List list, Map map, String str2, boolean z, Xb xb) {
        this.l = str;
        this.m = (String[]) list.toArray(new String[list.size()]);
        this.n = map;
        this.p = z;
        this.o = str2;
        a(xb);
    }

    @Override // freemarker.core.Xb
    protected String a(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (z) {
            stringBuffer.append('<');
        }
        stringBuffer.append(h());
        stringBuffer.append(' ');
        stringBuffer.append(cc.c(this.l));
        if (this.p) {
            stringBuffer.append('(');
        }
        int length = this.m.length;
        for (int i = 0; i < length; i++) {
            if (!this.p) {
                stringBuffer.append(' ');
            } else if (i != 0) {
                stringBuffer.append(", ");
            }
            String str = this.m[i];
            stringBuffer.append(cc.b(str));
            Map map = this.n;
            if (map != null && map.get(str) != null) {
                stringBuffer.append('=');
                Hb hb = (Hb) this.n.get(str);
                if (this.p) {
                    stringBuffer.append(hb.e());
                } else {
                    Ob.a(stringBuffer, hb);
                }
            }
        }
        if (this.o != null) {
            if (!this.p) {
                stringBuffer.append(' ');
            } else if (length != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.o);
            stringBuffer.append(TextEllipsizeUtil.SignLib.END_POINT);
        }
        if (this.p) {
            stringBuffer.append(')');
        }
        if (z) {
            stringBuffer.append('>');
            if (p() != null) {
                stringBuffer.append(p().e());
            }
            stringBuffer.append("</");
            stringBuffer.append(h());
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }

    @Override // freemarker.core.Yb
    Object b(int i) {
        if (i == 0) {
            return this.l;
        }
        String[] strArr = this.m;
        int length = (strArr.length * 2) + 1;
        if (i < length) {
            String str = strArr[(i - 1) / 2];
            return i % 2 != 0 ? str : this.n.get(str);
        }
        if (i == length) {
            return this.o;
        }
        if (i == length + 1) {
            return new Integer(this.p ? 1 : 0);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.Yb
    String h() {
        return this.p ? "#function" : "#macro";
    }

    @Override // freemarker.core.Yb
    int i() {
        return (this.m.length * 2) + 1 + 1 + 1;
    }

    @Override // freemarker.core.Xb
    boolean r() {
        return false;
    }

    public String s() {
        return this.l;
    }

    public boolean t() {
        return this.p;
    }

    @Override // freemarker.core.Yb
    Qb a(int i) {
        if (i == 0) {
            return Qb.g;
        }
        int length = (this.m.length * 2) + 1;
        if (i < length) {
            if (i % 2 != 0) {
                return Qb.y;
            }
            return Qb.z;
        }
        if (i == length) {
            return Qb.A;
        }
        if (i == length + 1) {
            return Qb.p;
        }
        throw new IndexOutOfBoundsException();
    }
}
