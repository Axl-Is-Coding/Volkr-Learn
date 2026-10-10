package kotlin.collections;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes5.dex */
public class n extends m {
    public static <T> int a(Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.i.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
