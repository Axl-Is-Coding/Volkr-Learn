package freemarker.core;

import java.util.Enumeration;

/* JADX INFO: compiled from: StringLiteral.java */
/* JADX INFO: loaded from: classes5.dex */
final class Sb extends Hb implements freemarker.template.K {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f21494f;
    private Xb g;

    @Override // freemarker.core.Yb
    Qb a(int i) {
        if (i == 0) {
            return Qb.E;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.Yb
    Object b(int i) {
        if (i == 0) {
            return this.g;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.Yb
    public String e() {
        if (this.g == null) {
            return freemarker.template.utility.h.c(this.f21494f);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('\"');
        Enumeration enumerationM = this.g.m();
        while (enumerationM.hasMoreElements()) {
            Xb xb = (Xb) enumerationM.nextElement();
            if (xb instanceof Lb) {
                stringBuffer.append(((Lb) xb).s());
            } else {
                stringBuffer.append(freemarker.template.utility.h.a(xb.e(), '\"'));
            }
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    @Override // freemarker.template.K
    public String getAsString() {
        return this.f21494f;
    }

    @Override // freemarker.core.Yb
    String h() {
        return this.g == null ? e() : "dynamic \"...\"";
    }

    @Override // freemarker.core.Yb
    int i() {
        return 1;
    }

    boolean m() {
        Xb xb = this.g;
        if (xb != null && xb.n() == 1) {
            this.g.c(0);
        }
        return false;
    }
}
