package com.disabngo.blockynexus.utils.logic;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.messenger.Messenger;
import io.rong.imlib.relinker.ReLinker;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class B implements Runnable {
    B() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (com.sandboxol.messager.b.a.a(BaseApplication.getContext().getApplicationContext()).contains(":BlockmanGo")) {
                return;
            }
            ReLinker.loadLibrary(BaseApplication.getApp(), "sqlite");
            ReLinker.loadLibrary(BaseApplication.getApp(), "RongIMLib");
            Messenger.getDefault().sendNoMsg("message_load_so");
        } catch (Exception | VerifyError e2) {
            e2.printStackTrace();
        }
    }
}
