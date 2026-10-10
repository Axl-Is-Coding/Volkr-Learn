package androidx.core.d;

import android.os.Handler;
import androidx.core.d.k;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callable f1091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Handler f1092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ k.a f1093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f1094d;

    i(k kVar, Callable callable, Handler handler, k.a aVar) {
        this.f1094d = kVar;
        this.f1091a = callable;
        this.f1092b = handler;
        this.f1093c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object objCall;
        try {
            objCall = this.f1091a.call();
        } catch (Exception unused) {
            objCall = null;
        }
        this.f1092b.post(new h(this, objCall));
    }
}
