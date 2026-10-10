package com.sandboxol.common.threadpoollib.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidExecutor implements Executor {
    private static AndroidExecutor instance = new AndroidExecutor();
    private Handler main = new Handler(Looper.getMainLooper());

    static /* synthetic */ void a(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static AndroidExecutor getInstance() {
        return instance;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper() || runnable == null) {
            this.main.post(new Runnable() { // from class: com.sandboxol.common.threadpoollib.executor.a
                @Override // java.lang.Runnable
                public final void run() {
                    AndroidExecutor.a(runnable);
                }
            });
        } else {
            runnable.run();
        }
    }
}
