package com.sandboxol.center.provider;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public class MultiThreadHelper {

    public interface AsyncRun<T> {
        void onError(Throwable th);

        T onExecute();

        void onSuccess(T t);
    }

    static class Helper {
        private static final Helper instance = new Helper();
        private Handler handler;
        private Handler mainHandler;

        private Helper() {
            HandlerThread handlerThread = new HandlerThread("MutiThreadHelper");
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
            this.mainHandler = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void post(Runnable runnable) {
            this.handler.post(runnable);
        }

        public /* synthetic */ void a(final AsyncRun asyncRun) {
            try {
                final Object objOnExecute = asyncRun.onExecute();
                this.mainHandler.post(new Runnable() { // from class: com.sandboxol.center.provider.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        asyncRun.onSuccess(objOnExecute);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
                this.mainHandler.post(new Runnable() { // from class: com.sandboxol.center.provider.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        asyncRun.onError(e2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> void post(final AsyncRun<T> asyncRun) {
            this.handler.post(new Runnable() { // from class: com.sandboxol.center.provider.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16332a.a(asyncRun);
                }
            });
        }
    }

    public static void post(Runnable runnable) {
        Helper.instance.post(runnable);
    }

    public static <T> void post(AsyncRun<T> asyncRun) {
        Helper.instance.post(asyncRun);
    }
}
