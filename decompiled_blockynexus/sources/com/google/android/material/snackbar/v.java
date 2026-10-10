package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes2.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static v f13610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f13611b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f13612c = new Handler(Looper.getMainLooper(), new u(this));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f13613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f13614e;

    /* JADX INFO: compiled from: SnackbarManager.java */
    interface a {
        void a(int i);

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SnackbarManager.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference<a> f13615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f13617c;

        b(int i, a aVar) {
            this.f13615a = new WeakReference<>(aVar);
            this.f13616b = i;
        }

        boolean a(a aVar) {
            return aVar != null && this.f13615a.get() == aVar;
        }
    }

    private v() {
    }

    static v a() {
        if (f13610a == null) {
            f13610a = new v();
        }
        return f13610a;
    }

    private boolean f(a aVar) {
        b bVar = this.f13613d;
        return bVar != null && bVar.a(aVar);
    }

    private boolean g(a aVar) {
        b bVar = this.f13614e;
        return bVar != null && bVar.a(aVar);
    }

    public void b(a aVar) {
        synchronized (this.f13611b) {
            if (f(aVar)) {
                this.f13613d = null;
                if (this.f13614e != null) {
                    b();
                }
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.f13611b) {
            if (f(aVar)) {
                b(this.f13613d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.f13611b) {
            if (f(aVar) && !this.f13613d.f13617c) {
                this.f13613d.f13617c = true;
                this.f13612c.removeCallbacksAndMessages(this.f13613d);
            }
        }
    }

    public void e(a aVar) {
        synchronized (this.f13611b) {
            if (f(aVar) && this.f13613d.f13617c) {
                this.f13613d.f13617c = false;
                b(this.f13613d);
            }
        }
    }

    public void a(int i, a aVar) {
        synchronized (this.f13611b) {
            if (f(aVar)) {
                this.f13613d.f13616b = i;
                this.f13612c.removeCallbacksAndMessages(this.f13613d);
                b(this.f13613d);
                return;
            }
            if (g(aVar)) {
                this.f13614e.f13616b = i;
            } else {
                this.f13614e = new b(i, aVar);
            }
            if (this.f13613d == null || !a(this.f13613d, 4)) {
                this.f13613d = null;
                b();
            }
        }
    }

    private void b() {
        b bVar = this.f13614e;
        if (bVar != null) {
            this.f13613d = bVar;
            this.f13614e = null;
            a aVar = this.f13613d.f13615a.get();
            if (aVar != null) {
                aVar.show();
            } else {
                this.f13613d = null;
            }
        }
    }

    private void b(b bVar) {
        int i = bVar.f13616b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 2750;
        }
        this.f13612c.removeCallbacksAndMessages(bVar);
        Handler handler = this.f13612c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), i);
    }

    public void a(a aVar, int i) {
        synchronized (this.f13611b) {
            if (f(aVar)) {
                a(this.f13613d, i);
            } else if (g(aVar)) {
                a(this.f13614e, i);
            }
        }
    }

    public boolean a(a aVar) {
        boolean z;
        synchronized (this.f13611b) {
            z = f(aVar) || g(aVar);
        }
        return z;
    }

    private boolean a(b bVar, int i) {
        a aVar = bVar.f13615a.get();
        if (aVar == null) {
            return false;
        }
        this.f13612c.removeCallbacksAndMessages(bVar);
        aVar.a(i);
        return true;
    }

    void a(b bVar) {
        synchronized (this.f13611b) {
            if (this.f13613d == bVar || this.f13614e == bVar) {
                a(bVar, 2);
            }
        }
    }
}
