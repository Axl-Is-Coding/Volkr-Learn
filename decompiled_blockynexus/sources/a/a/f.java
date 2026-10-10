package a.a;

/* JADX INFO: compiled from: LongSparseArray.java */
/* JADX INFO: loaded from: classes.dex */
public class f<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f139a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f143e;

    public f() {
        this(10);
    }

    @Deprecated
    public void a(long j) {
        d(j);
    }

    public E b(long j) {
        return b(j, null);
    }

    public void c(long j, E e2) {
        int iA = e.a(this.f141c, this.f143e, j);
        if (iA >= 0) {
            this.f142d[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.f143e) {
            Object[] objArr = this.f142d;
            if (objArr[iA2] == f139a) {
                this.f141c[iA2] = j;
                objArr[iA2] = e2;
                return;
            }
        }
        if (this.f140b && this.f143e >= this.f141c.length) {
            d();
            iA2 = e.a(this.f141c, this.f143e, j) ^ (-1);
        }
        int i = this.f143e;
        if (i >= this.f141c.length) {
            int iC = e.c(i + 1);
            long[] jArr = new long[iC];
            Object[] objArr2 = new Object[iC];
            long[] jArr2 = this.f141c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f142d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f141c = jArr;
            this.f142d = objArr2;
        }
        int i2 = this.f143e;
        if (i2 - iA2 != 0) {
            long[] jArr3 = this.f141c;
            int i3 = iA2 + 1;
            System.arraycopy(jArr3, iA2, jArr3, i3, i2 - iA2);
            Object[] objArr4 = this.f142d;
            System.arraycopy(objArr4, iA2, objArr4, i3, this.f143e - iA2);
        }
        this.f141c[iA2] = j;
        this.f142d[iA2] = e2;
        this.f143e++;
    }

    public void d(long j) {
        int iA = e.a(this.f141c, this.f143e, j);
        if (iA >= 0) {
            Object[] objArr = this.f142d;
            Object obj = objArr[iA];
            Object obj2 = f139a;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f140b = true;
            }
        }
    }

    public String toString() {
        if (c() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f143e * 28);
        sb.append('{');
        for (int i = 0; i < this.f143e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E eC = c(i);
            if (eC != this) {
                sb.append(eC);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public f(int i) {
        this.f140b = false;
        if (i == 0) {
            this.f141c = e.f137b;
            this.f142d = e.f138c;
        } else {
            int iC = e.c(i);
            this.f141c = new long[iC];
            this.f142d = new Object[iC];
        }
    }

    public long a(int i) {
        if (this.f140b) {
            d();
        }
        return this.f141c[i];
    }

    public E b(long j, E e2) {
        int iA = e.a(this.f141c, this.f143e, j);
        if (iA >= 0) {
            Object[] objArr = this.f142d;
            if (objArr[iA] != f139a) {
                return (E) objArr[iA];
            }
        }
        return e2;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public f<E> m0clone() {
        try {
            f<E> fVar = (f) super.clone();
            fVar.f141c = (long[]) this.f141c.clone();
            fVar.f142d = (Object[]) this.f142d.clone();
            return fVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    private void d() {
        int i = this.f143e;
        long[] jArr = this.f141c;
        Object[] objArr = this.f142d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f139a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f140b = false;
        this.f143e = i2;
    }

    public void a(long j, E e2) {
        int i = this.f143e;
        if (i != 0 && j <= this.f141c[i - 1]) {
            c(j, e2);
            return;
        }
        if (this.f140b && this.f143e >= this.f141c.length) {
            d();
        }
        int i2 = this.f143e;
        if (i2 >= this.f141c.length) {
            int iC = e.c(i2 + 1);
            long[] jArr = new long[iC];
            Object[] objArr = new Object[iC];
            long[] jArr2 = this.f141c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f142d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f141c = jArr;
            this.f142d = objArr;
        }
        this.f141c[i2] = j;
        this.f142d[i2] = e2;
        this.f143e = i2 + 1;
    }

    public void b(int i) {
        Object[] objArr = this.f142d;
        Object obj = objArr[i];
        Object obj2 = f139a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f140b = true;
        }
    }

    public void b() {
        int i = this.f143e;
        Object[] objArr = this.f142d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f143e = 0;
        this.f140b = false;
    }

    public int c() {
        if (this.f140b) {
            d();
        }
        return this.f143e;
    }

    public E c(int i) {
        if (this.f140b) {
            d();
        }
        return (E) this.f142d[i];
    }

    public int c(long j) {
        if (this.f140b) {
            d();
        }
        return e.a(this.f141c, this.f143e, j);
    }
}
