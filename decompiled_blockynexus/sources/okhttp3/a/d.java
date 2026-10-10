package okhttp3.a;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes5.dex */
class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f23111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f23112b;

    d(String str, boolean z) {
        this.f23111a = str;
        this.f23112b = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f23111a);
        thread.setDaemon(this.f23112b);
        return thread;
    }
}
