package com.sandboxol.common.threadpoollib.config;

import com.sandboxol.common.threadpoollib.callback.AsyncListener;
import com.sandboxol.common.threadpoollib.callback.ThreadListener;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadConfigs {
    public AsyncListener asyncListener;
    public long delay;
    public Executor executor;
    public ThreadListener listener;
    public String threadName;
}
