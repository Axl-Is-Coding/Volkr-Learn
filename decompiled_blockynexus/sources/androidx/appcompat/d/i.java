package androidx.appcompat.d;

import android.view.animation.Interpolator;
import androidx.core.view.F;
import androidx.core.view.G;
import androidx.core.view.H;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompatSet.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    G f395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f396e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f393b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final H f397f = new h(this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<F> f392a = new ArrayList<>();

    public i a(F f2) {
        if (!this.f396e) {
            this.f392a.add(f2);
        }
        return this;
    }

    void b() {
        this.f396e = false;
    }

    public void c() {
        if (this.f396e) {
            return;
        }
        for (F f2 : this.f392a) {
            long j = this.f393b;
            if (j >= 0) {
                f2.a(j);
            }
            Interpolator interpolator = this.f394c;
            if (interpolator != null) {
                f2.a(interpolator);
            }
            if (this.f395d != null) {
                f2.a(this.f397f);
            }
            f2.c();
        }
        this.f396e = true;
    }

    public i a(F f2, F f3) {
        this.f392a.add(f2);
        f3.b(f2.b());
        this.f392a.add(f3);
        return this;
    }

    public void a() {
        if (this.f396e) {
            Iterator<F> it = this.f392a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f396e = false;
        }
    }

    public i a(long j) {
        if (!this.f396e) {
            this.f393b = j;
        }
        return this;
    }

    public i a(Interpolator interpolator) {
        if (!this.f396e) {
            this.f394c = interpolator;
        }
        return this;
    }

    public i a(G g) {
        if (!this.f396e) {
            this.f395d = g;
        }
        return this;
    }
}
