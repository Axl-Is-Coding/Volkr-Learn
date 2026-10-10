package freemarker.core;

/* JADX INFO: renamed from: freemarker.core.xb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CustomAttribute.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2848xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f21531a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21532b;

    public C2848xb(int i) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
        this.f21532b = i;
    }

    private Configurable a(Environment environment) throws Error {
        int i = this.f21532b;
        if (i == 0) {
            return environment;
        }
        if (i == 1) {
            return environment.b();
        }
        if (i == 2) {
            return environment.b().b();
        }
        throw new BugException();
    }

    private Environment c() {
        Environment environmentD = Environment.d();
        if (environmentD != null) {
            return environmentD;
        }
        throw new IllegalStateException("No current environment");
    }

    protected Object a() {
        return null;
    }

    public final Object b() {
        return a(c()).a(this.f21531a, this);
    }
}
