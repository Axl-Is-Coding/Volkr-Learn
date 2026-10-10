package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: ResourceRecycler.java */
/* JADX INFO: loaded from: classes.dex */
class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f4454b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: ResourceRecycler.java */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((C) message.obj).recycle();
            return true;
        }
    }

    F() {
    }

    synchronized void a(C<?> c2, boolean z) {
        if (this.f4453a || z) {
            this.f4454b.obtainMessage(1, c2).sendToTarget();
        } else {
            this.f4453a = true;
            c2.recycle();
            this.f4453a = false;
        }
    }
}
