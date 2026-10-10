package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes5.dex */
public class i extends h {
    public static final <T> boolean a(T[] tArr, T t) {
        kotlin.jvm.internal.i.b(tArr, "$this$contains");
        return b(tArr, t) >= 0;
    }

    public static final <T> int b(T[] tArr, T t) {
        kotlin.jvm.internal.i.b(tArr, "$this$indexOf");
        int i = 0;
        if (t == null) {
            int length = tArr.length;
            while (i < length) {
                if (tArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i < length2) {
            if (kotlin.jvm.internal.i.a(t, tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final int c(byte[] bArr, byte b2) {
        kotlin.jvm.internal.i.b(bArr, "$this$lastIndexOf");
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (b2 == bArr[length]) {
                return length;
            }
        }
        return -1;
    }

    public static final <T> Set<T> d(T[] tArr) {
        kotlin.jvm.internal.i.b(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return E.a();
        }
        if (length == 1) {
            return D.a(tArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(A.a(tArr.length));
        a((Object[]) tArr, linkedHashSet);
        return linkedHashSet;
    }

    public static final boolean a(byte[] bArr, byte b2) {
        kotlin.jvm.internal.i.b(bArr, "$this$contains");
        return b(bArr, b2) >= 0;
    }

    public static char a(char[] cArr) {
        kotlin.jvm.internal.i.b(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static <T> List<T> c(T[] tArr) {
        kotlin.jvm.internal.i.b(tArr, "$this$toMutableList");
        return new ArrayList(m.a((Object[]) tArr));
    }

    public static final int b(byte[] bArr, byte b2) {
        kotlin.jvm.internal.i.b(bArr, "$this$indexOf");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b2 == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static List<Byte> a(byte[] bArr, kotlin.d.d dVar) {
        kotlin.jvm.internal.i.b(bArr, "$this$slice");
        kotlin.jvm.internal.i.b(dVar, "indices");
        return dVar.isEmpty() ? m.a() : h.a(h.a(bArr, dVar.f().intValue(), dVar.e().intValue() + 1));
    }

    public static <T> T b(T[] tArr) {
        kotlin.jvm.internal.i.b(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c2) {
        kotlin.jvm.internal.i.b(tArr, "$this$toCollection");
        kotlin.jvm.internal.i.b(c2, "destination");
        for (T t : tArr) {
            c2.add(t);
        }
        return c2;
    }
}
