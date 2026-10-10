package kotlin.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Ranges.kt */
/* JADX INFO: loaded from: classes5.dex */
public class h extends g {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static int b(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static b c(int i, int i2) {
        return b.f22830a.a(i, i2, -1);
    }

    public static d d(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? d.f22839f.a() : new d(i, i2 - 1);
    }
}
