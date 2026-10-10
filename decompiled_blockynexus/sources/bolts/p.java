package bolts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: Task.java */
/* JADX INFO: loaded from: classes.dex */
public class p<TResult> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile b f2858d;
    private boolean j;
    private boolean k;
    private TResult l;
    private Exception m;
    private boolean n;
    private r o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f2855a = g.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Executor f2856b = g.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f2857c = bolts.b.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static p<?> f2859e = new p<>((Object) null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static p<Boolean> f2860f = new p<>(true);
    private static p<Boolean> g = new p<>(false);
    private static p<?> h = new p<>(true);
    private final Object i = new Object();
    private List<i<TResult, Void>> p = new ArrayList();

    /* JADX INFO: compiled from: Task.java */
    public class a extends q<TResult> {
        a() {
        }
    }

    /* JADX INFO: compiled from: Task.java */
    public interface b {
        void a(p<?> pVar, UnobservedTaskException unobservedTaskException);
    }

    p() {
    }

    public static b e() {
        return f2858d;
    }

    private void j() {
        synchronized (this.i) {
            Iterator<i<TResult, Void>> it = this.p.iterator();
            while (it.hasNext()) {
                try {
                    it.next().then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.p = null;
        }
    }

    public Exception c() {
        Exception exc;
        synchronized (this.i) {
            if (this.m != null) {
                this.n = true;
                if (this.o != null) {
                    this.o.a();
                    this.o = null;
                }
            }
            exc = this.m;
        }
        return exc;
    }

    public TResult d() {
        TResult tresult;
        synchronized (this.i) {
            tresult = this.l;
        }
        return tresult;
    }

    public boolean f() {
        boolean z;
        synchronized (this.i) {
            z = this.k;
        }
        return z;
    }

    public boolean g() {
        boolean z;
        synchronized (this.i) {
            z = this.j;
        }
        return z;
    }

    public boolean h() {
        boolean z;
        synchronized (this.i) {
            z = c() != null;
        }
        return z;
    }

    boolean i() {
        synchronized (this.i) {
            if (this.j) {
                return false;
            }
            this.j = true;
            this.k = true;
            this.i.notifyAll();
            j();
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <TResult> p<TResult> a(TResult tresult) {
        if (tresult == 0) {
            return (p<TResult>) f2859e;
        }
        if (tresult instanceof Boolean) {
            return ((Boolean) tresult).booleanValue() ? (p<TResult>) f2860f : (p<TResult>) g;
        }
        q qVar = new q();
        qVar.a(tresult);
        return qVar.a();
    }

    public static <TResult> p<TResult>.a b() {
        return new a();
    }

    private p(TResult tresult) {
        b(tresult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void d(q<TContinuationResult> qVar, i<TResult, TContinuationResult> iVar, p<TResult> pVar, Executor executor, h hVar) {
        try {
            executor.execute(new m(hVar, qVar, iVar, pVar));
        } catch (Exception e2) {
            qVar.a(new ExecutorException(e2));
        }
    }

    public <TContinuationResult> p<TContinuationResult> b(i<TResult, p<TContinuationResult>> iVar, Executor executor, h hVar) {
        boolean zG;
        q qVar = new q();
        synchronized (this.i) {
            zG = g();
            if (!zG) {
                this.p.add(new k(this, qVar, iVar, executor, hVar));
            }
        }
        if (zG) {
            c(qVar, iVar, this, executor, hVar);
        }
        return qVar.a();
    }

    private p(boolean z) {
        if (z) {
            i();
        } else {
            b((Object) null);
        }
    }

    public static <TResult> p<TResult> a(Exception exc) {
        q qVar = new q();
        qVar.a(exc);
        return qVar.a();
    }

    public <TContinuationResult> p<TContinuationResult> c(i<TResult, TContinuationResult> iVar, Executor executor, h hVar) {
        return a(new l(this, hVar, iVar), executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <TContinuationResult, TResult> void c(q<TContinuationResult> qVar, i<TResult, p<TContinuationResult>> iVar, p<TResult> pVar, Executor executor, h hVar) {
        try {
            executor.execute(new o(hVar, qVar, iVar, pVar));
        } catch (Exception e2) {
            qVar.a(new ExecutorException(e2));
        }
    }

    public static <TResult> p<TResult> a() {
        return (p<TResult>) h;
    }

    public <TContinuationResult> p<TContinuationResult> a(i<TResult, TContinuationResult> iVar, Executor executor, h hVar) {
        boolean zG;
        q qVar = new q();
        synchronized (this.i) {
            zG = g();
            if (!zG) {
                this.p.add(new j(this, qVar, iVar, executor, hVar));
            }
        }
        if (zG) {
            d(qVar, iVar, this, executor, hVar);
        }
        return qVar.a();
    }

    public <TContinuationResult> p<TContinuationResult> b(i<TResult, TContinuationResult> iVar) {
        return c(iVar, f2856b, null);
    }

    boolean b(TResult tresult) {
        synchronized (this.i) {
            if (this.j) {
                return false;
            }
            this.j = true;
            this.l = tresult;
            this.i.notifyAll();
            j();
            return true;
        }
    }

    public <TContinuationResult> p<TContinuationResult> a(i<TResult, TContinuationResult> iVar) {
        return a(iVar, f2856b, null);
    }

    public <TContinuationResult> p<TContinuationResult> a(i<TResult, p<TContinuationResult>> iVar, Executor executor) {
        return b(iVar, executor, null);
    }

    boolean b(Exception exc) {
        synchronized (this.i) {
            if (this.j) {
                return false;
            }
            this.j = true;
            this.m = exc;
            this.n = false;
            this.i.notifyAll();
            j();
            if (!this.n && e() != null) {
                this.o = new r(this);
            }
            return true;
        }
    }
}
