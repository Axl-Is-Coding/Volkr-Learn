package okhttp3.internal.cache;

import java.io.IOException;
import okio.Okio;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes5.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f23180a;

    d(g gVar) {
        this.f23180a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f23180a) {
            if ((!this.f23180a.o) || this.f23180a.p) {
                return;
            }
            try {
                this.f23180a.o();
            } catch (IOException unused) {
                this.f23180a.q = true;
            }
            try {
                if (this.f23180a.g()) {
                    this.f23180a.n();
                    this.f23180a.m = 0;
                }
            } catch (IOException unused2) {
                this.f23180a.r = true;
                this.f23180a.k = Okio.buffer(Okio.blackhole());
            }
        }
    }
}
