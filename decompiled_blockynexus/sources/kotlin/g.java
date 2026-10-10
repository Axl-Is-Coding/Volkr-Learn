package kotlin;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
public class g {
    public static <T> e<T> a(kotlin.jvm.a.a<? extends T> aVar) {
        kotlin.jvm.internal.i.b(aVar, "initializer");
        kotlin.jvm.internal.f fVar = null;
        return new SynchronizedLazyImpl(aVar, fVar, 2, fVar);
    }
}
