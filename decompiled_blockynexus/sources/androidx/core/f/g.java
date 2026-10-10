package androidx.core.f;

/* JADX INFO: compiled from: Pools.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T> extends f<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f1157c;

    public g(int i) {
        super(i);
        this.f1157c = new Object();
    }

    @Override // androidx.core.f.f, androidx.core.f.e
    public T a() {
        T t;
        synchronized (this.f1157c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // androidx.core.f.f, androidx.core.f.e
    public boolean a(T t) {
        boolean zA;
        synchronized (this.f1157c) {
            zA = super.a(t);
        }
        return zA;
    }
}
