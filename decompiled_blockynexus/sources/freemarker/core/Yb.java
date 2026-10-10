package freemarker.core;

import freemarker.template.Template;

/* JADX INFO: compiled from: TemplateObject.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Yb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Template f21499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f21500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f21501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f21502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f21503e;

    abstract Qb a(int i);

    abstract Object b(int i);

    public final int c() {
        return this.f21500b;
    }

    public final int d() {
        return this.f21501c;
    }

    public abstract String e();

    public final int f() {
        return this.f21502d;
    }

    public final int g() {
        return this.f21503e;
    }

    abstract String h();

    abstract int i();

    public final String j() {
        Template template = this.f21499a;
        String strA = template != null ? template.a(this.f21500b, this.f21501c, this.f21502d, this.f21503e) : null;
        return strA != null ? strA : e();
    }

    public String k() {
        return Ob.a(this.f21499a, this.f21501c, this.f21500b);
    }

    public Template l() {
        return this.f21499a;
    }

    public String toString() {
        String strJ;
        try {
            strJ = j();
        } catch (Exception unused) {
            strJ = null;
        }
        return strJ != null ? strJ : e();
    }
}
