package freemarker.ext.beans;

import freemarker.template.InterfaceC2891l;
import freemarker.template.Version;

/* JADX INFO: renamed from: freemarker.ext.beans.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeansWrapperConfiguration.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2868n implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Version f21614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected C2875v f21615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f21616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f21617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterfaceC2891l f21618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f21619f;
    private boolean g;

    protected AbstractC2868n(Version version, boolean z) {
        this.f21616c = false;
        this.f21617d = 0;
        this.f21618e = null;
        this.f21619f = false;
        this.g = false;
        freemarker.template.N.a(version);
        version = z ? version : C2867m.b(version);
        this.f21614a = version;
        this.f21615b = new C2875v(version);
    }

    protected Object a(boolean z) {
        try {
            AbstractC2868n abstractC2868n = (AbstractC2868n) super.clone();
            if (z) {
                abstractC2868n.f21615b = (C2875v) this.f21615b.clone();
            }
            return abstractC2868n;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException("Failed to clone BeansWrapperConfiguration", e2);
        }
    }

    public int b() {
        return this.f21617d;
    }

    public Version c() {
        return this.f21614a;
    }

    public Q d() {
        return this.f21615b.d();
    }

    public InterfaceC2891l e() {
        return this.f21618e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC2868n abstractC2868n = (AbstractC2868n) obj;
        return this.f21614a.equals(abstractC2868n.f21614a) && this.f21616c == abstractC2868n.f21616c && this.f21617d == abstractC2868n.f21617d && this.f21618e == abstractC2868n.f21618e && this.f21619f == abstractC2868n.f21619f && this.g == abstractC2868n.g && this.f21615b.equals(abstractC2868n.f21615b);
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.f21616c;
    }

    public boolean h() {
        return this.f21619f;
    }

    public int hashCode() {
        int iHashCode = (((((this.f21614a.hashCode() + 31) * 31) + (this.f21616c ? 1231 : 1237)) * 31) + this.f21617d) * 31;
        InterfaceC2891l interfaceC2891l = this.f21618e;
        return ((((((iHashCode + (interfaceC2891l != null ? interfaceC2891l.hashCode() : 0)) * 31) + (this.f21619f ? 1231 : 1237)) * 31) + (this.g ? 1231 : 1237)) * 31) + this.f21615b.hashCode();
    }

    public void a(Q q) {
        this.f21615b.a(q);
    }

    protected AbstractC2868n(Version version) {
        this(version, false);
    }
}
