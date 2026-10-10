package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Object f1580a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f1581b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.arch.core.b.b<n<? super T>, LiveData<T>.a> f1582c = new androidx.arch.core.b.b<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1583d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f1584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f1585f;
    private int g;
    private boolean h;
    private boolean i;
    private final Runnable j;

    private abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final n<? super T> f1588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1590c = -1;

        a(n<? super T> nVar) {
            this.f1588a = nVar;
        }

        void a() {
        }

        void a(boolean z) {
            if (z == this.f1589b) {
                return;
            }
            this.f1589b = z;
            boolean z2 = LiveData.this.f1583d == 0;
            LiveData.this.f1583d += this.f1589b ? 1 : -1;
            if (z2 && this.f1589b) {
                LiveData.this.c();
            }
            LiveData liveData = LiveData.this;
            if (liveData.f1583d == 0 && !this.f1589b) {
                liveData.d();
            }
            if (this.f1589b) {
                LiveData.this.a(this);
            }
        }

        boolean a(g gVar) {
            return false;
        }

        abstract boolean b();
    }

    public LiveData() {
        Object obj = f1580a;
        this.f1584e = obj;
        this.f1585f = obj;
        this.g = -1;
        this.j = new k(this);
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f1589b) {
            if (!aVar.b()) {
                aVar.a(false);
                return;
            }
            int i = aVar.f1590c;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            aVar.f1590c = i2;
            aVar.f1588a.c((Object) this.f1584e);
        }
    }

    void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar != null) {
                b((a) aVar);
                aVar = null;
            } else {
                androidx.arch.core.b.b<n<? super T>, LiveData<T>.a>.d dVarC = this.f1582c.c();
                while (dVarC.hasNext()) {
                    b((a) dVarC.next().getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    protected void c() {
    }

    protected void d() {
    }

    class LifecycleBoundObserver extends LiveData<T>.a implements d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final g f1586e;

        LifecycleBoundObserver(g gVar, n<? super T> nVar) {
            super(nVar);
            this.f1586e = gVar;
        }

        @Override // androidx.lifecycle.e
        public void a(g gVar, Lifecycle.Event event) {
            if (this.f1586e.getLifecycle().a() == Lifecycle.State.DESTROYED) {
                LiveData.this.a((n) this.f1588a);
            } else {
                a(b());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean b() {
            return this.f1586e.getLifecycle().a().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a(g gVar) {
            return this.f1586e == gVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        void a() {
            this.f1586e.getLifecycle().b(this);
        }
    }

    protected void b(T t) {
        a("setValue");
        this.g++;
        this.f1584e = t;
        a((a) null);
    }

    public boolean b() {
        return this.f1583d > 0;
    }

    public void a(g gVar, n<? super T> nVar) {
        a("observe");
        if (gVar.getLifecycle().a() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, nVar);
        LiveData<T>.a aVarB = this.f1582c.b(nVar, lifecycleBoundObserver);
        if (aVarB != null && !aVarB.a(gVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (aVarB != null) {
            return;
        }
        gVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void a(n<? super T> nVar) {
        a("removeObserver");
        LiveData<T>.a aVarRemove = this.f1582c.remove(nVar);
        if (aVarRemove == null) {
            return;
        }
        aVarRemove.a();
        aVarRemove.a(false);
    }

    protected void a(T t) {
        boolean z;
        synchronized (this.f1581b) {
            z = this.f1585f == f1580a;
            this.f1585f = t;
        }
        if (z) {
            androidx.arch.core.a.c.b().b(this.j);
        }
    }

    public T a() {
        T t = (T) this.f1584e;
        if (t != f1580a) {
            return t;
        }
        return null;
    }

    private static void a(String str) {
        if (androidx.arch.core.a.c.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
