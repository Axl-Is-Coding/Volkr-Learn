package kotlin.coroutines.intrinsics;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: IntrinsicsJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> kotlin.b.a<T> a(kotlin.b.a<? super T> aVar) {
        kotlin.b.a<T> aVar2;
        i.b(aVar, "$this$intercepted");
        ContinuationImpl continuationImpl = (ContinuationImpl) (!(aVar instanceof ContinuationImpl) ? null : aVar);
        return (continuationImpl == null || (aVar2 = (kotlin.b.a<T>) continuationImpl.intercepted()) == null) ? aVar : aVar2;
    }
}
