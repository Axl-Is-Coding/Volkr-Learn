package zlc.season.rxdownload4.download.downloader;

import java.util.concurrent.Callable;
import okhttp3.J;
import zlc.season.rxdownload4.download.downloader.n;
import zlc.season.rxdownload4.download.downloader.q;

/* JADX INFO: compiled from: RangeDownloader.kt */
/* JADX INFO: loaded from: classes5.dex */
final class k<V> implements Callable<n.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n.a f23886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ J f23887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ q.c f23888c;

    k(n.a aVar, J j, q.c cVar) {
        this.f23886a = aVar;
        this.f23887b = j;
        this.f23888c = cVar;
    }

    @Override // java.util.concurrent.Callable
    public final n.b call() {
        return this.f23886a.a(this.f23887b, this.f23888c);
    }
}
