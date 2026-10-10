package freemarker.core;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: renamed from: freemarker.core.yb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Dot.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2851yb extends Hb {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Hb f21533f;
    private final String g;

    @Override // freemarker.core.Yb
    Qb a(int i) {
        return Qb.a(i);
    }

    @Override // freemarker.core.Yb
    Object b(int i) {
        return i == 0 ? this.f21533f : this.g;
    }

    @Override // freemarker.core.Yb
    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f21533f.e());
        stringBuffer.append(h());
        stringBuffer.append(cc.a(this.g));
        return stringBuffer.toString();
    }

    @Override // freemarker.core.Yb
    String h() {
        return Consts.DOT;
    }

    @Override // freemarker.core.Yb
    int i() {
        return 2;
    }

    String m() {
        return this.g;
    }
}
