package androidx.core.os;

import android.os.Build;
import android.os.CancellationSignal;

/* JADX INFO: compiled from: CancellationSignal.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC0013a f1186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f1187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1188d;

    /* JADX INFO: renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CancellationSignal.java */
    public interface InterfaceC0013a {
        void onCancel();
    }

    public void a() {
        synchronized (this) {
            if (this.f1185a) {
                return;
            }
            this.f1185a = true;
            this.f1188d = true;
            InterfaceC0013a interfaceC0013a = this.f1186b;
            Object obj = this.f1187c;
            if (interfaceC0013a != null) {
                try {
                    interfaceC0013a.onCancel();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f1188d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null && Build.VERSION.SDK_INT >= 16) {
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.f1188d = false;
                notifyAll();
            }
        }
    }

    public Object b() {
        Object obj;
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        synchronized (this) {
            if (this.f1187c == null) {
                this.f1187c = new CancellationSignal();
                if (this.f1185a) {
                    ((CancellationSignal) this.f1187c).cancel();
                }
            }
            obj = this.f1187c;
        }
        return obj;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.f1185a;
        }
        return z;
    }

    public void d() {
        if (c()) {
            throw new OperationCanceledException();
        }
    }
}
