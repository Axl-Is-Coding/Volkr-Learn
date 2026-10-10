package kotlin.jvm.internal;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d implements kotlin.reflect.c<Object>, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f22847a;

    public d(Class<?> cls) {
        i.b(cls, "jClass");
        this.f22847a = cls;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.f22847a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof d) && i.a(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
