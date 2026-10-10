package kotlin.e;

import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j<T, R> implements a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<T> f22843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.jvm.a.b<T, R> f22844b;

    /* JADX WARN: Multi-variable type inference failed */
    public j(a<? extends T> aVar, kotlin.jvm.a.b<? super T, ? extends R> bVar) {
        kotlin.jvm.internal.i.b(aVar, "sequence");
        kotlin.jvm.internal.i.b(bVar, "transformer");
        this.f22843a = aVar;
        this.f22844b = bVar;
    }

    @Override // kotlin.e.a
    public Iterator<R> iterator() {
        return new i(this);
    }
}
