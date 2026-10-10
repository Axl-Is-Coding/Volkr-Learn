package kotlin.collections;

import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class q extends p {
    public static <T extends Comparable<? super T>> void c(List<T> list) {
        kotlin.jvm.internal.i.b(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
