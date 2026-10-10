package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.v;

/* JADX INFO: compiled from: SnackbarManager.java */
/* JADX INFO: loaded from: classes2.dex */
class u implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f13609a;

    u(v vVar) {
        this.f13609a = vVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f13609a.a((v.b) message.obj);
        return true;
    }
}
