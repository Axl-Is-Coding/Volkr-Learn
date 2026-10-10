package a.a;

/* JADX INFO: compiled from: SparseArrayCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f165a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f169e;

    public j() {
        this(10);
    }

    public E a(int i) {
        return b(i, null);
    }

    public E b(int i, E e2) {
        int iA = e.a(this.f167c, this.f169e, i);
        if (iA >= 0) {
            Object[] objArr = this.f168d;
            if (objArr[iA] != f165a) {
                return (E) objArr[iA];
            }
        }
        return e2;
    }

    public void c(int i, E e2) {
        int iA = e.a(this.f167c, this.f169e, i);
        if (iA >= 0) {
            this.f168d[iA] = e2;
            return;
        }
        int iA2 = iA ^ (-1);
        if (iA2 < this.f169e) {
            Object[] objArr = this.f168d;
            if (objArr[iA2] == f165a) {
                this.f167c[iA2] = i;
                objArr[iA2] = e2;
                return;
            }
        }
        if (this.f166b && this.f169e >= this.f167c.length) {
            d();
            iA2 = e.a(this.f167c, this.f169e, i) ^ (-1);
        }
        int i2 = this.f169e;
        if (i2 >= this.f167c.length) {
            int iB = e.b(i2 + 1);
            int[] iArr = new int[iB];
            Object[] objArr2 = new Object[iB];
            int[] iArr2 = this.f167c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f168d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f167c = iArr;
            this.f168d = objArr2;
        }
        int i3 = this.f169e;
        if (i3 - iA2 != 0) {
            int[] iArr3 = this.f167c;
            int i4 = iA2 + 1;
            System.arraycopy(iArr3, iA2, iArr3, i4, i3 - iA2);
            Object[] objArr4 = this.f168d;
            System.arraycopy(objArr4, iA2, objArr4, i4, this.f169e - iA2);
        }
        this.f167c[iA2] = i;
        this.f168d[iA2] = e2;
        this.f169e++;
    }

    public void d(int i) {
        int iA = e.a(this.f167c, this.f169e, i);
        if (iA >= 0) {
            Object[] objArr = this.f168d;
            Object obj = objArr[iA];
            Object obj2 = f165a;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f166b = true;
            }
        }
    }

    public E e(int i) {
        if (this.f166b) {
            d();
        }
        return (E) this.f168d[i];
    }

    public String toString() {
        if (c() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f169e * 28);
        sb.append('{');
        for (int i = 0; i < this.f169e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c(i));
            sb.append('=');
            E e2 = e(i);
            if (e2 != this) {
                sb.append(e2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public j(int i) {
        this.f166b = false;
        if (i == 0) {
            this.f167c = e.f136a;
            this.f168d = e.f138c;
        } else {
            int iB = e.b(i);
            this.f167c = new int[iB];
            this.f168d = new Object[iB];
        }
    }

    public int a(E e2) {
        if (this.f166b) {
            d();
        }
        for (int i = 0; i < this.f169e; i++) {
            if (this.f168d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public j<E> m1clone() {
        try {
            j<E> jVar = (j) super.clone();
            jVar.f167c = (int[]) this.f167c.clone();
            jVar.f168d = (Object[]) this.f168d.clone();
            return jVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public int b(int i) {
        if (this.f166b) {
            d();
        }
        return e.a(this.f167c, this.f169e, i);
    }

    private void d() {
        int i = this.f169e;
        int[] iArr = this.f167c;
        Object[] objArr = this.f168d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f165a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f166b = false;
        this.f169e = i2;
    }

    public void a(int i, E e2) {
        int i2 = this.f169e;
        if (i2 != 0 && i <= this.f167c[i2 - 1]) {
            c(i, e2);
            return;
        }
        if (this.f166b && this.f169e >= this.f167c.length) {
            d();
        }
        int i3 = this.f169e;
        if (i3 >= this.f167c.length) {
            int iB = e.b(i3 + 1);
            int[] iArr = new int[iB];
            Object[] objArr = new Object[iB];
            int[] iArr2 = this.f167c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f168d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f167c = iArr;
            this.f168d = objArr;
        }
        this.f167c[i3] = i;
        this.f168d[i3] = e2;
        this.f169e = i3 + 1;
    }

    public void b() {
        int i = this.f169e;
        Object[] objArr = this.f168d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f169e = 0;
        this.f166b = false;
    }

    public int c() {
        if (this.f166b) {
            d();
        }
        return this.f169e;
    }

    public int c(int i) {
        if (this.f166b) {
            d();
        }
        return this.f167c[i];
    }
}
