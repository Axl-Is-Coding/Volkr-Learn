package com.bumptech.glide.request.target;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: PreloadTarget.java */
/* JADX INFO: loaded from: classes.dex */
class f implements Handler.Callback {
    f() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        ((g) message.obj).a();
        return true;
    }
}
