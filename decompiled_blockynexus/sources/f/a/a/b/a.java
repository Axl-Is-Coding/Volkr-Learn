package f.a.a.b;

/* JADX INFO: compiled from: CodeSignatureImpl.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class a extends d implements org.aspectj.lang.reflect.a {
    Class[] k;
    String[] l;
    Class[] m;

    a(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.k = clsArr;
        this.l = strArr;
        this.m = clsArr2;
    }

    public Class[] e() {
        if (this.m == null) {
            this.m = d(5);
        }
        return this.m;
    }

    public Class[] f() {
        if (this.k == null) {
            this.k = d(3);
        }
        return this.k;
    }
}
