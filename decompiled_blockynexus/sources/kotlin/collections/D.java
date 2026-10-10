package kotlin.collections;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
class D {
    public static final <T> Set<T> a(T t) {
        Set<T> setSingleton = Collections.singleton(t);
        kotlin.jvm.internal.i.a((Object) setSingleton, "java.util.Collections.singleton(element)");
        return setSingleton;
    }
}
