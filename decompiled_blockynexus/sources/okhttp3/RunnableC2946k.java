package okhttp3;

/* JADX INFO: renamed from: okhttp3.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConnectionPool.java */
/* JADX INFO: loaded from: classes5.dex */
class RunnableC2946k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2947l f23430a;

    RunnableC2946k(C2947l c2947l) {
        this.f23430a = c2947l;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            long jA = this.f23430a.a(System.nanoTime());
            if (jA == -1) {
                return;
            }
            if (jA > 0) {
                long j = jA / 1000000;
                long j2 = jA - (1000000 * j);
                synchronized (this.f23430a) {
                    try {
                        this.f23430a.wait(j, (int) j2);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }
}
