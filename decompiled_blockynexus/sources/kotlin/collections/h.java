package kotlin.collections;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public class h extends C2935f {
    public static <T> List<T> a(T[] tArr) {
        kotlin.jvm.internal.i.b(tArr, "$this$asList");
        List<T> listA = j.a(tArr);
        kotlin.jvm.internal.i.a((Object) listA, "ArraysUtilJVM.asList(this)");
        return listA;
    }

    public static final List<Byte> a(byte[] bArr) {
        kotlin.jvm.internal.i.b(bArr, "$this$asList");
        return new g(bArr);
    }

    public static /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        C2933d.a(bArr, bArr2, i, i2, i3);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        kotlin.jvm.internal.i.b(bArr, "$this$copyInto");
        kotlin.jvm.internal.i.b(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static <T> T[] a(T[] tArr, int i, int i2) {
        kotlin.jvm.internal.i.b(tArr, "$this$copyOfRangeImpl");
        C2934e.a(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        kotlin.jvm.internal.i.a((Object) tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        kotlin.jvm.internal.i.b(bArr, "$this$copyOfRangeImpl");
        C2934e.a(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        kotlin.jvm.internal.i.a((Object) bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }
}
