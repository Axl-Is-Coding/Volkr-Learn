package com.sandboxol.greendao.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.sandboxol.greendao.c.C;

/* JADX INFO: compiled from: BaseIDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C {
    private org.greenrobot.greendao.a dao;

    /* JADX INFO: compiled from: BaseIDbHelper.java */
    public interface a<T> {
        void onError(Throwable th);

        T onExecute();

        void onSuccess(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BaseIDbHelper.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f18415a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Handler f18416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f18417c;

        private b() {
            HandlerThread handlerThread = new HandlerThread("DbHelper-Thread");
            handlerThread.start();
            this.f18416b = new Handler(handlerThread.getLooper());
            this.f18417c = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> void c(final a<T> aVar) {
            this.f18416b.post(new Runnable() { // from class: com.sandboxol.greendao.c.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18484a.a(aVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> void d(final a<T> aVar) {
            this.f18416b.post(new Runnable() { // from class: com.sandboxol.greendao.c.f
                @Override // java.lang.Runnable
                public final void run() {
                    C.b.b(aVar);
                }
            });
        }

        static /* synthetic */ void b(a aVar) {
            try {
                aVar.onSuccess(aVar.onExecute());
            } catch (Exception e2) {
                e2.printStackTrace();
                aVar.onError(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Runnable runnable) {
            this.f18416b.post(runnable);
        }

        public /* synthetic */ void a(final a aVar) {
            try {
                final Object objOnExecute = aVar.onExecute();
                this.f18417c.post(new Runnable() { // from class: com.sandboxol.greendao.c.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.onSuccess(objOnExecute);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f18417c.post(new Runnable() { // from class: com.sandboxol.greendao.c.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        aVar.onError(e2);
                    }
                });
            }
        }
    }

    public C(final String str) {
        post(new Runnable() { // from class: com.sandboxol.greendao.c.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f18476a.a(str);
            }
        });
    }

    public /* synthetic */ void a(String str) {
        this.dao = init(str);
    }

    protected org.greenrobot.greendao.a getDao() {
        return this.dao;
    }

    protected abstract org.greenrobot.greendao.a init(String str);

    protected void post(Runnable runnable) {
        b.f18415a.a(runnable);
    }

    protected <T> void postSync(a<T> aVar) {
        b.f18415a.d(aVar);
    }

    protected <T> void post(a<T> aVar) {
        b.f18415a.c(aVar);
    }
}
