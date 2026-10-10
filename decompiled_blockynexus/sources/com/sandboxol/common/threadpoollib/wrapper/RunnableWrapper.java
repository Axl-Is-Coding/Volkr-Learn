package com.sandboxol.common.threadpoollib.wrapper;

import com.sandboxol.common.threadpoollib.callback.NormalListener;
import com.sandboxol.common.threadpoollib.config.ThreadConfigs;
import com.sandboxol.common.threadpoollib.utils.ThreadToolUtils;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class RunnableWrapper implements Runnable {
    private Callable callable;
    private String name;
    private NormalListener normalListener;
    private Runnable runnable;

    public RunnableWrapper(ThreadConfigs threadConfigs) {
        this.name = threadConfigs.threadName;
        this.normalListener = new NormalListener(threadConfigs.listener, threadConfigs.asyncListener, threadConfigs.executor);
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadToolUtils.configThread(Thread.currentThread(), this.name, this.normalListener);
        this.normalListener.onStart(this.name);
        Runnable runnable = this.runnable;
        if (runnable != null) {
            runnable.run();
        } else {
            Callable callable = this.callable;
            if (callable != null) {
                try {
                    this.normalListener.onSuccess(callable.call());
                } catch (Exception e2) {
                    this.normalListener.onError(this.name, e2);
                }
            }
        }
        this.normalListener.onFinished(this.name);
    }

    public RunnableWrapper setCallable(Callable callable) {
        this.callable = callable;
        return this;
    }

    public RunnableWrapper setRunnable(Runnable runnable) {
        this.runnable = runnable;
        return this;
    }
}
