package freemarker.core;

/* JADX INFO: compiled from: ParameterRole.java */
/* JADX INFO: loaded from: classes5.dex */
final class Qb {
    private final String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Qb f21488a = new Qb("[unknown role]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Qb f21489b = new Qb("left-hand operand");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Qb f21490c = new Qb("right-hand operand");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Qb f21491d = new Qb("enclosed operand");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Qb f21492e = new Qb("item value");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Qb f21493f = new Qb("item key");
    static final Qb g = new Qb("assignment target");
    static final Qb h = new Qb("assignment operator");
    static final Qb i = new Qb("assignment source");
    static final Qb j = new Qb("variable scope");
    static final Qb k = new Qb("namespace");
    static final Qb l = new Qb("error handler");
    static final Qb m = new Qb("passed value");
    static final Qb n = new Qb("condition");
    static final Qb o = new Qb("value");
    static final Qb p = new Qb("AST-node subtype");
    static final Qb q = new Qb("placeholder variable");
    static final Qb r = new Qb("expression template");
    static final Qb s = new Qb("list source");
    static final Qb t = new Qb("target loop variable");
    static final Qb u = new Qb("template name");
    static final Qb v = new Qb("\"parse\" parameter");
    static final Qb w = new Qb("\"encoding\" parameter");
    static final Qb x = new Qb("\"ignore_missing\" parameter");
    static final Qb y = new Qb("parameter name");
    static final Qb z = new Qb("parameter default");
    static final Qb A = new Qb("catch-all parameter name");
    static final Qb B = new Qb("argument name");
    static final Qb C = new Qb("argument value");
    static final Qb D = new Qb("content");
    static final Qb E = new Qb("embedded template");
    static final Qb F = new Qb("minimum decimals");
    static final Qb G = new Qb("maximum decimals");
    static final Qb H = new Qb("node");
    static final Qb I = new Qb("callee");
    static final Qb J = new Qb("message");

    private Qb(String str) {
        this.K = str;
    }

    static Qb a(int i2) {
        if (i2 == 0) {
            return f21489b;
        }
        if (i2 == 1) {
            return f21490c;
        }
        throw new IndexOutOfBoundsException();
    }

    public String toString() {
        return this.K;
    }
}
