package freemarker.core;

/* JADX INFO: compiled from: Interpolation.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class Lb extends Xb {
    Lb() {
    }

    @Override // freemarker.core.Xb
    protected final String a(boolean z) {
        return a(z, false);
    }

    protected abstract String a(boolean z, boolean z2);

    final String s() {
        return a(true, true);
    }
}
