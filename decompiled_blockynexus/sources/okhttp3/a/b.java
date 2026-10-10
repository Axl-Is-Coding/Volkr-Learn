package okhttp3.a;

/* JADX INFO: compiled from: NamedRunnable.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f23085a;

    public b(String str, Object... objArr) {
        this.f23085a = e.a(str, objArr);
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f23085a);
        try {
            a();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
