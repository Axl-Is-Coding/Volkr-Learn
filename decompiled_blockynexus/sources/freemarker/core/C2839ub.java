package freemarker.core;

import java.util.List;

/* JADX INFO: renamed from: freemarker.core.ub, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BuiltInsWithParseTimeParameters.java */
/* JADX INFO: loaded from: classes5.dex */
class C2839ub extends AbstractC2805j {
    private List i;

    C2839ub() {
    }

    @Override // freemarker.core.AbstractC2805j
    protected Hb c(int i) {
        return (Hb) this.i.get(i);
    }

    @Override // freemarker.core.AbstractC2805j
    protected List m() {
        return this.i;
    }

    @Override // freemarker.core.AbstractC2805j
    protected int n() {
        return this.i.size();
    }
}
