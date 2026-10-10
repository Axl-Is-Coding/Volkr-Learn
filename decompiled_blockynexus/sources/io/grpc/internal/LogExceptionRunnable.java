package io.grpc.internal;

import com.google.common.base.m;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class LogExceptionRunnable implements Runnable {
    private static final Logger log = Logger.getLogger(LogExceptionRunnable.class.getName());
    private final Runnable task;

    public LogExceptionRunnable(Runnable runnable) {
        m.a(runnable);
        this.task = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.task.run();
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Exception while executing runnable " + this.task, th);
            if (!(th instanceof RuntimeException)) {
                throw new RuntimeException(th);
            }
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.task + ")";
    }
}
