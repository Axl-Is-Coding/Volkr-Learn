package freemarker.core;

/* JADX INFO: compiled from: TextBlock.java */
/* JADX INFO: loaded from: classes5.dex */
public final class Zb extends Xb {
    private static final char[] k = new char[0];
    static final Zb l = new Zb(k, false);
    private char[] m;
    private final boolean n;

    private Zb(char[] cArr, boolean z) {
        this.m = cArr;
        this.n = z;
    }

    @Override // freemarker.core.Xb
    protected String a(boolean z) {
        if (!z) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("text ");
            stringBuffer.append(freemarker.template.utility.h.e(new String(this.m)));
            return stringBuffer.toString();
        }
        String str = new String(this.m);
        if (!this.n) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<#noparse>");
        stringBuffer2.append(str);
        stringBuffer2.append("</#noparse>");
        return stringBuffer2.toString();
    }

    @Override // freemarker.core.Yb
    Object b(int i) {
        if (i == 0) {
            return new String(this.m);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.Yb
    String h() {
        return "#text";
    }

    @Override // freemarker.core.Yb
    int i() {
        return 1;
    }

    @Override // freemarker.core.Yb
    Qb a(int i) {
        if (i == 0) {
            return Qb.D;
        }
        throw new IndexOutOfBoundsException();
    }
}
