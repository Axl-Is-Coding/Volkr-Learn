package f.a.a.b;

import org.aspectj.lang.a;

/* JADX INFO: compiled from: JoinPointImpl.java */
/* JADX INFO: loaded from: classes5.dex */
class c implements org.aspectj.lang.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f21451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f21452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f21453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    a.InterfaceC0253a f21454d;

    /* JADX INFO: compiled from: JoinPointImpl.java */
    static class a implements a.InterfaceC0253a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f21455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        org.aspectj.lang.c f21456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        org.aspectj.lang.reflect.d f21457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f21458d;

        public a(int i, String str, org.aspectj.lang.c cVar, org.aspectj.lang.reflect.d dVar) {
            this.f21455a = str;
            this.f21456b = cVar;
            this.f21457c = dVar;
            this.f21458d = i;
        }

        public String a() {
            return this.f21455a;
        }

        public org.aspectj.lang.c b() {
            return this.f21456b;
        }

        @Override // org.aspectj.lang.a.InterfaceC0253a
        public final String toString() {
            return a(h.f21470b);
        }

        String a(h hVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(hVar.a(a()));
            stringBuffer.append("(");
            stringBuffer.append(((f) b()).b(hVar));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
    }

    public c(a.InterfaceC0253a interfaceC0253a, Object obj, Object obj2, Object[] objArr) {
        this.f21454d = interfaceC0253a;
        this.f21451a = obj;
        this.f21452b = obj2;
        this.f21453c = objArr;
    }

    @Override // org.aspectj.lang.a
    public Object getTarget() {
        return this.f21452b;
    }

    public final String toString() {
        return this.f21454d.toString();
    }
}
