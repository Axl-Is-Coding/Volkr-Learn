package freemarker.core;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: freemarker.core.vb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BuiltInsWithParseTimeParameters.java */
/* JADX INFO: loaded from: classes5.dex */
class C2842vb extends AbstractC2805j {
    private Hb i;
    private Hb j;

    C2842vb() {
    }

    @Override // freemarker.core.AbstractC2805j
    protected Hb c(int i) {
        if (i == 0) {
            return this.i;
        }
        if (i == 1) {
            return this.j;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // freemarker.core.AbstractC2805j
    protected List m() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.i);
        arrayList.add(this.j);
        return arrayList;
    }

    @Override // freemarker.core.AbstractC2805j
    protected int n() {
        return 2;
    }
}
