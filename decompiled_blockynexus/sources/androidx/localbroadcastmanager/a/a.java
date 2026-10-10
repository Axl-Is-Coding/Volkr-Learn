package androidx.localbroadcastmanager.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: LocalBroadcastManager.java */
/* JADX INFO: loaded from: classes.dex */
class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f1642a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    a(b bVar, Looper looper) {
        super(looper);
        this.f1642a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            this.f1642a.a();
        }
    }
}
