package f.a.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: SignatureImpl.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f21459a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String[] f21460b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static Class[] f21461c = new Class[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f21462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f21463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f21464f;
    Class g;
    a h;
    private String i;
    ClassLoader j = null;

    /* JADX INFO: compiled from: SignatureImpl.java */
    private interface a {
        void a(int i, String str);

        String get(int i);
    }

    f(int i, String str, Class cls) {
        this.f21462d = -1;
        this.f21462d = i;
        this.f21463e = str;
        this.g = cls;
    }

    private ClassLoader e() {
        if (this.j == null) {
            this.j = getClass().getClassLoader();
        }
        return this.j;
    }

    public Class a() {
        if (this.g == null) {
            this.g = c(2);
        }
        return this.g;
    }

    protected abstract String a(h hVar);

    String b(h hVar) {
        String strA;
        if (f21459a) {
            a aVar = this.h;
            if (aVar == null) {
                try {
                    this.h = new b();
                } catch (Throwable unused) {
                    f21459a = false;
                }
                strA = null;
            } else {
                strA = aVar.get(hVar.l);
            }
        } else {
            strA = null;
        }
        if (strA == null) {
            strA = a(hVar);
        }
        if (f21459a) {
            this.h.a(hVar.l, strA);
        }
        return strA;
    }

    public int c() {
        if (this.f21462d == -1) {
            this.f21462d = a(0);
        }
        return this.f21462d;
    }

    public String d() {
        if (this.f21463e == null) {
            this.f21463e = b(1);
        }
        return this.f21463e;
    }

    public final String toString() {
        return b(h.f21470b);
    }

    /* JADX INFO: compiled from: SignatureImpl.java */
    private static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SoftReference f21465a;

        public b() {
            b();
        }

        private String[] b() {
            String[] strArr = new String[3];
            this.f21465a = new SoftReference(strArr);
            return strArr;
        }

        @Override // f.a.a.b.f.a
        public void a(int i, String str) {
            String[] strArrA = a();
            if (strArrA == null) {
                strArrA = b();
            }
            strArrA[i] = str;
        }

        @Override // f.a.a.b.f.a
        public String get(int i) {
            String[] strArrA = a();
            if (strArrA == null) {
                return null;
            }
            return strArrA[i];
        }

        private String[] a() {
            return (String[]) this.f21465a.get();
        }
    }

    int a(int i) {
        return Integer.parseInt(b(i), 16);
    }

    Class c(int i) {
        return f.a.a.b.b.a(b(i), e());
    }

    Class[] d(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(b(i), ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            clsArr[i2] = f.a.a.b.b.a(stringTokenizer.nextToken(), e());
        }
        return clsArr;
    }

    public String b() {
        if (this.f21464f == null) {
            this.f21464f = a().getName();
        }
        return this.f21464f;
    }

    String b(int i) {
        int iIndexOf = this.i.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = iIndexOf + 1;
            iIndexOf = this.i.indexOf(45, i2);
            i = i3;
        }
        if (iIndexOf == -1) {
            iIndexOf = this.i.length();
        }
        return this.i.substring(i2, iIndexOf);
    }
}
