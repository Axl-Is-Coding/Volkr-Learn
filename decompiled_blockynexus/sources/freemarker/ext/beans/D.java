package freemarker.ext.beans;

import freemarker.core.hc;

/* JADX INFO: compiled from: EmptyMemberAndArguments.java */
/* JADX INFO: loaded from: classes5.dex */
final class D extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final D f21536a = new D("No compatible overloaded variation was found; wrong number of arguments.", true, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f21537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f21538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object[] f21539d;

    private D(Object obj, boolean z, Object[] objArr) {
        this.f21537b = obj;
        this.f21538c = z;
        this.f21539d = objArr;
    }

    static D a(int i) {
        return new D(new Object[]{"No compatible overloaded variation was found; can't convert (unwrap) the ", new hc(new Integer(i)), " argument to the desired Java type."}, false, null);
    }

    static D b(Object[] objArr) {
        return new D("No compatible overloaded variation was found; declared parameter types and argument value types mismatch.", false, objArr);
    }

    public boolean c() {
        return this.f21538c;
    }

    static D a(Object[] objArr) {
        return new D("Multiple compatible overloaded variations were found with the same priority.", false, objArr);
    }

    Object[] b() {
        return this.f21539d;
    }

    static O a(C c2, Object[] objArr) {
        if (c2 == C.f21534a) {
            return b(objArr);
        }
        if (c2 == C.f21535b) {
            return a(objArr);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized constant: ");
        stringBuffer.append(c2);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    Object a() {
        return this.f21537b;
    }
}
