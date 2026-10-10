package androidx.core.f;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class f<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f1155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1156b;

    public f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1155a = new Object[i];
    }

    private boolean b(T t) {
        for (int i = 0; i < this.f1156b; i++) {
            if (this.f1155a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.f.e
    public T a() {
        int i = this.f1156b;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.f1155a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.f1156b = i - 1;
        return t;
    }

    @Override // androidx.core.f.e
    public boolean a(T t) {
        if (!b(t)) {
            int i = this.f1156b;
            Object[] objArr = this.f1155a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.f1156b = i + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }
}
