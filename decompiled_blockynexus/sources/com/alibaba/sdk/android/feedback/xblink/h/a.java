package com.alibaba.sdk.android.feedback.xblink.h;

import com.alibaba.sdk.android.feedback.xblink.i.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3881a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f3883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f3884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExecutorService f3885e;

    static {
        int i = f3881a;
        f3882b = i + 1;
        f3883c = (i * 2) + 1;
    }

    private a() {
        this.f3885e = null;
        if (this.f3885e == null) {
            this.f3885e = new ThreadPoolExecutor(f3882b, f3883c, 500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    public static synchronized a a() {
        if (f3884d == null) {
            f3884d = new a();
        }
        return f3884d;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            g.e("WVThreadPool", "execute task is null.");
        } else {
            this.f3885e.execute(runnable);
        }
    }
}
