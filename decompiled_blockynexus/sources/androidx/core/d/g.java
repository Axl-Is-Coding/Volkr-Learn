package androidx.core.d;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
class g implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f1088a;

    g(k kVar) {
        this.f1088a = kVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.f1088a.a();
            return true;
        }
        if (i != 1) {
            return true;
        }
        this.f1088a.a((Runnable) message.obj);
        return true;
    }
}
