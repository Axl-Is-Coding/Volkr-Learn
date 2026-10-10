package freemarker.core;

import java.util.List;

/* JADX INFO: renamed from: freemarker.core.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BuiltInWithParseTimeParameters.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractC2805j extends Rb {
    AbstractC2805j() {
    }

    @Override // freemarker.core.AbstractC2781b, freemarker.core.Yb
    Qb a(int i) {
        int i2 = super.i();
        if (i < i2) {
            return super.a(i);
        }
        if (i - i2 < n()) {
            return Qb.C;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.AbstractC2781b, freemarker.core.Yb
    Object b(int i) {
        int i2 = super.i();
        return i < i2 ? super.b(i) : c(i - i2);
    }

    protected abstract Hb c(int i);

    @Override // freemarker.core.AbstractC2781b, freemarker.core.Yb
    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.e());
        stringBuffer.append("(");
        List listM = m();
        int size = listM.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(((Hb) listM.get(i)).e());
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    @Override // freemarker.core.AbstractC2781b, freemarker.core.Yb
    String h() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.h());
        stringBuffer.append("(...)");
        return stringBuffer.toString();
    }

    @Override // freemarker.core.AbstractC2781b, freemarker.core.Yb
    int i() {
        return super.i() + n();
    }

    protected abstract List m();

    protected abstract int n();
}
