package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
public class m extends l {
    public static final <T> Collection<T> a(T[] tArr) {
        kotlin.jvm.internal.i.b(tArr, "$this$asCollection");
        return new C2932c(tArr, false);
    }

    public static <T> List<T> b(T... tArr) {
        kotlin.jvm.internal.i.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length > 0 ? h.a(tArr) : a();
    }

    public static <T> List<T> c(T... tArr) {
        kotlin.jvm.internal.i.b(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C2932c(tArr, true));
    }

    public static <T> List<T> a() {
        return EmptyList.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> b(List<? extends T> list) {
        kotlin.jvm.internal.i.b(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : l.a(list.get(0)) : a();
    }

    public static final <T> int a(List<? extends T> list) {
        kotlin.jvm.internal.i.b(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static /* synthetic */ int a(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return a(list, comparable, i, i2);
    }

    public static final <T extends Comparable<? super T>> int a(List<? extends T> list, T t, int i, int i2) {
        kotlin.jvm.internal.i.b(list, "$this$binarySearch");
        a(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int iA = kotlin.a.b.a(list.get(i4), t);
            if (iA < 0) {
                i = i4 + 1;
            } else {
                if (iA <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static void b() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    private static final void a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }
}
