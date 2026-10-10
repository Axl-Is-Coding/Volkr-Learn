package bolts;

/* JADX INFO: compiled from: TaskCompletionSource.java */
/* JADX INFO: loaded from: classes.dex */
public class q<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p<TResult> f2862a = new p<>();

    public p<TResult> a() {
        return this.f2862a;
    }

    public boolean b(TResult tresult) {
        return this.f2862a.b(tresult);
    }

    public boolean c() {
        return this.f2862a.i();
    }

    public void a(TResult tresult) {
        if (!b(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean b(Exception exc) {
        return this.f2862a.b(exc);
    }

    public void b() {
        if (!c()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void a(Exception exc) {
        if (!b(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
