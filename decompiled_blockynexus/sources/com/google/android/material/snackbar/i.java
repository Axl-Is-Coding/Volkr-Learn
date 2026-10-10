package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements Handler.Callback {
    i() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            ((BaseTransientBottomBar) message.obj).o();
            return true;
        }
        if (i != 1) {
            return false;
        }
        ((BaseTransientBottomBar) message.obj).b(message.arg1);
        return true;
    }
}
