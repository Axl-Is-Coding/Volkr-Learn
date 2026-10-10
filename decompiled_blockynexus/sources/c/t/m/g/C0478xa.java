package c.t.m.g;

import c.t.m.g.cp;

/* JADX INFO: renamed from: c.t.m.g.xa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0478xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int[] f3443a = {0, 8, 10, 33, 65535, 50594049, 268435455, Integer.MAX_VALUE};

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        if (i2 < 0 || i3 < 0 || i4 < 0 || i5 <= 0 || i2 == 535 || i3 == 535 || i4 == 65535 || i5 == 65535) {
            return false;
        }
        int i6 = cp.a.f3115a;
        if (!(i == 2)) {
            if (i4 != 25840) {
                int[] iArr = f3443a;
                int i7 = 0;
                while (true) {
                    if (i7 >= iArr.length) {
                        z = false;
                        break;
                    }
                    if (i5 == iArr[i7]) {
                        z = true;
                        break;
                    }
                    i7++;
                }
                if (z) {
                }
            }
            return false;
        }
        return true;
    }
}
