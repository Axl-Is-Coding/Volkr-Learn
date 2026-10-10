package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<View> f1201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Runnable f1202b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Runnable f1203c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1204d = -1;

    /* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
    static class a implements G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        F f1205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1206b;

        a(F f2) {
            this.f1205a = f2;
        }

        @Override // androidx.core.view.G
        public void a(View view) {
            Object tag = view.getTag(2113929216);
            G g = tag instanceof G ? (G) tag : null;
            if (g != null) {
                g.a(view);
            }
        }

        @Override // androidx.core.view.G
        @SuppressLint({"WrongConstant"})
        public void b(View view) {
            int i = this.f1205a.f1204d;
            if (i > -1) {
                view.setLayerType(i, null);
                this.f1205a.f1204d = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f1206b) {
                F f2 = this.f1205a;
                Runnable runnable = f2.f1203c;
                if (runnable != null) {
                    f2.f1203c = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                G g = tag instanceof G ? (G) tag : null;
                if (g != null) {
                    g.b(view);
                }
                this.f1206b = true;
            }
        }

        @Override // androidx.core.view.G
        public void c(View view) {
            this.f1206b = false;
            if (this.f1205a.f1204d > -1) {
                view.setLayerType(2, null);
            }
            F f2 = this.f1205a;
            Runnable runnable = f2.f1202b;
            if (runnable != null) {
                f2.f1202b = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            G g = tag instanceof G ? (G) tag : null;
            if (g != null) {
                g.c(view);
            }
        }
    }

    F(View view) {
        this.f1201a = new WeakReference<>(view);
    }

    public F a(long j) {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public F b(float f2) {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public void c() {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public F a(float f2) {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public long b() {
        View view = this.f1201a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public F a(Interpolator interpolator) {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public F b(long j) {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public void a() {
        View view = this.f1201a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public F a(G g) {
        View view = this.f1201a.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, g);
            } else {
                view.setTag(2113929216, g);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(View view, G g) {
        if (g != null) {
            view.animate().setListener(new D(this, g, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public F a(I i) {
        View view = this.f1201a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(i != null ? new E(this, i, view) : null);
        }
        return this;
    }
}
