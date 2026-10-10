package f.a.a.b;

/* JADX INFO: compiled from: SourceLocationImpl.java */
/* JADX INFO: loaded from: classes5.dex */
class g implements org.aspectj.lang.reflect.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Class f21466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f21467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f21468c;

    g(Class cls, String str, int i) {
        this.f21466a = cls;
        this.f21467b = str;
        this.f21468c = i;
    }

    public String a() {
        return this.f21467b;
    }

    public int b() {
        return this.f21468c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(":");
        stringBuffer.append(b());
        return stringBuffer.toString();
    }
}
