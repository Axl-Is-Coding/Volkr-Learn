package com.squareup.picasso;

import android.os.Message;
import com.squareup.picasso.H;

/* JADX INFO: compiled from: Stats.java */
/* JADX INFO: loaded from: classes5.dex */
class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Message f19236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ H.a f19237b;

    G(H.a aVar, Message message) {
        this.f19237b = aVar;
        this.f19236a = message;
    }

    @Override // java.lang.Runnable
    public void run() {
        throw new AssertionError("Unhandled stats message." + this.f19236a.what);
    }
}
