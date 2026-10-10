package androidx.recyclerview.widget;

import androidx.recyclerview.widget.r;
import java.util.Comparator;

/* JADX INFO: renamed from: androidx.recyclerview.widget.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
class C0367q implements Comparator<r.b> {
    C0367q() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(r.b bVar, r.b bVar2) {
        if ((bVar.f2035d == null) != (bVar2.f2035d == null)) {
            return bVar.f2035d == null ? 1 : -1;
        }
        boolean z = bVar.f2032a;
        if (z != bVar2.f2032a) {
            return z ? -1 : 1;
        }
        int i = bVar2.f2033b - bVar.f2033b;
        if (i != 0) {
            return i;
        }
        int i2 = bVar.f2034c - bVar2.f2034c;
        if (i2 != 0) {
            return i2;
        }
        return 0;
    }
}
