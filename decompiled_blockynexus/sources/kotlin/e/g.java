package kotlin.e;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g<T> implements Iterable<T>, kotlin.jvm.internal.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f22840a;

    public g(a aVar) {
        this.f22840a = aVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.f22840a.iterator();
    }
}
