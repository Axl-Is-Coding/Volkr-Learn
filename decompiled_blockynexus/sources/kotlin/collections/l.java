package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class l {
    public static <T> List<T> a(T t) {
        List<T> listSingletonList = Collections.singletonList(t);
        kotlin.jvm.internal.i.a((Object) listSingletonList, "java.util.Collections.singletonList(element)");
        return listSingletonList;
    }

    public static final <T> Object[] a(T[] tArr, boolean z) {
        kotlin.jvm.internal.i.b(tArr, "$this$copyToArrayOfAny");
        if (z && kotlin.jvm.internal.i.a(tArr.getClass(), Object[].class)) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
        kotlin.jvm.internal.i.a((Object) objArrCopyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return objArrCopyOf;
    }
}
