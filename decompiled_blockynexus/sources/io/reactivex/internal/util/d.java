package io.reactivex.internal.util;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingIgnoringReceiver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends CountDownLatch implements io.reactivex.b.g<Throwable>, io.reactivex.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f22728a;

    public d() {
        super(1);
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) {
        this.f22728a = th;
        countDown();
    }

    @Override // io.reactivex.b.a
    public void run() {
        countDown();
    }
}
