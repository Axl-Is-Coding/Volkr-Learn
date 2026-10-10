package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ClassesInfoCache.a f1593b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f1592a = obj;
        this.f1593b = ClassesInfoCache.f1566a.a(this.f1592a.getClass());
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, Lifecycle.Event event) {
        this.f1593b.a(gVar, event, this.f1592a);
    }
}
