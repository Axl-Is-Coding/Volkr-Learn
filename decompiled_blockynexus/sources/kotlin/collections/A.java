package kotlin.collections;

/* JADX INFO: compiled from: Maps.kt */
/* JADX INFO: loaded from: classes5.dex */
class A extends z {
    public static final int a(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return i + (i / 3);
        }
        return Integer.MAX_VALUE;
    }
}
