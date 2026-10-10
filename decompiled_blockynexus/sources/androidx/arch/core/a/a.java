package androidx.arch.core.a;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Executor {
    a() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c.b().b(runnable);
    }
}
