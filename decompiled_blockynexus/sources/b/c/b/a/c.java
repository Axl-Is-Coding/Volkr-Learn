package b.c.b.a;

/* JADX INFO: compiled from: MathPreconditions.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    static int a(String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    static void a(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
