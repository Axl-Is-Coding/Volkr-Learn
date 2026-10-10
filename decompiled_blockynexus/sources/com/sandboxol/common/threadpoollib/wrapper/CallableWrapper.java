package com.sandboxol.common.threadpoollib.wrapper;

import com.sandboxol.common.threadpoollib.callback.NormalListener;
import com.sandboxol.common.threadpoollib.callback.ThreadListener;
import com.sandboxol.common.threadpoollib.config.ThreadConfigs;
import com.sandboxol.common.threadpoollib.utils.ThreadToolUtils;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class CallableWrapper<T> implements Callable<T> {
    private ThreadListener listener;
    private String name;
    private Callable<T> proxy;

    public CallableWrapper(ThreadConfigs threadConfigs, Callable<T> callable) {
        this.name = threadConfigs.threadName;
        this.proxy = callable;
        this.listener = new NormalListener(threadConfigs.listener, threadConfigs.asyncListener, threadConfigs.executor);
    }

    @Override // java.util.concurrent.Callable
    public T call() {
        ThreadToolUtils.configThread(Thread.currentThread(), this.name, this.listener);
        ThreadListener threadListener = this.listener;
        if (threadListener != null) {
            threadListener.onStart(this.name);
        }
        T tCall = null;
        try {
            try {
                if (this.proxy != null) {
                    tCall = this.proxy.call();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (this.listener != null) {
                    this.listener.onError(this.name, e2);
                }
                ThreadListener threadListener2 = this.listener;
                if (threadListener2 != null) {
                }
            }
            return tCall;
        } finally {
            ThreadListener threadListener3 = this.listener;
            if (threadListener3 != null) {
                threadListener3.onFinished(this.name);
            }
        }
    }
}
