package kotlin.jvm.internal;

/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f22849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22850b;

    public j(Class<?> cls, String str) {
        i.b(cls, "jClass");
        i.b(str, "moduleName");
        this.f22849a = cls;
        this.f22850b = str;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.f22849a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && i.a(a(), ((j) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
