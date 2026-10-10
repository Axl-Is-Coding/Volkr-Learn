package com.squareup.picasso;

import android.os.Message;
import com.squareup.picasso.q;

/* JADX INFO: renamed from: com.squareup.picasso.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2761p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Message f19301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q.a f19302b;

    RunnableC2761p(q.a aVar, Message message) {
        this.f19302b = aVar;
        this.f19301a = message;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new AssertionError("Unknown handler message received: " + this.f19301a.what);
    }
}
