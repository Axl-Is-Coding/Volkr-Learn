package c.t.m.g;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: c.t.m.g.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC0424f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ boolean[] f3194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ CountDownLatch f3195b;

    RunnableC0424f(boolean[] zArr, CountDownLatch countDownLatch) {
        this.f3194a = zArr;
        this.f3195b = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3194a[0] = C0421e.b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f3195b.countDown();
    }
}
