package kotlin.collections;

/* JADX INFO: renamed from: kotlin.collections.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
class C2934e {
    public static final void a(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
