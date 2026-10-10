package com.sandboxol.common.threadpoollib.callback;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class NormalListener implements AsyncListener, ThreadListener {
    private AsyncListener asyncListener;
    private ThreadListener listener;
    private Executor mainExecutor;

    public NormalListener(ThreadListener threadListener, AsyncListener asyncListener, Executor executor) {
        this.listener = threadListener;
        this.asyncListener = asyncListener;
        this.mainExecutor = executor;
    }

    public /* synthetic */ void a(Object obj) {
        try {
            this.asyncListener.onSuccess(obj);
        } catch (Throwable th) {
            onFailed(th);
        }
    }

    public /* synthetic */ void b(String str) {
        this.listener.onStart(str);
    }

    @Override // com.sandboxol.common.threadpoollib.callback.ThreadListener
    public void onError(final String str, final Throwable th) {
        onFailed(th);
        if (this.listener == null) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: com.sandboxol.common.threadpoollib.callback.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f16928a.a(str, th);
            }
        });
    }

    @Override // com.sandboxol.common.threadpoollib.callback.AsyncListener
    public void onFailed(final Throwable th) {
        if (this.asyncListener == null) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: com.sandboxol.common.threadpoollib.callback.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f16931a.a(th);
            }
        });
    }

    @Override // com.sandboxol.common.threadpoollib.callback.ThreadListener
    public void onFinished(final String str) {
        if (this.listener == null) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: com.sandboxol.common.threadpoollib.callback.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f16933a.a(str);
            }
        });
    }

    @Override // com.sandboxol.common.threadpoollib.callback.AsyncListener, com.sandboxol.common.threadpoollib.callback.ThreadListener
    public void onStart(final String str) {
        if (this.listener == null) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: com.sandboxol.common.threadpoollib.callback.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f16937a.b(str);
            }
        });
    }

    @Override // com.sandboxol.common.threadpoollib.callback.AsyncListener
    public void onSuccess(final Object obj) {
        if (this.asyncListener == null) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: com.sandboxol.common.threadpoollib.callback.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f16935a.a(obj);
            }
        });
    }

    public /* synthetic */ void a(Throwable th) {
        this.asyncListener.onFailed(th);
    }

    public /* synthetic */ void a(String str, Throwable th) {
        this.listener.onError(str, th);
    }

    public /* synthetic */ void a(String str) {
        this.listener.onFinished(str);
    }
}
