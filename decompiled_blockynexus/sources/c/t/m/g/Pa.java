package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public abstract class Pa extends Qa {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f2985c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f2986d = null;

    /* JADX INFO: compiled from: TL */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                Pa.this.a(message);
            } catch (Throwable th) {
                Pa.this.c();
                C0458qa.a("handleInnerMessage error.", th);
            }
        }
    }

    public final int a(Looper looper) {
        synchronized (this.f2993b) {
            if (d()) {
                return -1;
            }
            this.f2992a = true;
            try {
                c();
                if (looper == null) {
                    this.f2985c = new HandlerThread("thread_" + c());
                    this.f2985c.start();
                    this.f2986d = new a(this.f2985c.getLooper());
                } else {
                    this.f2986d = new a(looper);
                }
                this.f2986d.getLooper();
                return a();
            } catch (Throwable th) {
                c();
                C0458qa.a("startup error.", th);
                return -1;
            }
        }
    }

    public abstract void a(Message message);

    public final void e() {
        synchronized (this.f2993b) {
            try {
                if (!this.f2992a) {
                    return;
                }
                this.f2992a = false;
                c();
                b();
                try {
                    Xa.a(this.f2985c, this.f2986d, 100L);
                    this.f2985c = null;
                    this.f2986d = null;
                } catch (Throwable th) {
                    c();
                    C0458qa.a("shutdown thread error.", th);
                }
            } catch (Throwable th2) {
                c();
                C0458qa.a("shutdown error.", th2);
            }
        }
    }

    public final boolean a(int i, long j) {
        return C0458qa.a(this.f2986d, i, j);
    }
}
