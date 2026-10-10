package com.sandboxol.common.threadpoollib.callback;

/* JADX INFO: loaded from: classes.dex */
public interface ThreadListener {
    void onError(String str, Throwable th);

    void onFinished(String str);

    void onStart(String str);
}
