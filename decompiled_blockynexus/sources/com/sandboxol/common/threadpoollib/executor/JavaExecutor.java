package com.sandboxol.common.threadpoollib.executor;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class JavaExecutor implements Executor {
    private static JavaExecutor instance = new JavaExecutor();

    public static JavaExecutor getInstance() {
        return instance;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }
}
