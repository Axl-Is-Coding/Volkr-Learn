package com.sandboxol.common.threadpoollib.utils;

import com.sandboxol.common.threadpoollib.callback.ThreadListener;
import java.lang.Thread;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadToolUtils {
    public static boolean isAndroid;

    static {
        try {
            Class.forName("android.os.Build");
            isAndroid = true;
        } catch (Exception unused) {
            isAndroid = false;
        }
    }

    static /* synthetic */ void a(ThreadListener threadListener, String str, Thread thread, Throwable th) {
        if (threadListener != null) {
            threadListener.onError(str, th);
        }
    }

    public static void configThread(Thread thread, final String str, final ThreadListener threadListener) {
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.sandboxol.common.threadpoollib.utils.a
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                ThreadToolUtils.a(threadListener, str, thread2, th);
            }
        });
        thread.setName(str);
    }

    public static void sleepThread(long j) {
        if (j <= 0) {
            return;
        }
        try {
            Thread.sleep(j);
        } catch (InterruptedException e2) {
            throw new RuntimeException("Thread has been interrupted", e2);
        }
    }
}
